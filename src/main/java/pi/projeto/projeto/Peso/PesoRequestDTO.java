package pi.projeto.projeto.Peso;

import pi.projeto.projeto.usuario.Usuario;

import java.util.Date;

public record PesoRequestDTO(Long id, double peso, Date dataRegistro, Usuario usuario) {

    public PesoRequestDTO(Peso peso){
        this(peso.getId(), peso.getPeso(), peso.getDataRegistro(), peso.getUsuario());
    }
}
