package com.primerparcial.laboratorio5.Repository;

import com.primerparcial.laboratorio5.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>
{

}
