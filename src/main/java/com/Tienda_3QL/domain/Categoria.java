
package com.Tienda_3QL.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data/*Creaciónde los set y get*/
@Entity
@Table(name="categoria")
public class Categoria implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     @Column(name="id_categoria") // esta línea no siempre es necesaria
    private Long idCategoria;
    private String descripcion;
    private boolean activo;

    public Categoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Categoria() {
    }
    
    
}
