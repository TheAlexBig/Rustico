package com.uca.capas.rustico.domain

import java.time.LocalTime
import javax.persistence.*

@Entity
@Table(name = "sucursal")
data class Sucursal (
    @Id
    @GeneratedValue
    @Column(name = "c_sucursal")
    var id : Int,

    @Column(name="nombre")
    var nombre : String = "",

    @Column(name="ubicacion")
    var ubicacion : String = "",

    @Column(name = "cierra_a")
    var cierra : LocalTime,

    @Column(name="abre_a")
    var abre : LocalTime,

    @Column(name="numero_mesas")
    var nMesas : Int,

    @Column(name="nombre_gerente")
    var gerente: String,

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "sucursal")
    var empleados : List<Empleado>
){
    override fun toString(): String = "Sucursal { id = $id, nombre = $nombre," +
            "ubicacion=$ubicacion, cierra=$cierra, abre=$abre, nMesas = $nMesas, gerente=$gerente" +
            "empleados=$empleados}"
}