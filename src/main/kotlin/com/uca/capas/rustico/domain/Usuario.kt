package com.uca.capas.rustico.domain

import javax.persistence.*

@Entity
@Table(name = "usuario")
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_c_usuario_seq")
    @SequenceGenerator(sequenceName = "usuario_c_usuario_seq",  name = "usuario_c_usuario_seq")
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