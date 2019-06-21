package com.uca.capas.rustico.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(name = "empleado")
data class Empleado(
        @Id
        @GeneratedValue
        @Column(name="c_empleado")
        var id : Int,

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name= "c_sucursal", nullable = false)
        @OnDelete(action = OnDeleteAction.NO_ACTION)
        @JsonIgnore
        var sucursal: Sucursal,

        @Column(name = "name")
        var nombre : String ="",

        @Column(name ="edad")
        var edad: Int,

        @Column(name ="genero")
        var genero: Boolean,

        @Column(name = "estado")
        var estado: Boolean
)
{
    override fun toString(): String = "Empleado { id = $id, nombre = $nombre, " +
            "edad=$edad, genero=$genero, estado=$estado }"
}