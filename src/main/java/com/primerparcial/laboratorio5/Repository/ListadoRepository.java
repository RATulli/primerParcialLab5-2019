package com.primerparcial.laboratorio5.Repository;

import com.primerparcial.laboratorio5.Model.Listados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListadoRepository extends JpaRepository<Listados, Integer>
{

}
