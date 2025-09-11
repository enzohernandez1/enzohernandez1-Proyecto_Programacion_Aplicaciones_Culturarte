package logic;

import jakarta.persistence.*;

@Entity
@Table(name = "seguimientos")
public class Seguimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    @ManyToOne
    @JoinColumn(name = "seguidor_nickname")
    public Usuario seguidor;
    
    @ManyToOne
    @JoinColumn(name = "seguido_nickname")
    public Usuario seguido;
    
    public Seguimiento() {}
    
    public Seguimiento(Usuario seguidor, Usuario seguido) {
        this.seguidor = seguidor;
        this.seguido = seguido;
    }
}