package com.primerparcial.laboratorio5.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comentario
{
    @Id
    @GeneratedValue
    private int idComentario;

    //@NotNull(message = "el campo no debe estar vacio")
    private String Descripcion;



    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY")
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="publicacion_id", referencedColumnName = "idPublicacion")
    @JsonIgnore
    private Publicacion publicacion;
    private String owner;
}
