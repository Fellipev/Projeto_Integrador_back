package pi.projeto.projeto.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pi.projeto.projeto.Peso.Peso;
import pi.projeto.projeto.Peso.PesoRepository;
import pi.projeto.projeto.Peso.PesoRequestDTO;
import pi.projeto.projeto.usuario.Usuario;
import pi.projeto.projeto.usuario.UsuarioRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("peso")

public class PesoController {
    @Autowired
    private PesoRepository pesoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void savePeso(@RequestBody PesoRequestDTO pesoDTO) {
        Peso peso = new Peso(pesoDTO);
        Usuario usuario = usuarioRepository.findById(peso.getUsuario().getId())
                .orElseThrow(() -> new EntityNotFoundException("Usuario nao encontrado."));

        peso.setDataRegistro(new Date());
        peso.setUsuario(usuario);

        pesoRepository.save(peso);
        System.out.println("Objeto peso: " + peso);
    }
    @GetMapping("/{id}")
    public List<Peso> getPesosById(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario nao encontrado."));
            System.out.println(usuario);
            List<Peso> pesoList = pesoRepository.getPesoByUsuarioId(id);
            return pesoList;
    }
}
