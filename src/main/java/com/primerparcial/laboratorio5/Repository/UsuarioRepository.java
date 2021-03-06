package com.primerparcial.laboratorio5.Repository;

import com.primerparcial.laboratorio5.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>
{

}
