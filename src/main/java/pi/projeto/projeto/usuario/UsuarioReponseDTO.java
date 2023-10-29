package pi.projeto.projeto.usuario;

public record UsuarioReponseDTO(Long id, String nomeCompleto, String email, String senha) {

    public UsuarioReponseDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNomeCompleto(), usuario.getEmail(), usuario.getSenha());
    }
}
