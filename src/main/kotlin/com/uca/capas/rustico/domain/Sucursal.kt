package com.uca.capas.rustico.domain

import org.hibernate.annotations.OnDelete
import org.hibernate.validator.constraints.Range
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

@Entity
@Table(name = "sucursal")
data class Sucursal (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sucursal_c_sucursal_seq")
    @SequenceGenerator(sequenceName = "sucursal_c_sucursal_seq",  name = "sucursal_c_sucursal_seq")
    @Column(name = "c_sucursal")
    var id : Int?=null,

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
    var cierra : String ="",

    @Column(name="abre_a")
    @field:NotEmpty(message="Ingrese horario de apertura")
    var abre : String="",

    @Column(name="numero_mesas")
    @field:Range(min=1,message="El rango es incorrecto debe ser >1")
    @field:NotNull(message="Ingrese el numero de mesas")
    var mesas : Int?=null,

    @Column(name="nombre_gerente")
    @field:NotEmpty(message="Ingrese el nombre del gerente")
    @field:Pattern(regexp = "^(?![\\s.]+\$)[a-zA-Z\\s.]*\$", message = "Esto no es un nombre")
    var gerente: String="",

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "sucursal")
    var empleados : Set<Empleado>?=null
) {
    override fun toString(): String = "Sucursal { id = $id, nombre = $nombre," +
            "ubicacion=$ubicacion, cierra=$cierra, abre=$abre, mesas = $mesas, gerente=$gerente" +
            ", empleados=$empleados}"

}