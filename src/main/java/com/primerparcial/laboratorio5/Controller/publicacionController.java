package com.primerparcial.laboratorio5.Controller;

import com.primerparcial.laboratorio5.Model.Comentario;
import com.primerparcial.laboratorio5.Model.Publicacion;
import com.primerparcial.laboratorio5.Model.Usuario;
import com.primerparcial.laboratorio5.Repository.CantidadComentarios;
import com.primerparcial.laboratorio5.Repository.PublicacionRepository;
import com.primerparcial.laboratorio5.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/publicaciones")

public class publicacionController
{
        @Autowired
        PublicacionRepository publicacionRepository;

        @GetMapping("")
        public List<Publicacion> obtenerUsuarios() {
            return publicacionRepository.findAll();
        }

        @PostMapping("/agregarPublicacion")
        public void agregarPublicacion(@RequestBody final Publicacion publicacion) {
            publicacionRepository.save(publicacion);
        }

        @PostMapping("/{id}/agregarComentario")
        public void agregarComentario  (@PathVariable final Integer id, @RequestBody final Comentario comentario)
        {
            Publicacion t = publicacionRepository.findById(id)
                    .orElseThrow(()-> new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                            String.format("No encontrado")));

            t.getListaComentarios().add(comentario);
            String Temp = t.getUsuario().getApellido()+" "+t.getUsuario().getNombre();
            comentario.setOwner(Temp);
            publicacionRepository.save(t);
        }

    @GetMapping("/Native")
    public List<CantidadComentarios> getcantidadcomentarios()
    {
        return publicacionRepository.getCantidadComentarios();
    }

}
