
package com.Tienda_3QL.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data/*Creaciónde los set y get*/
@Entity
@Table(name="cliente")/*busca la tabla cliente en la base de datos*/
public class Cliente implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idCliente;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    
    @JoinColumn(name="id_credito", referencedColumnName="id_credito")//Se inidica en que campo buscar
    @ManyToOne//relación de muchos a uno osea muchos clientes pueden tener un credito
    private Credito credito;//se crea un objeto de credito

    //Se crean los constructores
    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono, Credito credito) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.credito = credito;
    }
    
    
    
    
    
}
