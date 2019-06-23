package com.uca.capas.rustico.domain

import org.hibernate.validator.constraints.Range
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern


@Entity
@Table(name = "empleado")
data class Empleado(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleado_c_empleado_seq")
        @SequenceGenerator(sequenceName = "empleado_c_empleado_seq",  name = "empleado_c_empleado_seq")
        @Column(name="c_empleado")
        var id : Int?=null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name= "c_sucursal", nullable = true)
        var sucursal: Sucursal?=null,

        @Column(name = "nombre")
        @field:NotEmpty(message="Ingrese el nombre del empleado")
        @field:Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*\$", message = "Esto no es un nombre")
        var nombre : String ="",

        @Column(name ="edad")
        @field:Range(min=18,message="No puede ser menor de 18")
        @field:NotNull(message="Ingrese la edad del joven")
        var edad: Int?=null,

        @Column(name ="genero")
        @field:NotEmpty(message="Seleccione un genero")
        var genero: String="",

        @Column(name = "estado")
        @field:NotEmpty(message="Seleccione un estado")
        var estado: String=""
)
        {
        override fun toString(): String = "Empleado { id = $id, nombre = $nombre, " +
            "edad=$edad, genero=$genero, estado=$estado }"
}