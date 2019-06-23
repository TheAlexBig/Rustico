package com.uca.capas.rustico.form

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class LoginForm(
        @field:Email
        @field:NotEmpty(message = "No puede estar vacio el correo")
        @field:Size(min = 8, message = "Formato incorrecto debe ser mayor 8 caracteres")
        var correo : String="",

        @field:NotEmpty(message = "Ingrese una contraseña")
        @field:Size(min = 8, message = "Formato incorrecto debe ser mayor 8 caracteres")
        var password : String= ""
){

}