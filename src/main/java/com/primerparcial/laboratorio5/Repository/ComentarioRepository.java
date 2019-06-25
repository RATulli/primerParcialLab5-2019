package com.primerparcial.laboratorio5.Repository;

import com.primerparcial.laboratorio5.Model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer>
{

}
