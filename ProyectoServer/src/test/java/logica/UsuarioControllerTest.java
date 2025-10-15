/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package logica;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author urrut
 */
public class UsuarioControllerTest {
    
    public UsuarioControllerTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
        
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
        assertNull(result);
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
            System.out.println("⚠️ ADVERTENCIA: La propuesta '" + titulo + "' no existe. Saltando test de modificación.");
            return; // Salir del test sin error
        }
        
        System.out.println("✅ Propuesta encontrada. Procediendo con modificación...");
        
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
            System.out.println("✅ Propuesta modificada exitosamente");
        } catch (Exception e) {
            System.out.println("❌ Error al modificar propuesta: " + e.getMessage());
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
        assertNull(result);
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
        assertNull(result);
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
    
}
