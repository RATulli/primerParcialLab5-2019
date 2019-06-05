package com.primerparcial.laboratorio5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Publicacion
{
    @Id
    @GeneratedValue
    private int idPublicacion;

    //@NotNull(message = "el campo no debe estar vacio")
    private String descripcion;
    //@NotNull(message = "el campo no debe estar vacio")
    private String foto;

    private Date fechaPublicacion;
    private int liked;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id", referencedColumnName = "idUsuario")
    @JsonIgnore
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "publicacion")
    private List<Comentario> listaComentarios;

}
