package pi.projeto.projeto.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.projeto.projeto.services.UsuarioService;
import pi.projeto.projeto.usuario.Usuario;
import pi.projeto.projeto.usuario.UsuarioReponseDTO;
import pi.projeto.projeto.usuario.UsuarioRepository;
import pi.projeto.projeto.usuario.UsuarioRequestDTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuario")

public class UsuarioController {
//    @Autowired
//    private UsuarioRepository repository;
    @Autowired
    private UsuarioService service;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<UsuarioReponseDTO> getAll() {
        List<UsuarioReponseDTO> users = service.findAll();
//        List<UsuarioReponseDTO> usuarioList = repository.findAll().stream().map(UsuarioReponseDTO::new).toList();
        return users;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveUsuario(@RequestBody UsuarioRequestDTO usuario) {

        Usuario usuarioData = new Usuario(usuario);
//        repository.save(usuarioData);
        service.salvarUsuario(usuarioData);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@RequestBody UsuarioRequestDTO usuario, @PathVariable Long id) {

        Usuario usuarioData = new Usuario(usuario);
        Usuario usuarioAtualizado = service.atualizarUsuario(id, usuarioData);

        return ResponseEntity.ok(usuarioAtualizado);

    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
//        Usuario user = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario nao encontrado."));
        service.deletarUsuario(id);
    }
}
