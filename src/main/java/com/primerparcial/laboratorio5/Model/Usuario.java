package com.primerparcial.laboratorio5.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario
{
    @Id
    @GeneratedValue
    private int idUsuario;

   // @NotNull(message = "el campo no debe estar vacio")
    private String apellido;

    //@NotNull(message = "el campo no debe estar vacio")
    private String nombre;

    //@NotNull(message = "el campo no debe estar vacio")
    private String Browser;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Publicacion> listaPublicaciones;

}
