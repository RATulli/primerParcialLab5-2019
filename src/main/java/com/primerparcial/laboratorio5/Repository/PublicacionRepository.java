package com.primerparcial.laboratorio5.Repository;

import com.primerparcial.laboratorio5.Model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Integer>
{

    String NATIVE_QUERY="Select P.DESCRIPCION as descripcion, U.NOMBRE as nombre,  count(C.PUBLICACION_ID) as cantcomentarios from PUBLICACION P inner join USUARIO U inner join COMENTARIO C on U.ID_USUARIO = P.USUARIO_ID group by U.NOMBRE";

    @Query(value = NATIVE_QUERY, nativeQuery = true)
    List<CantidadComentarios> getCantidadComentarios();
}