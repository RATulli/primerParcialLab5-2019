package com.primerparcial.laboratorio5.Controller;

import com.primerparcial.laboratorio5.Model.Comentario;
import com.primerparcial.laboratorio5.Repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comentarios")

public class comentarioController
{
    @Autowired
    ComentarioRepository comentarioRepository;

    @GetMapping("")
    public List<Comentario> obtenerComentarios() {

        return comentarioRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public String borrarComentario(@PathVariable("id") int id)
    {

        Comentario T = comentarioRepository.findById(id).orElseThrow(()->new HttpClientErrorException(HttpStatus.NO_CONTENT));

        comentarioRepository.delete(T);
        return "Terminated";
    }

    @Scheduled(fixedRate = 10000)
    public void tareaprogramada()
    {
        List<Comentario> listaComentarios = comentarioRepository.findAll();
        //
        //

        System.out.println("Eliminando..." );
    }

}
