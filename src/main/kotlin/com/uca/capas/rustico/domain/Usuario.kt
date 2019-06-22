package com.uca.capas.rustico.domain

import javax.persistence.*

@Entity
@Table(name = "usuario")
data class Usuario(
    @Id
    @GeneratedValue
    @Column(name = "c_usuario")
    var id : Int,

    @Column(name="usuario")
    var correo : String = "",

    @Column(name="password")
    var password : String =""
)
{
    override fun toString(): String = "Usuario { cUsuario = $id, usuario = $correo}"
}