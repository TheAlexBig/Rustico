package com.uca.capas.rustico.domain

import org.hibernate.validator.constraints.Range
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
    @NotEmpty(message="Ingrese el nombre de la sucursal")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*\$", message = "Esto no es un nombre")
    var nombre : String = "",

    @Column(name="ubicacion")
    @NotEmpty(message="Ingrese la direccion")
    @field:Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*\$", message = "Esto no es un nombre")
    var ubicacion : String = "",

    @Column(name = "cierra_a")
    @NotEmpty(message="Ingrese horario de cierre")
    var cierra : String ="",

    @Column(name="abre_a")
    @NotEmpty(message="Ingrese horario de apertura")
    var abre : String="",

    @Column(name="numero_mesas")
    @Range(min=1,message="El rango es incorrecto")
    var mesas : Int,

    @Column(name="nombre_gerente")
    @NotEmpty(message="Ingrese el nombre del gerente")
    @Pattern(regexp = "^(?![\\s.]+\$)[a-zA-Z\\s.]*\$", message = "Esto no es un nombre")
    var gerente: String="",

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "sucursal")
    var empleados : Set<Empleado>?=null
) {
    override fun toString(): String = "Sucursal { id = $id, nombre = $nombre," +
            "ubicacion=$ubicacion, cierra=$cierra, abre=$abre, nMesas = $mesas, gerente=$gerente" +
            ", empleados=$empleados}"

}