package logica;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import persistence.JpaService;

public class UsuarioManager {

	public UsuarioManager() {} // REVISAR POSIBILIDAD DE UN MAIN MANAGER
	
	private static String hashear256(String texto) {
        MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        byte[] hashBytes = digest.digest(texto.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
	
	//------------------------------------------------------------------------------------------------------------------------------------------
		//OPPERS DE REGISTRAR COLABORACION A PROPUESTA
	//------------------------------------------------------------------------------------------------------------------------------------------
		public List<DTPropPersona> listarPropuestas(){
			EntityManager em = JpaService.getEntityManager();
			List<DTPropPersona> lista = new ArrayList<>();
			List<Proponente> proponentes = em.createQuery("SELECT p FROM Proponente p", Proponente.class).getResultList();
			for(Proponente p : proponentes) {
				if(!p.tienePropuesta(p)) {
					lista.add(new DTPropPersona(p));
				}else {
					lista.addAll(p.dameTitulos());
				}
			}
			return lista;
		}
		
		
		public DTPropCompleto seleccionarPropuesta(String titulo){
			EntityManager em = JpaService.getEntityManager();
			TypedQuery<Propuesta> q = em.createQuery("SELECT p FROM Propuesta p WHERE p.titulo = :titulo", Propuesta.class);
			 q.setParameter("titulo", titulo);
			Propuesta prop = q.getResultStream().findFirst().orElse(null);
			
			if(prop != null) {
			    return prop.getInfo();
			} else {
			    return null;
			}
			
		}
		
		public List<DTColaborador> listarColaboradores_RCB(){
			EntityManager em = JpaService.getEntityManager();
			List<Colaborador> lista = em.createQuery("SELECT c FROM Colaborador c",Colaborador.class).getResultList();
			List <DTColaborador> dtos = new ArrayList<>();
			for(Colaborador aux : lista) {
				DTColaborador colab = new DTColaborador();
				colab.setNickname(aux.getNickname());
				colab.setNombre(aux.getNombre());
				colab.setApellido(aux.getApellido());
				colab.setCorreo(aux.getCorreo());
				colab.setFechaNac(aux.getFecha());
				colab.setImagen(aux.getImagen());
				dtos.add(colab);
			}
			return dtos;
		}
		
		public DTColaborador seleccionarColaborador(String nickname, String titulo) {
			EntityManager em = JpaService.getEntityManager();
			Colaborador c = em.find(Colaborador.class, nickname);
			
			if(c == null) {
				return null;
			}
			
			DTColaborador dto = c.getInfo();
			  
			List<DTInfoAporte> aportesDTO = new ArrayList<>();
			for(Aporte a : c.getAporte()) {
				aportesDTO.add(new DTInfoAporte(
				a.getMonto(),
				a.getFecha(),
				a.getRetorno(),
				a.getTituloPropuesta()));
			}
			dto.setmisAportes(aportesDTO);
			return dto;
		}
		
		public void Registrar(TipoRetorno retorno, float monto, String nickname, String titulo) throws Exception{
			EntityManager em = JpaService.getEntityManager();
			
			Colaborador colab = em.find(Colaborador.class, nickname);
			Propuesta prop = em.createQuery("SELECT p FROM Propuesta p WHERE p.titulo = :titulo", Propuesta.class) //Hacemos consulta porque no es el id
	                   .setParameter("titulo", titulo)
	                   .getSingleResult();
			
			if(colab == null || prop == null) {
				throw new Exception("Colaborador o Propuesta no encontrados");
			}
			
			if(!colab.YaColaboro(prop.getTitulo())) {
				Aporte apt = new Aporte(monto, LocalDate.now(),retorno,colab,prop);
				em.getTransaction().begin();
				em.persist(apt);
				prop.AgregarAporte(apt);
				colab.agregarAporte(apt);
		        em.getTransaction().commit();
			}else {
				throw new Exception("Error: el colaborador ya colaboró en esa propuesta");
			}
		}
		
		public void confirmarPropuesta(String titulo) {
			EntityManager em = JpaService.getEntityManager();
	        
			TypedQuery<Propuesta> q = em.createQuery("SELECT p FROM Propuesta p WHERE p.titulo = :titulo",Propuesta.class);
			q.setParameter("titulo", titulo);
			Propuesta p = q.getResultStream().findFirst().orElse(null);
			
	        if (p != null) {
	            System.out.println("La propuesta seleccionada fue " + p.getTitulo()); //debbuger
	            em.getTransaction().begin();
	            em.merge(p);
	            em.getTransaction().commit();
	        }
	        
	    }
		
		 public void confirmarColaborador(String nickname) {
			EntityManager em = JpaService.getEntityManager();
		    Colaborador c = em.find(Colaborador.class, nickname);
		    if (c != null) {
		            System.out.println("El colaborador seleccionado fue " + c.getNickname()); //debbuger
		    }
 }
		 
		 public List<Estado> dameEstados(String titulo) {
			    EntityManager em = JpaService.getEntityManager();
			    
			    TypedQuery<Propuesta> q = em.createQuery(
			        "SELECT p FROM Propuesta p WHERE p.titulo = :titulo", Propuesta.class);
			    q.setParameter("titulo", titulo);
			    
			    Propuesta prop = q.getResultStream().findFirst().orElse(null);
			    
			    if (prop != null) {
			        return prop.getEstados();  
			    }
			    return new ArrayList<>();
			}
		 
		 public List<DTInfoAporte> dameAportes(String nickname){
			 EntityManager em = JpaService.getEntityManager();
			 Colaborador colab = em.find(Colaborador.class, nickname);
			 List<DTInfoAporte> aportesDTO = new ArrayList<>();
			 if(colab != null) {
				 for(Aporte a : colab.getAporte()) {
					 DTInfoAporte aux = new DTInfoAporte(
					 a.getMonto(),a.getFecha(),a.getRetorno(),a.getTituloPropuesta());
					 aportesDTO.add(aux);
				 }
			 }
			 return aportesDTO;
		 }
		 
		 
		 //auxiliar para la GUI
		 public DTColaborador BuscarColaborador_RCB(String nickname) {
			 EntityManager em = JpaService.getEntityManager();
			 
			 Colaborador aux = em.find(Colaborador.class, nickname);
			 
			 if(aux == null) {
				 return null;
			 }
			 
			 DTColaborador colabo = new DTColaborador();
			    colabo.setNickname(aux.getNickname());
			    colabo.setNombre(aux.getNombre());
			    colabo.setApellido(aux.getApellido());
			    colabo.setCorreo(aux.getCorreo());
			    colabo.setFechaNac(aux.getFecha());
			    colabo.setImagen(aux.getImagen());
			    
			    return colabo;
		 }
		
		 public Boolean PropuestaPermitida(String titulo) {
			 EntityManager em = JpaService.getEntityManager();
			 TypedQuery<Propuesta> q = em.createQuery("SELECT p FROM Propuesta p WHERE p.titulo = :titulo",Propuesta.class);
			 q.setParameter("titulo", titulo);
			 Propuesta p = q.getResultStream().findFirst().orElse(null);
			 
			 if(p.EstadoActual().getEstado() == EstadoENUM.PUBLICADA || p.EstadoActual().getEstado() == EstadoENUM.EN_FINANCIACION) {
				 return true;
			 }
			 return false;
		 }
//------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------
	
		 private boolean existePerfil(String nickname) {
				EntityManager em = JpaService.getEntityManager();
				List<Usuario> user = new ArrayList<>();
				try {
					String consulta = "FROM Usuario as u WHERE u.nickname = :nickname";
					Query<Usuario> query = (Query<Usuario>) em.createQuery(consulta, Usuario.class);
					query.setParameter("nickname", nickname);
					user = query.list();
				}catch (Exception e) {}
				em.close();
				return user.isEmpty();
			}

			public boolean AltaProponente(DTProponente DTprop) {
				if(!existePerfil(DTprop.getNickname())) {
					return false;
				}else {
					Proponente prop = new Proponente(
							DTprop.getNickname(),
							hashear256(DTprop.getPwd()),
							DTprop.getNombre(),
							DTprop.getApellido(),
							DTprop.getCorreo(),
							DTprop.getFecha(),
							DTprop.getImagen(),
							DTprop.getDireccion(),
							DTprop.getBiografia(),
							DTprop.getWeb()
							);
					EntityManager em = JpaService.getEntityManager();
					try {
						em.getTransaction().begin();
						em.persist(prop);
						em.getTransaction().commit();
						em.close();
					} catch (Exception e) {
						em.getTransaction().rollback();
					}
					em.close();
					return true;
				}
			}

			public boolean AltaColaborador(DTColaborador DTcol) {	
				if(!existePerfil(DTcol.getNickname())) {
					return false;
				}else {
					Colaborador col = new Colaborador(
							DTcol.getNickname(),
							hashear256(DTcol.getPwd()),
							DTcol.getNombre(),
							DTcol.getApellido(),
							DTcol.getCorreo(),
							DTcol.getFecha(),
							DTcol.getImagen()
							);
					EntityManager em = JpaService.getEntityManager();
					try {
						em.getTransaction().begin();
						em.persist(col);
						em.getTransaction().commit();
						em.close();
					} catch (Exception e) {
						em.getTransaction().rollback();
					}
					em.close();
					return true;
				}
				
			}

			public List<DTColaborador> listarColaboradores() {
				EntityManager em = JpaService.getEntityManager();
				List<DTColaborador> lista = new ArrayList<>();
				try {
					String consulta = "FROM Colaborador";
					Query<Colaborador> query = (Query<Colaborador>) em.createQuery(consulta, Colaborador.class);
					List<Colaborador> colaboradores = query.list();
					
					for (Colaborador col : colaboradores) {
						DTColaborador DTcol = new DTColaborador(
								col.getNickname(),
								col.getNombre(),
								col.getApellido(),
								col.getCorreo(),
								col.getFecha(),
								col.getImagen()
								);
						lista.add(DTcol);
					}
				}catch(Exception e) {}
				em.close();
				return lista;
			}
			public List<DTColaborador> getColaboradores() {
				EntityManager em = JpaService.getEntityManager();
				List<DTColaborador> lista = new ArrayList<>();
				try {
					List<Colaborador> colaboradores = em.createQuery("SELECT c FROM Colaborador c", Colaborador.class).getResultList();
					for (Colaborador col : colaboradores) {
						DTColaborador DTcol = new DTColaborador(
								col.getNickname(),
								col.getNombre(),
								col.getApellido(),
								col.getCorreo(),
								col.getFecha(),
								col.getImagen()
								);
						lista.add(DTcol);						
						}
				}catch (Exception e) {}
				em.close();
				return lista;
			}

			public List<DTProponente> listarProponentes() {

				EntityManager em = JpaService.getEntityManager();
				List<DTProponente> lista = new ArrayList<>();
				try {
					String consulta = "FROM Proponente";
					Query<Proponente> query = (Query<Proponente>) em.createQuery(consulta, Proponente.class);
					List<Proponente> proponentes = query.list();
					
					
					for (Proponente prop : proponentes) {
						DTProponente DTprop = new DTProponente(
								prop.getNickname(), 
								prop.getNombre(), 
								prop.getApellido(), 
								prop.getCorreo(), 
								prop.getFecha(),
								prop.getImagen(),
								prop.getDireccion(),
								prop.getBiografia(),
								prop.getWeb()
								);
						lista.add(DTprop);
					}
				}catch (Exception e) {}
				em.close();
				return lista;
			}

			public List<DTCategoria> getCategorias() {
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("mi-proyecto");
				EntityManager em = emf.createEntityManager();
				List<DTCategoria> dtCategorias = new ArrayList<>();
				try {
					List<Categoria> categorias = em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
					for (Categoria cat : categorias) {
						String nombrePadre = cat.getPadre() != null ? cat.getPadre().getNombre() : null;
						dtCategorias.add(new DTCategoria(cat.getNombre(), nombrePadre));
					}
				} finally {
					em.close();
					emf.close();
				}
				return dtCategorias;
			}

			public void AltaCategoria(DTCategoria DTcat) {
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("mi-proyecto");
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				Categoria padre = null;
				if (DTcat.getNombrePadre() != null) {
					List<Categoria> padres = em.createQuery("SELECT c FROM Categoria c WHERE c.nombre = :nombre", Categoria.class)
							.setParameter("nombre", DTcat.getNombrePadre())
							.getResultList();
					if (!padres.isEmpty()) {
						padre = padres.get(0);
					}
				}
				Categoria nueva = new Categoria(DTcat.getNombre(), padre);
				em.persist(nueva);
				em.getTransaction().commit();
				em.close();
				emf.close();
			}

			public void AltaPropuesta(DTPropuesta DTProp) {

			EntityManager em = JpaService.getEntityManager();
			try {
				// Comprobación de título duplicado
				TypedQuery<Propuesta> q = em.createQuery("SELECT p FROM Propuesta p WHERE p.titulo = :titulo", Propuesta.class);
				q.setParameter("titulo", DTProp.getTitulo());
				Propuesta existente = q.getResultStream().findFirst().orElse(null);
				if (existente != null) {
					throw new IllegalArgumentException("El título de la propuesta ya existe");
				}
				Proponente proponente = em.createQuery(
					"SELECT p FROM Proponente p WHERE p.nickname = :nick", Proponente.class)
					.setParameter("nick", DTProp.getNicknameProponente())
					.getSingleResult();

			    Categoria categoria = em.createQuery(
				    "SELECT c FROM Categoria c WHERE c.nombre = :nombre", Categoria.class)
				    .setParameter("nombre", DTProp.getNombreCategoria())
				    .getSingleResult();

			    Propuesta prop = new Propuesta(
				    DTProp.getTitulo(),
				    DTProp.getDescripcion(),
				    DTProp.getImagen(),
				    DTProp.getLugar(),
				    DTProp.getFecha(),
				    DTProp.getPrecio(),
				    DTProp.getMontoNecesario(),
				    DTProp.getTipoRetorno(),
				    proponente,
				    categoria
				    );

			    em.getTransaction().begin();
			    em.persist(prop);
			    em.getTransaction().commit();
			} finally {
			    em.close();
			}
			}

			public List<String> getTitulosPropuestas() {
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("mi-proyecto");
				EntityManager em = emf.createEntityManager();
				List<String> titulos = new java.util.ArrayList<>();
				try {
					List<Propuesta> propuestas = em.createQuery("SELECT p FROM Propuesta p", Propuesta.class).getResultList();
					for (Propuesta p : propuestas) {
						titulos.add(p.getTitulo());
					}
				} finally {
					em.close();
					emf.close();
				}
				return titulos;
			}

			public DTDetallePropuesta consultarPropuesta(String nombrePropuesta) {
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("mi-proyecto");
				EntityManager em = emf.createEntityManager();
				DTDetallePropuesta detalle = null;
				try {
					Propuesta propuesta = em.createQuery(
							"SELECT p FROM Propuesta p WHERE p.titulo = :titulo", Propuesta.class)
							.setParameter("titulo", nombrePropuesta)
							.getSingleResult();

					String proponente = propuesta.getProponente() != null ? propuesta.getProponente().getNickname() : null;
					String tipoEspectaculo = propuesta.getTipoEspectaculo() != null ? propuesta.getTipoEspectaculo().getNombre() : null;
					String lugar = propuesta.getLugar();
					String fecha = propuesta.getFecha() != null ? propuesta.getFecha().toString() : null;
					String fechaPublicacion = propuesta.getFechaPublicacion() != null ? propuesta.getFechaPublicacion().toString() : null;
					float precio = propuesta.getPrecio();
					float montoNecesario = propuesta.getMontoNecesario();
					float montoRecaudado = 0f;
					if (propuesta.getAportes() != null) {
						for (Aporte aporte : propuesta.getAportes()) {
							montoRecaudado += aporte.getMonto();
						}
					}
					String estado = propuesta.getEstadoActual() != null ? propuesta.getEstadoActual().getEstado().name() : null;
					String descripcion = propuesta.getDescripcion();
					byte[] imagen = propuesta.getImagen();
					List<String> colaboradores = new java.util.ArrayList<>();
					if (propuesta.getAportes() != null) {
						for (Aporte aporte : propuesta.getAportes()) {
							if (aporte.getColaborador() != null) {
								colaboradores.add(aporte.getColaborador().getNickname());
							}
						}
					}
			    String tipoRetorno = propuesta.getTipoRetorno() != null ? propuesta.getTipoRetorno().name() : null;
			    detalle = new DTDetallePropuesta(
				    propuesta.getTitulo(),
				    proponente,
				    tipoEspectaculo,
				    lugar,
				    fecha,
				    fechaPublicacion,
				    precio,
				    montoNecesario,
				    montoRecaudado,
				    estado,
				    descripcion,
				    imagen,
				    colaboradores,
				    tipoRetorno
			    );
				} catch (Exception e) {
					detalle = null;
				} finally {
					em.close();
					emf.close();
				}
				return detalle;
			}

			public void modificarPropuesta(DTPropuesta DTProp, EstadoENUM estado) {
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("mi-proyecto");
				EntityManager em = emf.createEntityManager();
				try {
					em.getTransaction().begin();
					Propuesta propuesta = em.createQuery(
							"SELECT p FROM Propuesta p WHERE p.titulo = :titulo", Propuesta.class)
							.setParameter("titulo", DTProp.getTitulo())
							.getSingleResult();

					propuesta.setDescripcion(DTProp.getDescripcion());
					propuesta.setImagen(DTProp.getImagen());
					propuesta.setLugar(DTProp.getLugar());
					propuesta.setFecha(DTProp.getFecha());
					propuesta.setPrecio(DTProp.getPrecio());
					propuesta.setMontoNecesario(DTProp.getMontoNecesario());
					propuesta.setTipoRetorno(DTProp.getTipoRetorno());

					if (DTProp.getNombreCategoria() != null) {
						Categoria categoria = em.createQuery(
								"SELECT c FROM Categoria c WHERE c.nombre = :nombre", Categoria.class)
								.setParameter("nombre", DTProp.getNombreCategoria())
								.getSingleResult();
						propuesta.setCategoria(categoria);
					}

					propuesta.cambiarEstado(estado);

					em.getTransaction().commit();
				} catch (Exception e) {
					em.getTransaction().rollback();
					throw e;
				} finally {
					em.close();
					emf.close();
				}
			}
			
			// LISTAR PROPUESTAS DE PROPONENTE | CASO DE USO CONSULTAR PERFIL DE PROPONENTE

			public List<DTPropuesta> consultarPropuestas(String nickname) {
				EntityManager em = JpaService.getEntityManager();
				List<DTPropuesta> lista = new ArrayList<>();
				try {
					String consulta = "FROM Propuesta AS prop WHERE prop.proponente.nickname = :nickname";
					Query<Propuesta> query = (Query<Propuesta>) em.createQuery(consulta, Propuesta.class);
					query.setParameter("nickname", nickname);
					List<Propuesta> propuestas = query.list();
					
					for (Propuesta prop : propuestas) {
						DTPropuesta DTprop = new DTPropuesta(
								prop.getID(),
								prop.getProponente().getNickname(),
								prop.getTitulo(),
								prop.getDescripcion(),
								prop.getImagen(),
								prop.getLugar(),
								prop.getFecha(),
								prop.getPrecio(),
								prop.getMontoNecesario(),
								prop.getTipoRetorno(),
								prop.getTipoEspectaculo().getNombre(),
								prop.getEstadoActual()
								);
						lista.add(DTprop);
					}
				}catch (Exception e) {
					System.out.println("Error en la base de datos");
				}
				em.close();
				return lista;
			}

			public List<DTColaborador> buscarColaboradoresEnPropuesta(Long propId) {
				
				EntityManager em = JpaService.getEntityManager();
				List<DTColaborador> lista = new ArrayList<>();
				try {
					String consulta = "SELECT a FROM Aporte a WHERE a.propuesta.id = :propId";
					Query<Aporte> query = (Query<Aporte>) em.createQuery(consulta, Aporte.class);
					query.setParameter("propId", propId);
					List<Aporte> aportes = query.list();
					System.out.println("Número de Aportes encontrados: " + aportes.size());
					
					lista = new ArrayList<>();
					for (Aporte ap : aportes) {
						DTColaborador DTcol = new DTColaborador(ap.getColaborador().getNickname());
						lista.add(DTcol);
					}
				}catch (Exception e) {}
				em.close();
				return lista;
			}
			////////////////////////////////////


			public float calcularRecaudacion(Long id) {
				EntityManager em = JpaService.getEntityManager();
				float recaudacion = 0;
				List<Aporte> aportes = new ArrayList<>();
				try {
					String consulta = "FROM Aporte as ap WHERE ap.propuesta.id = :id";
					Query<Aporte> query = (Query<Aporte>) em.createQuery(consulta, Aporte.class);
					query.setParameter("id", id);
					aportes = query.list();
					for (Aporte ap : aportes) {
						recaudacion = recaudacion + ap.getMonto();
					}
				}catch (Exception e) {
				}
				
				em.close();
				return recaudacion;
			}



			public List<String> listarSeguimientos() {
				EntityManager em = JpaService.getEntityManager();
				try {
					List<Seguimiento> seguimientos = em.createQuery(
							"SELECT s FROM Seguimiento s", Seguimiento.class)
							.getResultList();

					List<String> resultados = new ArrayList<>();
					for (Seguimiento seg : seguimientos) {
						String relacion = seg.seguidor.getNickname() + " sigue a " + seg.seguido.getNickname();
						resultados.add(relacion);
					}
					return resultados;

				} finally {
					em.close();
				}
			}

			public void SeguirUsuario(DTSeguidores dtSeg) {
				EntityManager em = JpaService.getEntityManager();
				try {
					em.getTransaction().begin();


					Long count = em.createQuery(
							"SELECT COUNT(s) FROM Seguimiento s WHERE s.seguidor.nickname = :seguidor AND s.seguido.nickname = :seguido", 
							Long.class)
							.setParameter("seguidor", dtSeg.seguidorNickname)
							.setParameter("seguido", dtSeg.seguidoNickname)
							.getSingleResult();

					if (count > 0) {
						throw new RuntimeException(dtSeg.seguidorNickname + " ya sigue a " + dtSeg.seguidoNickname);
					}


					Usuario seguidor = em.find(Usuario.class, dtSeg.seguidorNickname);
					Usuario seguido = em.find(Usuario.class, dtSeg.seguidoNickname);

					if (seguidor == null || seguido == null) {
						throw new RuntimeException("Usuario no encontrado");
					}


					Seguimiento seguimiento = new Seguimiento(seguidor, seguido);
					em.persist(seguimiento);

					em.getTransaction().commit();

				} catch (Exception e) {
					em.getTransaction().rollback();
					throw new RuntimeException("Error al seguir usuario: " + e.getMessage());
				} finally {
					em.close();
				}
			}

			public List<String> listarUsuarios() {
				EntityManager em = JpaService.getEntityManager();
				try {
					return em.createQuery(
							"SELECT u.nickname FROM Usuario u ORDER BY u.nickname", String.class)
							.getResultList();
				} catch (Exception e) {
					throw new RuntimeException("Error al listar usuarios: " + e.getMessage());
				} finally {
					em.close();
				}
			}
			public void DejarDeSeguirUsuario(String seguidorNick, String seguidoNick) {
				EntityManager em = JpaService.getEntityManager();
				try {
					em.getTransaction().begin();

					List<Seguimiento> seguimientos = em.createQuery(
							"SELECT s FROM Seguimiento s WHERE s.seguidor.nickname = :seguidor AND s.seguido.nickname = :seguido", 
							Seguimiento.class)
							.setParameter("seguidor", seguidorNick)
							.setParameter("seguido", seguidoNick)
							.getResultList();

					if (seguimientos.isEmpty()) {
						throw new RuntimeException(seguidorNick + " no sigue a " + seguidoNick);
					}


					for (Seguimiento seg : seguimientos) {
						em.remove(seg);
					}

					em.getTransaction().commit();

				} catch (Exception e) {
					em.getTransaction().rollback();
					throw new RuntimeException("Error al dejar de seguir: " + e.getMessage());
				} finally {
					em.close();
				}
			}

			public List<String> getColaboracionesDeColaborador(String nickname) {
				EntityManager em = JpaService.getEntityManager();
				List<String> propuestas = new ArrayList<>();
				try {
					List<Aporte> aportes = em.createQuery(
							"SELECT a FROM Aporte a WHERE a.colaborador.nickname = :nick", Aporte.class)
							.setParameter("nick", nickname)
							.getResultList();
					for (Aporte aporte : aportes) {
						if (aporte.getPropuesta() != null) {
							propuestas.add(aporte.getPropuesta().getTitulo());
						}
					}
				} finally {
					em.close();
				}
				return propuestas;
			}

			public DTDetalleAporte getDatosColaboracion(String nicknameColaborador, String tituloPropuesta) {
				EntityManager em = JpaService.getEntityManager();
				try {
					Aporte aporte = em.createQuery(
						"SELECT a FROM Aporte a WHERE a.colaborador.nickname = :nick AND a.propuesta.titulo = :titulo", Aporte.class)
						.setParameter("nick", nicknameColaborador)
						.setParameter("titulo", tituloPropuesta)
						.getSingleResult();
					if (aporte == null) return null;
					String nickname = (aporte.getColaborador() != null) ? aporte.getColaborador().getNickname() : "";
					String nombrePropuesta = (aporte.getPropuesta() != null) ? aporte.getPropuesta().getTitulo() : "";
					String tipoRetorno = (aporte.getRetorno() != null) ? aporte.getRetorno().toString() : "";
					return new DTDetalleAporte(
						aporte.getId().toString(),
						nickname,
						nombrePropuesta,
						aporte.getFecha(),
						aporte.getMonto(),
						tipoRetorno
					);
				} catch (Exception e) {
					return null;
				} finally {
					em.close();
				}
			}

			public List<DTDetalleAporte> listarAportes() {
				EntityManager em = JpaService.getEntityManager();
				List<DTDetalleAporte> lista = new ArrayList<>();
				try {
					List<Aporte> aportes = em.createQuery("SELECT a FROM Aporte a", Aporte.class).getResultList();
					for (Aporte aporte : aportes) {
						String nickname = (aporte.getColaborador() != null) ? aporte.getColaborador().getNickname() : "";
						String nombrePropuesta = (aporte.getPropuesta() != null) ? aporte.getPropuesta().getTitulo() : "";
						String tipoRetorno = (aporte.getRetorno() != null) ? aporte.getRetorno().toString() : "";
						lista.add(new DTDetalleAporte(
							aporte.getId().toString(),
							nickname,
							nombrePropuesta,
							aporte.getFecha(),
							aporte.getMonto(),
							tipoRetorno
						));
					}
				} finally {
					em.close();
				}
				return lista;
			}

		    public DTDetalleAporte obtenerAportePorId(String id) {
				EntityManager em = JpaService.getEntityManager();
				try {
					Long idLong;
					try {
						idLong = Long.parseLong(id);
					} catch (NumberFormatException e) {
						return null;
					}
					Aporte aporte = em.find(Aporte.class, idLong);
					if (aporte == null) return null;
					String nickname = (aporte.getColaborador() != null) ? aporte.getColaborador().getNickname() : "";
					String nombrePropuesta = (aporte.getPropuesta() != null) ? aporte.getPropuesta().getTitulo() : "";
					String tipoRetorno = (aporte.getRetorno() != null) ? aporte.getRetorno().toString() : "";
					return new DTDetalleAporte(
						aporte.getId().toString(),
						nickname,
						nombrePropuesta,
						aporte.getFecha(),
						aporte.getMonto(),
						tipoRetorno
					);
				} finally {
					em.close();
				}
		    }

		    public void cancelarAporte(String id) {
				EntityManager em = JpaService.getEntityManager();
				try {
					em.getTransaction().begin();
					Long idLong;
					try {
						idLong = Long.parseLong(id);
					} catch (NumberFormatException e) {
						em.getTransaction().rollback();
						return;
					}
					Aporte aporte = em.find(Aporte.class, idLong);
					if (aporte != null) {
						em.remove(aporte);
					}
					em.getTransaction().commit();
				} catch (Exception e) {
					em.getTransaction().rollback();
				} finally {
					em.close();
				}
		    }
		    
		    public List<String> listarPropuestasEstado(EstadoENUM estado) {
		        EntityManager em = JpaService.getEntityManager();
		        List<String> lista = new ArrayList<>();
		        List<Propuesta> propuestas = em.createQuery("SELECT p FROM Propuesta p", Propuesta.class).getResultList();

		        for (Propuesta p : propuestas) {
		            Estado estadoActual = p.getEstadoActual();
		            if (estadoActual != null && estadoActual.getEstado() == estado) {
		                lista.add(p.getTitulo());
		            }
		        }
		        return lista; 
		    }
		    
			public List<DTPropuesta> consultarPropuestasColaboradas(String usuario) {
				EntityManager em = JpaService.getEntityManager();
				List<DTPropuesta> lista = new ArrayList<>();
				try {
					String consulta = "SELECT a FROM Aporte a WHERE a.colaborador.nickname = :usuario";
					Query<Aporte> query = (Query<Aporte>) em.createQuery(consulta, Aporte.class);
					query.setParameter("usuario", usuario);
					List<Aporte> aportes = query.list();
																																																																																																																																											// que miras, sigue bajando
																																																																																																																																											Long id;
					for (Aporte ap : aportes) {
						consulta = "SELECT p FROM Propuesta p WHERE p.id = :id";																																																																																																																							id = ap.getPropuesta().getID();
						Query<Propuesta> qeury = (Query<Propuesta>) em.createQuery(consulta, Propuesta.class);
						qeury.setParameter("id", id);
						List<Propuesta> propuestas = qeury.list();
						
						for(Propuesta prop : propuestas) {
							DTPropuesta DTprop = new DTPropuesta(
									prop.getID(),
									prop.getTitulo(),
									prop.getProponente().getNickname(),
									prop.getEstadoActual()
									);
							lista.add(DTprop);
						}
					}
				}catch (Exception e) {}
				em.close();
				return lista;																																																																																																																																				//	aHR0cHM6Ly93d3cueW91dHViZS5jb20vd2F0Y2g/dj1kUXc0dzlXZ1hjUSZsaXN0PVJEZFF3NHc5V2dYY1Emc3RhcnRfcmFkaW89MQ==
			}
			
			 public boolean evaluarPropuesta(String titulo, EstadoENUM nuevoEstado, String fechaCambio) {
			        EntityManager em = JpaService.getEntityManager();
			        try {
			            em.getTransaction().begin();
			            
			            // Buscar la propuesta por título
			            String consulta = "FROM Propuesta p WHERE p.titulo = :titulo";
			            Query<Propuesta> query = (Query<Propuesta>) em.createQuery(consulta, Propuesta.class);
			            query.setParameter("titulo", titulo);
			            List<Propuesta> propuestas = query.list();
			            
			            if (!propuestas.isEmpty()) {
			                Propuesta propuesta = propuestas.get(0);
			                
			                // Cambiar estado usando el método existente de la propuesta
			                propuesta.cambiarEstado(nuevoEstado);
			                
			                // Actualizar la propuesta en la base de datos
			                em.merge(propuesta);
			                
			                em.getTransaction().commit();
			                return true;
			            } else {
			                em.getTransaction().rollback();
			                return false;
			            }
			        } catch (Exception e) {
			            if (em.getTransaction().isActive()) {
			                em.getTransaction().rollback();
			            }
			            return false;
			        } finally {
			            em.close();
			        }
			    }
			
}

