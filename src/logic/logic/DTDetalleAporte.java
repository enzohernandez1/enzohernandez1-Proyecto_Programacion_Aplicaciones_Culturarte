package logic;

import java.time.LocalDate;

public class DTDetalleAporte {
    private String id;
    private String nicknameColaborador;
    private String nombrePropuesta;
    private LocalDate fecha;
    private float monto;
    private String tipoRetorno;

    public DTDetalleAporte(String id, String nicknameColaborador, String nombrePropuesta, LocalDate fecha, float monto, String tipoRetorno) {
        this.id = id;
        this.nicknameColaborador = nicknameColaborador;
        this.nombrePropuesta = nombrePropuesta;
        this.fecha = fecha;
        this.monto = monto;
        this.tipoRetorno = tipoRetorno;
    }

    public String getId() {
    	return id; 
    }
    
    public String getNicknameColaborador() {
    	return nicknameColaborador; 
    }
    
    public String getNombrePropuesta() { 
    	return nombrePropuesta; 
    }
    
    public LocalDate getFecha() { 
    	return fecha; 
    }
    
    public float getMonto() { 
    	return monto; 
    }
    
    public String getTipoRetorno() { 
    	return tipoRetorno; 
    }
    
}
