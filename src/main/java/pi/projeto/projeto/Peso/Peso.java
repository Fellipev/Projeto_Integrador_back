package pi.projeto.projeto.Peso;

import jakarta.persistence.*;
import pi.projeto.projeto.usuario.Usuario;

import java.util.Date;

@Entity
public class Peso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double peso;

    @Temporal(TemporalType.DATE)
    private Date dataRegistro;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Peso() {

    }

    public Peso(PesoRequestDTO data) {
        this.peso = data.peso();
        this.dataRegistro = data.dataRegistro();
        this.usuario = data.usuario();
    }

    public Peso(double peso, Date dataRegistro, Usuario usuario) {
        this.peso = peso;
        this.dataRegistro = dataRegistro;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Peso{" +
                "id=" + id +
                ", peso=" + peso +
                ", dataRegistro=" + dataRegistro +
                ", usuario=" + usuario +
                '}';
    }
}
