package com.uca.capas.rustico.domain

import org.hibernate.validator.constraints.Range
import java.time.LocalTime
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern

@Entity
@Table(name = "sucursal")
data class Sucursal (
    @Id
    @GeneratedValue
    @Column(name = "c_sucursal")
    var id : Int,

    @Column(name="nombre")
    @field:NotEmpty(message="Ingrese el nombre de la sucursal")
    @field:Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*\$", message = "Esto no es un nombre")
    var nombre : String = "",

    @Column(name="ubicacion")
    @field:NotEmpty(message="Ingrese la direccion")
    @field:Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*\$", message = "Esto no es un nombre")
    var ubicacion : String = "",

    @Column(name = "cierra_a")
    @field:NotEmpty(message="Ingrese horario de cierre")
    @field:Temporal(TemporalType.TIME)
    var cierra : Date,

    @Column(name="abre_a")
    @field:NotEmpty(message="Ingrese horario de apertura")
    @field:Temporal(TemporalType.TIME)
    var abre : Date,

    @Column(name="numero_mesas")
    @field:Range(min=1,message="El rango es incorrecto")
    var nMesas : Int,

    @Column(name="nombre_gerente")
    @field:NotEmpty(message="Ingrese el nombre del gerente")
    @field:Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*\$", message = "Esto no es un nombre")
    var gerente: String,

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "sucursal")
    var empleados : List<Empleado>
){
    override fun toString(): String = "Sucursal { id = $id, nombre = $nombre," +
            "ubicacion=$ubicacion, cierra=$cierra, abre=$abre, nMesas = $nMesas, gerente=$gerente" +
            "empleados=$empleados}"
}