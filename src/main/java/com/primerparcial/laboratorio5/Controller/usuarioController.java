package com.primerparcial.laboratorio5.Controller;

import com.primerparcial.laboratorio5.Model.Usuario;
import com.primerparcial.laboratorio5.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class usuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("")
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping("/agregarUsuario")
    public void agregarUsuario(@RequestBody final Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @GetMapping ("/{id}")
    public Usuario verUsuario(@PathVariable("id") int id) {

        return usuarioRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String borrarUsuario(@PathVariable("id") int id) {

        Usuario a = usuarioRepository.findById(id).orElseThrow(()->new HttpClientErrorException(HttpStatus.NO_CONTENT));

        usuarioRepository.delete(a);
        return "Terminated";
    }

}
