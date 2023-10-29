package pi.projeto.projeto.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pi.projeto.projeto.usuario.Usuario;
import pi.projeto.projeto.usuario.UsuarioReponseDTO;
import pi.projeto.projeto.usuario.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public Usuario atualizarUsuario(Long id, Usuario novoUsuario) {
        Usuario usuarioExistente = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario nao encontrado."));

        usuarioExistente.setNomeCompleto(novoUsuario.getNomeCompleto());
        usuarioExistente.setEmail(novoUsuario.getEmail());
        usuarioExistente.setSenha(novoUsuario.getSenha());

        return repository.save(usuarioExistente);
    }

    public void deletarUsuario(Long id) {

       Usuario usuario = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario nao encontrado."));

        repository.deleteById(id);
    }

    public List<UsuarioReponseDTO> findAll() {

        List<UsuarioReponseDTO> users = repository.findAll().stream().map(UsuarioReponseDTO::new).toList();
        return users;
    }

    public void salvarUsuario(Usuario userData) {

        repository.save(userData);
    }
}
