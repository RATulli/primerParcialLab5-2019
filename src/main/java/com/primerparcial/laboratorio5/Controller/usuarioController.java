package com.primerparcial.laboratorio5.Controller;

import com.primerparcial.laboratorio5.Model.Publicacion;
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
    public void agregarUsuario(@RequestHeader (value = "Browser", defaultValue = "OOO") String userAgent,
            @RequestBody final Usuario usuario)
    {
        usuario.setBrowser(userAgent);
        usuarioRepository.save(usuario);
    }

    @GetMapping ("/{id}")
    public Usuario verUsuario(@PathVariable("id") int id)
    {
        return usuarioRepository.findById(id).orElse(null);
    }

    @PostMapping("/{id}/agregarPublicacion")
    public void publicacionUsuario  (@PathVariable final Integer id, @RequestBody final Publicacion publicacion)
    {
        Usuario t = usuarioRepository.findById(id)
                .orElseThrow(()-> new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                        String.format("No encontrado")));
        t.getListaPublicaciones().add(publicacion);
        publicacion.setUsuario(t);
        usuarioRepository.save(t);
    }

    @DeleteMapping("/{id}")
    public String borrarUsuario(@PathVariable("id") int id)
    {

        Usuario a = usuarioRepository.findById(id).orElseThrow(()->new HttpClientErrorException(HttpStatus.NO_CONTENT));

        usuarioRepository.delete(a);
        return "Terminated";
    }



}
