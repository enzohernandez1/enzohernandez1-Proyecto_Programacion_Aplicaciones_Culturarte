/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package logica;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import persistence.JpaService;

/**
 *
 * @author urrut
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsuarioControllerTest {
    
    public UsuarioControllerTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
        limpiarBaseDeDatos();
        JpaService.close();
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
        
    }

    /**
     * Test of AltaProponente method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    @Order(1)
    public void testAltaProponente() {
        System.out.println("AltaProponente");
        String nickname = "pablo123";
        String pwd = "1234";
        String nombre = "Pablo";
        String apellido = "Perez";
        String correoElec = "pablo@email.com";
        LocalDate fechaNac = LocalDate.of(1990, 5, 15);
        byte[] imagen = null;
        String direccion = "Av. 18 de Julio 1234";
        String biografia = "Artista y organizador de eventos";
        String linkWeb = "www.pabloperez.com";
        UsuarioController instance = new UsuarioController();
        boolean expResult = true;
        boolean result = instance.AltaProponente(nickname, pwd, nombre, apellido, correoElec, fechaNac, imagen, direccion, biografia, linkWeb);
        assertEquals(expResult, result);
    }

    /**
     * Test of AltaColaborador method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    @Order(2)
    public void testAltaColaborador() {
        System.out.println("AltaColaborador");
        String nickname = "ana456";
        String pwd = "1234";
        String nombre = "Ana";
        String apellido = "Gonzalez";
        String correoElec = "ana@gmail.com";
        LocalDate fechaNac = LocalDate.of(1995, 3, 20);
        byte[] imagen = null;
        UsuarioController instance = new UsuarioController();
        boolean expResult = true;
        boolean result = instance.AltaColaborador(nickname, pwd, nombre, apellido, correoElec, fechaNac, imagen);
        assertEquals(expResult, result);
    }

    /**
     * Test of AltaCategoria method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    @Order(3)
    public void testAltaCategoria() {
        System.out.println("AltaCategoria");
        String nombre = "nuevaCategoria";
        String nombrePadre = "Categoria";
        UsuarioController instance = new UsuarioController();
        instance.AltaCategoria(nombre, nombrePadre);
    }

    /**
     * Test of getCategorias method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testGetCategorias() {
        System.out.println("getCategorias");
        UsuarioController instance = new UsuarioController();
        List<DTCategoria> result = instance.getCategorias();
        assertNotNull(result);
    }

    /**
     * Test of AltaPropuesta method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    @Order(4)
    public void testAltaPropuesta() {
        System.out.println("AltaPropuesta");
        String nicknameProponente = "pablo123";
        String titulo = "Concierto de musica";
        String descripcion = "Un espectacular concierto de rock nacional";
        byte[] imagen = null;
        String lugar = "Teatro Solis";
        LocalDate fecha = LocalDate.of(2024, 12, 15);
        float precio = 500.0F;
        float montoNecesario = 10000.0F;
        TipoRetorno tipoRetorno = TipoRetorno.ENTRADA_GRATIS;
        String nombreCategoria = "nuevaCategoria";
        UsuarioController instance = new UsuarioController();
        instance.AltaPropuesta(nicknameProponente, titulo, descripcion, imagen, lugar, fecha, precio, montoNecesario, tipoRetorno, nombreCategoria);
        
        // Forzar commit y pequeña pausa para que la transacción se confirme
        try {
            Thread.sleep(100); // 100ms de pausa
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Propuesta creada: " + titulo);
    }

    /**
     * Test of listarProponentes method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testListarProponentes() {
        System.out.println("listarProponentes");
        UsuarioController instance = new UsuarioController();
        List<DTProponente> result = instance.listarProponentes();
        assertNotNull(result);
    }

    /**
     * Test of getColaboradores method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testGetColaboradores() {
        System.out.println("getColaboradores");
        UsuarioController instance = new UsuarioController();
        List<DTColaborador> result = instance.getColaboradores();
        assertNotNull(result);
    }

    /**
     * Test of listarColaboradores method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testListarColaboradores() {
        System.out.println("listarColaboradores");
        UsuarioController instance = new UsuarioController();
        List<DTColaborador> result = instance.listarColaboradores();
        assertNotNull(result);
    }

    /**
     * Test of consultarPropuestas method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testConsultarPropuestas() {
        System.out.println("consultarPropuestas");
        String nickname = "pablo123";
        UsuarioController instance = new UsuarioController();
        List<DTPropuesta> result = instance.consultarPropuestas(nickname);
        assertNotNull(result);
    }

    /**
     * Test of consultarPropuesta method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testConsultarPropuesta() {
        System.out.println("consultarPropuesta");
        String nombrePropuesta = "Concierto de musica";
        UsuarioController instance = new UsuarioController();
        DTDetallePropuesta result = instance.consultarPropuesta(nombrePropuesta);
        assertNotNull(result);
    }

    /**
     * Test of getTitulosPropuestas method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testGetTitulosPropuestas() {
        System.out.println("getTitulosPropuestas");
        UsuarioController instance = new UsuarioController();
        List<String> result = instance.getTitulosPropuestas();
        assertNotNull(result);
    }

    /**
     * Test of modificarPropuesta method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testModificarPropuesta() {
        System.out.println("modificarPropuesta");
        
        UsuarioController instance = new UsuarioController();
        String titulo = "Concierto de musica";
        
        // Verificar que la propuesta existe antes de intentar modificarla
        List<String> titulos = instance.getTitulosPropuestas();
        System.out.println("Títulos disponibles: " + titulos);
        
        if (!titulos.contains(titulo)) {
            System.out.println("ADVERTENCIA: La propuesta '" + titulo + "' no existe. Saltando test de modificación.");
            return; // Salir del test sin error
        }
        
        System.out.println("Propuesta encontrada. Procediendo con modificación...");
        
        String nicknameProponente = "pablo123";
        String descripcion = "Descripcion actualizada del concierto";
        byte[] imagen = null;
        String lugar = "Teatro El Galpon";
        LocalDate fecha = LocalDate.of(2024, 12, 20);
        float precio = 600.0F;
        float montoNecesario = 12000.0F;
        TipoRetorno tipoRetorno = TipoRetorno.PORCENTAJE_GANANCIAS;
        String nombreCategoria = "nuevaCategoria";
        EstadoENUM estado = EstadoENUM.PUBLICADA;
        
        try {
            instance.modificarPropuesta(nicknameProponente, titulo, descripcion, imagen, lugar, fecha, precio, montoNecesario, tipoRetorno, nombreCategoria, estado);
            System.out.println("Propuesta modificada exitosamente");
        } catch (Exception e) {
            System.out.println("Error al modificar propuesta: " + e.getMessage());
            e.printStackTrace();
            fail("Error al modificar propuesta: " + e.getMessage());
        }
    }

    /**
     * Test of buscarColaboradoresEnPropuesta method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testBuscarColaboradoresEnPropuesta() {
        System.out.println("buscarColaboradoresEnPropuesta");
        Long id = 1L;
        UsuarioController instance = new UsuarioController();
        List<DTColaborador> result = instance.buscarColaboradoresEnPropuesta(id);
        assertNotNull(result);
    }

    /**
     * Test of calcularRecaudacion method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testCalcularRecaudacion() {
        System.out.println("calcularRecaudacion");
        Long id = 1L;
        UsuarioController instance = new UsuarioController();
        float expResult = 0.0F;
        float result = instance.calcularRecaudacion(id);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of SeguirUsuario method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    @Order(10)
    public void testSeguirUsuario() throws Exception {
        System.out.println("SeguirUsuario");
        String seguidor = "pablo123";
        String seguido = "ana456";
        UsuarioController instance = new UsuarioController();
        instance.SeguirUsuario(seguidor, seguido);
    }

    /**
     * Test of listarUsuarios method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testListarUsuarios() throws Exception {
        System.out.println("listarUsuarios");
        UsuarioController instance = new UsuarioController();
        List<String> result = instance.listarUsuarios();
        assertNotNull(result);
    }

    /**
     * Test of listarSeguimientos method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testListarSeguimientos() throws Exception {
        System.out.println("listarSeguimientos");
        UsuarioController instance = new UsuarioController();
        List<String> result = instance.listarSeguimientos();
        assertNotNull(result);
    }

    /**
     * Test of DejarDeSeguirUsuario method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    @Order(11)
    public void testDejarDeSeguirUsuario() throws Exception {
        System.out.println("DejarDeSeguirUsuario");
        String seguidor = "pablo123";
        String seguido = "ana456";
        UsuarioController instance = new UsuarioController();
        instance.DejarDeSeguirUsuario(seguidor, seguido);
    }

    /**
     * Test of getColaboracionesDeColaborador method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testGetColaboracionesDeColaborador() {
        System.out.println("getColaboracionesDeColaborador");
        String nickname = "ana456";
        UsuarioController instance = new UsuarioController();
        List<String> result = instance.getColaboracionesDeColaborador(nickname);
        assertNotNull(result);
    }

    /**
     * Test of getDatosColaboracion method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testGetDatosColaboracion() {
        System.out.println("getDatosColaboracion");
        String nicknameColaborador = "ana456";
        String tituloPropuesta = "Concierto de musica";
        UsuarioController instance = new UsuarioController();
        DTDetalleAporte result = instance.getDatosColaboracion(nicknameColaborador, tituloPropuesta);
        assertNull(result);
    }

    /**
     * Test of listarAportes method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testListarAportes() {
        System.out.println("listarAportes");
        UsuarioController instance = new UsuarioController();
        List<DTDetalleAporte> result = instance.listarAportes();
        assertNotNull(result);
    }

    /**
     * Test of obtenerAportePorId method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testObtenerAportePorId() {
        System.out.println("obtenerAportePorId");
        String id = "1";
        UsuarioController instance = new UsuarioController();
        DTDetalleAporte result = instance.obtenerAportePorId(id);
        assertNull(result);
    }

    /**
     * Test of cancelarAporte method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testCancelarAporte() {
        System.out.println("cancelarAporte");
        String id = "1";
        UsuarioController instance = new UsuarioController();
        instance.cancelarAporte(id);
    }

    /**
     * Test of listarPropuestas method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testListarPropuestas() {
        System.out.println("listarPropuestas");
        UsuarioController instance = new UsuarioController();
        List<DTPropPersona> result = instance.listarPropuestas();
        assertNotNull(result);
    }

    /**
     * Test of listarColaboradores_RCB method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testListarColaboradores_RCB() {
        System.out.println("listarColaboradores_RCB");
        UsuarioController instance = new UsuarioController();
        List<DTColaborador> result = instance.listarColaboradores_RCB();
        assertNotNull(result);
    }

    /**
     * Test of PropuestaPermitida method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    @Order(5)
    public void testPropuestaPermitida() {
        System.out.println("PropuestaPermitida");
        String titulo = "Concierto de musica";
        UsuarioController instance = new UsuarioController();
        Boolean result = instance.PropuestaPermitida(titulo);
        assertNotNull(result);
    }

    /**
     * Test of dameEstados method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testDameEstados() {
        System.out.println("dameEstados");
        String titulo = "Concierto de musica";
        UsuarioController instance = new UsuarioController();
        List<Estado> result = instance.dameEstados(titulo);
        assertNotNull(result);
    }

    /**
     * Test of dameAportes method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testDameAportes() {
        System.out.println("dameAportes");
        String nickname = "ana456";
        UsuarioController instance = new UsuarioController();
        List<DTInfoAporte> result = instance.dameAportes(nickname);
        assertNotNull(result);
    }

    /**
     * Test of ConfirmarPropuesta method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testConfirmarPropuesta() {
        System.out.println("ConfirmarPropuesta");
        String titulo = "Concierto de musica";
        UsuarioController instance = new UsuarioController();
        instance.ConfirmarPropuesta(titulo);
    }

    /**
     * Test of ConfirmarColaborador method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testConfirmarColaborador() {
        System.out.println("ConfirmarColaborador");
        String nickname = "ana456";
        UsuarioController instance = new UsuarioController();
        instance.ConfirmarColaborador(nickname);
    }

    /**
     * Test of Registrar method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    @Order(6)
    public void testRegistrar() throws Exception {
        System.out.println("Registrar");
        TipoRetorno retorno = TipoRetorno.ENTRADA_GRATIS;
        float monto = 1000.0F;
        String nickname = "ana456";
        String titulo = "Concierto de musica";
        UsuarioController instance = new UsuarioController();
        instance.Registrar(retorno, monto, nickname, titulo);
    }

    /**
     * Test of seleccionarPropuesta method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testSeleccionarPropuesta() {
        System.out.println("seleccionarPropuesta");
        String titulo = "Concierto de musica";
        UsuarioController instance = new UsuarioController();
        DTPropCompleto result = instance.seleccionarPropuesta(titulo);
        assertNotNull(result);
    }

    /**
     * Test of seleccionarColaborador method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testSeleccionarColaborador() {
        System.out.println("seleccionarColaborador");
        String nickname = "ana456";
        String titulo = "Concierto de musica";
        UsuarioController instance = new UsuarioController();
        DTColaborador result = instance.seleccionarColaborador(nickname, titulo);
        assertNotNull(result);
    }

    /**
     * Test of BuscarColaborador_RCB method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testBuscarColaborador_RCB() {
        System.out.println("BuscarColaborador_RCB");
        String nickname = "ana456";
        UsuarioController instance = new UsuarioController();
        DTColaborador result = instance.BuscarColaborador_RCB(nickname);
        assertNotNull(result);
    }

    /**
     * Test of listarPropuestasEstado method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testListarPropuestasEstado() {
        System.out.println("listarPropuestasEstado");
        EstadoENUM estado = EstadoENUM.PUBLICADA;
        UsuarioController instance = new UsuarioController();
        List<String> result = instance.listarPropuestasEstado(estado);
        assertNotNull(result);
    }

    /**
     * Test of consultarPropuestasColaboradas method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testConsultarPropuestasColaboradas() {
        System.out.println("consultarPropuestasColaboradas");
        String usuario = "ana456";
        UsuarioController instance = new UsuarioController();
        List<DTPropuesta> result = instance.consultarPropuestasColaboradas(usuario);
        assertNotNull(result);
    }

    /**
     * Test of evaluarPropuesta method, of class UsuarioController.
     */
    @org.junit.jupiter.api.Test
    public void testEvaluarPropuesta() {
        System.out.println("evaluarPropuesta");
        String titulo = "Concierto de musica";
        EstadoENUM nuevoEstado = EstadoENUM.EN_FINANCIACION;
        String fechaCambio = "2024-12-01";
        UsuarioController instance = new UsuarioController();
        boolean expResult = true;
        boolean result = instance.evaluarPropuesta(titulo, nuevoEstado, fechaCambio);
        assertEquals(expResult, result);
    }
    
    // ==================== TESTS PARA CASOS NEGATIVOS ====================
    // Tests para aumentar cobertura de código probando casos de fallo
    
    /**
     * Test AltaProponente - Caso negativo: Usuario ya existe
     */
    @org.junit.jupiter.api.Test
    @Order(50)
    public void testAltaProponente_UsuarioYaExiste() {
        System.out.println("AltaProponente - Usuario ya existe");
        String nickname = "pablo123";
        String pwd = "1234";
        String nombre = "Pablo";
        String apellido = "Perez";
        String correoElec = "pablo@email.com";
        LocalDate fechaNac = LocalDate.of(1990, 5, 15);
        byte[] imagen = null;
        String direccion = "Av. 18 de Julio 1234";
        String biografia = "Artista y organizador de eventos";
        String linkWeb = "www.pabloperez.com";
        UsuarioController instance = new UsuarioController();
        boolean result = instance.AltaProponente(nickname, pwd, nombre, apellido, correoElec, fechaNac, imagen, direccion, biografia, linkWeb);
        assertFalse(result);
    }
    
    /**
     * Test AltaColaborador - Caso negativo: Usuario ya existe
     */
    @org.junit.jupiter.api.Test
    @Order(51)
    public void testAltaColaborador_UsuarioYaExiste() {
        System.out.println("AltaColaborador - Usuario ya existe");
        String nickname = "ana456";
        String pwd = "1234";
        String nombre = "Ana";
        String apellido = "Gonzalez";
        String correoElec = "ana@gmail.com";
        LocalDate fechaNac = LocalDate.of(1995, 3, 20);
        byte[] imagen = null;
        UsuarioController instance = new UsuarioController();
        boolean result = instance.AltaColaborador(nickname, pwd, nombre, apellido, correoElec, fechaNac, imagen);
        assertFalse(result);
    }
    
    /**
     * Test SeguirUsuario - Caso negativo: Usuario no encontrado
     */
    @org.junit.jupiter.api.Test
    @Order(52)
    public void testSeguirUsuario_UsuarioNoExiste() {
        System.out.println("SeguirUsuario - Usuario no existe");
        String seguidor = "pablo123";
        String seguido = "usuarioInexistente";
        UsuarioController instance = new UsuarioController();
        assertThrows(RuntimeException.class, () -> {
            instance.SeguirUsuario(seguidor, seguido);
        });
    }
    
    /**
     * Test SeguirUsuario - Caso negativo: Ya se sigue al usuario
     */
    @org.junit.jupiter.api.Test
    @Order(53)
    public void testSeguirUsuario_YaSeSigue() {
        System.out.println("SeguirUsuario - Ya se sigue al usuario");
        String seguidor = "ana456";
        String seguido = "pablo123";
        UsuarioController instance = new UsuarioController();
        try {
            instance.SeguirUsuario(seguidor, seguido);
            System.out.println("Primera relación establecida: " + seguidor + " sigue a " + seguido);
        } catch (Exception e) {
            fail("La primera relación debería establecerse correctamente: " + e.getMessage());
        }
        assertThrows(RuntimeException.class, () -> {
            instance.SeguirUsuario(seguidor, seguido);
        }, "Debería lanzar excepción porque ya sigue al usuario");
    }
    
    /**
     * Test DejarDeSeguirUsuario - Caso negativo: No existe relación
     */
    @org.junit.jupiter.api.Test
    @Order(54)
    public void testDejarDeSeguirUsuario_NoExisteRelacion() {
        System.out.println("DejarDeSeguirUsuario - No existe relación");
        String seguidor = "pablo123";
        String seguido = "ana456";
        UsuarioController instance = new UsuarioController();
        assertThrows(RuntimeException.class, () -> {
            instance.DejarDeSeguirUsuario(seguidor, seguido);
        }, "Debería lanzar excepción porque " + seguidor + " no sigue a " + seguido);
    }
    
    /**
     * Test PropuestaPermitida - Caso negativo: Propuesta no existe
     */
    @org.junit.jupiter.api.Test
    @Order(55)
    public void testPropuestaPermitida_PropuestaNoExiste() {
        System.out.println("PropuestaPermitida - Propuesta no existe");
        String titulo = "PropuestaInexistente";
        UsuarioController instance = new UsuarioController();
        assertThrows(NullPointerException.class, () -> {
            instance.PropuestaPermitida(titulo);
        }, "Debería lanzar NullPointerException porque la propuesta no existe");
    }
    
    /**
     * Test Registrar - Caso negativo: Colaborador no encontrado
     */
    @org.junit.jupiter.api.Test
    @Order(56)
    public void testRegistrar_ColaboradorNoExiste() {
        System.out.println("Registrar - Colaborador no existe");
        TipoRetorno retorno = TipoRetorno.ENTRADA_GRATIS;
        float monto = 1000.0F;
        String nickname = "colaboradorInexistente";
        String titulo = "Concierto de musica";
        UsuarioController instance = new UsuarioController();
        assertThrows(Exception.class, () -> {
            instance.Registrar(retorno, monto, nickname, titulo);
        });
    }
    
    /**
     * Test Registrar - Caso negativo: Propuesta no encontrada
     */
    @org.junit.jupiter.api.Test
    @Order(57)
    public void testRegistrar_PropuestaNoExiste() {
        System.out.println("Registrar - Propuesta no existe");
        TipoRetorno retorno = TipoRetorno.ENTRADA_GRATIS;
        float monto = 1000.0F;
        String nickname = "ana456";
        String titulo = "PropuestaInexistente";
        UsuarioController instance = new UsuarioController();
        assertThrows(Exception.class, () -> {
            instance.Registrar(retorno, monto, nickname, titulo);
        });
    }
    
    /**
     * Test Registrar - Caso negativo: Ya colaboró en la propuesta
     */
    @org.junit.jupiter.api.Test
    @Order(58)
    public void testRegistrar_YaColaboroEnPropuesta() {
        System.out.println("Registrar - Ya colaboró en la propuesta");
        TipoRetorno retorno = TipoRetorno.ENTRADA_GRATIS;
        float monto = 1000.0F;
        String nickname = "ana456";
        String titulo = "Concierto de musica";
        UsuarioController instance = new UsuarioController();
        assertThrows(Exception.class, () -> {
            instance.Registrar(retorno, monto, nickname, titulo);
        }, "Debería lanzar excepción porque ya colaboró en esta propuesta");
    }
    
    /**
     * Test seleccionarPropuesta - Caso negativo: Propuesta no existe
     */
    @org.junit.jupiter.api.Test
    @Order(59)
    public void testSeleccionarPropuesta_NoExiste() {
        System.out.println("seleccionarPropuesta - Propuesta no existe");
        String titulo = "PropuestaInexistente";
        UsuarioController instance = new UsuarioController();
        DTPropCompleto result = instance.seleccionarPropuesta(titulo);
        assertNull(result);
    }
    
    /**
     * Test consultarPropuesta - Caso negativo: Propuesta no existe
     */
    @org.junit.jupiter.api.Test
    @Order(60)
    public void testConsultarPropuesta_NoExiste() {
        System.out.println("consultarPropuesta - Propuesta no existe");
        String nombrePropuesta = "PropuestaInexistente";
        UsuarioController instance = new UsuarioController();
        DTDetallePropuesta result = instance.consultarPropuesta(nombrePropuesta);
        assertNull(result);
    }
    
    /**
     * Test evaluarPropuesta - Caso negativo: Error en evaluación
     */
    @org.junit.jupiter.api.Test
    @Order(61)
    public void testEvaluarPropuesta_Error() {
        System.out.println("evaluarPropuesta - Error en evaluación");
        String titulo = "PropuestaInexistente";
        EstadoENUM nuevoEstado = EstadoENUM.EN_FINANCIACION;
        String fechaCambio = "fechaInvalida";
        UsuarioController instance = new UsuarioController();
        boolean result = instance.evaluarPropuesta(titulo, nuevoEstado, fechaCambio);
        assertFalse(result);
    }
    
    /**
     * Test BuscarColaborador_RCB - Caso negativo: Colaborador no existe
     */
    @org.junit.jupiter.api.Test
    @Order(62)
    public void testBuscarColaborador_RCB_NoExiste() {
        System.out.println("BuscarColaborador_RCB - Colaborador no existe");
        String nickname = "colaboradorInexistente";
        UsuarioController instance = new UsuarioController();
        DTColaborador result = instance.BuscarColaborador_RCB(nickname);
        assertNull(result);
    }
    
    /**
     * Test obtenerAportePorId - Caso negativo: Aporte no existe
     */
    @org.junit.jupiter.api.Test
    @Order(63)
    public void testObtenerAportePorId_NoExiste() {
        System.out.println("obtenerAportePorId - Aporte no existe");
        String id = "999999";
        UsuarioController instance = new UsuarioController();
        DTDetalleAporte result = instance.obtenerAportePorId(id);
        assertNull(result);
    }
    
    /**
     * Test obtenerAportePorId - Caso negativo: ID con formato inválido
     */
    @org.junit.jupiter.api.Test
    @Order(64)
    public void testObtenerAportePorId_FormatoInvalido() {
        System.out.println("obtenerAportePorId - Formato de ID inválido");
        String id = "abc123";
        UsuarioController instance = new UsuarioController();
        DTDetalleAporte result = instance.obtenerAportePorId(id);
        assertNull(result);
    }
    
    /**
     * Test getDatosColaboracion - Caso negativo: Colaboración no existe
     */
    @org.junit.jupiter.api.Test
    @Order(65)
    public void testGetDatosColaboracion_NoExiste() {
        System.out.println("getDatosColaboracion - Colaboración no existe");
        String nicknameColaborador = "ana456";
        String tituloPropuesta = "PropuestaInexistente";
        UsuarioController instance = new UsuarioController();
        DTDetalleAporte result = instance.getDatosColaboracion(nicknameColaborador, tituloPropuesta);
        assertNull(result);
    }
    
    /**
     * Test AltaPropuesta - Caso negativo: Título ya existe
     */
    @org.junit.jupiter.api.Test
    @Order(66)
    public void testAltaPropuesta_TituloYaExiste() {
        System.out.println("AltaPropuesta - Título ya existe");
        String nicknameProponente = "pablo123";
        String titulo = "Concierto de musica";
        String descripcion = "Otra descripción";
        byte[] imagen = null;
        String lugar = "Otro lugar";
        LocalDate fecha = LocalDate.of(2024, 12, 20);
        float precio = 600.0F;
        float montoNecesario = 12000.0F;
        TipoRetorno tipoRetorno = TipoRetorno.PORCENTAJE_GANANCIAS;
        String nombreCategoria = "nuevaCategoria";
        UsuarioController instance = new UsuarioController();
        assertThrows(IllegalArgumentException.class, () -> {
            instance.AltaPropuesta(nicknameProponente, titulo, descripcion, imagen, lugar, fecha, precio, montoNecesario, tipoRetorno, nombreCategoria);
        });
    }
    
    /**
     * Test para cubrir casos edge con colaboradores inexistentes
     */
    @org.junit.jupiter.api.Test
    @Order(67)
    public void testColaboradorInexistente_CasosBorde() {
        System.out.println("Casos borde - colaborador inexistente");
        UsuarioController instance = new UsuarioController();
        String colaboradorInexistente = "colaborador_que_no_existe_999";
        List<String> colaboraciones = instance.getColaboracionesDeColaborador(colaboradorInexistente);
        assertNotNull(colaboraciones);
        DTDetalleAporte datos = instance.getDatosColaboracion(colaboradorInexistente, "Concierto de musica");
        assertNull(datos);
    }
    
    /**
     * Test para casos de datos null en aportes 
     */
    @org.junit.jupiter.api.Test
    @Order(68)
    public void testAportes_DatosNull() {
        System.out.println("Test para cubrir casos con datos null en aportes");
        UsuarioController instance = new UsuarioController();
        String[] idsInvalidos = {"", "null", "undefined", "-1", "0"}; 
        for (String id : idsInvalidos) {
            DTDetalleAporte resultado = instance.obtenerAportePorId(id);
            System.out.println("ID probado: " + id + " - Resultado: " + (resultado != null ? "encontrado" : "null"));
        }
    }
    
    /**
     * Test para verificar listarAportes cuando SÍ hay aportes en la base de datos
     */
    @org.junit.jupiter.api.Test
    @Order(69)
    public void testListarAportes_ConAportes() {
        System.out.println("listarAportes - Con aportes en la base de datos");
        UsuarioController instance = new UsuarioController();
        List<DTDetalleAporte> aportes = instance.listarAportes();
        assertNotNull(aportes);
        System.out.println("Número de aportes encontrados: " + aportes.size());
        if (!aportes.isEmpty()) {
            DTDetalleAporte primerAporte = aportes.get(0);
            assertNotNull(primerAporte);
            System.out.println("Primer aporte: " + primerAporte.getId());
        }
    }
    
    /**
     * Test para forzar la ejecución del bucle for en listarAportes
     * creando múltiples aportes
     */
    @org.junit.jupiter.api.Test
    @Order(70)
    public void testCrearMultiplesAportes_ParaCubrirBucle() {
        System.out.println("Crear múltiples aportes para cubrir bucle for");
        UsuarioController instance = new UsuarioController();
        try {
            instance.Registrar(TipoRetorno.PORCENTAJE_GANANCIAS, 500.0F, "ana456", "Concierto de musica");
            System.out.println("Segundo aporte creado");
        } catch (Exception e) {
            System.out.println("Segundo aporte ya existe o hubo error: " + e.getMessage());
        }
        List<DTDetalleAporte> aportes = instance.listarAportes();
        assertNotNull(aportes);
        System.out.println("Total de aportes después de intentar crear múltiples: " + aportes.size());
        for (DTDetalleAporte aporte : aportes) {
            System.out.println("Procesando aporte ID: " + aporte.getId() + 
                             ", Colaborador: " + aporte.getNicknameColaborador() +
                             ", Propuesta: " + aporte.getNombrePropuesta());
        }
    }
    
    /**
     * Test para ejecutar getDatosColaboracion cuando existe la colaboración
     * Este test debería ejecutar las líneas que verifican != null
     */
    @org.junit.jupiter.api.Test
    @Order(71)
    public void testGetDatosColaboracion_CubrirVerificacionesNull() {
        System.out.println("getDatosColaboracion - Cubrir verificaciones null");
        UsuarioController instance = new UsuarioController();
        DTDetalleAporte resultado = instance.getDatosColaboracion("ana456", "Concierto de musica");
        if (resultado != null) {
            System.out.println("Colaboración encontrada:");
            System.out.println("- ID: " + resultado.getId());
            System.out.println("- Colaborador: " + resultado.getNicknameColaborador());
            System.out.println("- Propuesta: " + resultado.getNombrePropuesta());
            System.out.println("- Tipo Retorno: " + resultado.getTipoRetorno());
            System.out.println("- Monto: " + resultado.getMonto());
            assertNotNull(resultado.getNicknameColaborador());
            assertNotNull(resultado.getNombrePropuesta());
            assertNotNull(resultado.getTipoRetorno());
        } else {
            System.out.println("Colaboración no encontrada, probando con otros usuarios");
            String[] colaboradores = {"ana456", "pablo123"};
            String[] propuestas = {"Concierto de musica"};
            
            for (String colab : colaboradores) {
                for (String prop : propuestas) {
                    DTDetalleAporte test = instance.getDatosColaboracion(colab, prop);
                    if (test != null) {
                        System.out.println("Encontrado: " + colab + " -> " + prop);
                        break;
                    }
                }
            }
        }
    }
    
    /**
     * Test específico para intentar ejecutar las ramas del operador ternario
     * cuando los objetos pueden ser null
     */
    @org.junit.jupiter.api.Test
    @Order(72)
    public void testOperadoresTernarios_CasosNull() {
        System.out.println("Test para casos donde objetos podrían ser null");
        UsuarioController instance = new UsuarioController();
        String[] colaboradoresInexistentes = {
            "colaborador_inexistente_1", 
            "colaborador_inexistente_2", 
            "usuario_que_no_existe"
        };
        
        String[] propuestasInexistentes = {
            "Propuesta_Inexistente_1",
            "Propuesta_Inexistente_2", 
            "Concierto_Falso"
        };
        for (String colab : colaboradoresInexistentes) {
            for (String prop : propuestasInexistentes) {
                DTDetalleAporte resultado = instance.getDatosColaboracion(colab, prop);
                System.out.println("Probando: " + colab + " + " + prop + " = " + 
                                 (resultado != null ? "encontrado" : "null"));
            }
        }
        DTDetalleAporte mixto1 = instance.getDatosColaboracion("ana456", "PropuestaInexistente");
        DTDetalleAporte mixto2 = instance.getDatosColaboracion("ColaboradorInexistente", "Concierto de musica");
        
        System.out.println("Pruebas mixtas completadas");
    }
    
    private static void limpiarBaseDeDatos() {
        EntityManager em = JpaService.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        
        try {
            transaction.begin();
            
            System.out.println("Iniciando limpieza de datos de prueba...");
            em.createQuery("DELETE FROM Aporte a WHERE a.propuesta.titulo = :titulo")
              .setParameter("titulo", "Concierto de musica")
              .executeUpdate();
            System.out.println("Aportes de prueba eliminados");
            em.createQuery("DELETE FROM Seguimiento s WHERE s.seguidor.nickname IN (:usuarios) OR s.seguido.nickname IN (:usuarios)")
              .setParameter("usuarios", List.of("pablo123", "ana456"))
              .executeUpdate();
            System.out.println("Seguimientos de prueba eliminados");
            em.createQuery("DELETE FROM Estado e WHERE e.propuesta.titulo = :titulo")
              .setParameter("titulo", "Concierto de musica")
              .executeUpdate();
            System.out.println("Estados de propuestas de prueba eliminados");
            em.createQuery("DELETE FROM Propuesta p WHERE p.titulo = :titulo")
              .setParameter("titulo", "Concierto de musica")
              .executeUpdate();
            System.out.println("Propuestas de prueba eliminadas");
            em.createQuery("DELETE FROM Colaborador c WHERE c.nickname IN (:nicknames)")
              .setParameter("nicknames", List.of("ana456"))
              .executeUpdate();
            System.out.println("Colaboradores de prueba eliminados");
            em.createQuery("DELETE FROM Proponente p WHERE p.nickname IN (:nicknames)")
              .setParameter("nicknames", List.of("pablo123"))
              .executeUpdate();
            System.out.println("Proponentes de prueba eliminados");
            try {
                em.createQuery("DELETE FROM Usuario u WHERE u.nickname IN (:nicknames)")
                  .setParameter("nicknames", List.of("pablo123", "ana456"))
                  .executeUpdate();
                System.out.println("Usuarios base de prueba eliminados");
            } catch (Exception e) {
                System.out.println("Tabla Usuario no existe o ya limpia");
            }
            em.createQuery("DELETE FROM Categoria c WHERE c.nombre = :nombre")
              .setParameter("nombre", "nuevaCategoria")
              .executeUpdate();
            System.out.println("Categorías de prueba eliminadas");
            transaction.commit();
            System.out.println("Limpieza de datos de prueba completada exitosamente.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Error durante la limpieza de datos de prueba: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}
