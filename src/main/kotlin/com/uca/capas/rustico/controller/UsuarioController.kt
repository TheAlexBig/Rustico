package com.uca.capas.rustico.controller

import com.uca.capas.rustico.form.LoginForm
import com.uca.capas.rustico.services.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import javax.validation.Valid
@Controller
class UsuarioController {
    @Autowired
    lateinit var usuarioService : UsuarioService

    @RequestMapping("/")
    fun blog(model: Model): String {
        model.addAttribute("loginForm", LoginForm())
        return "login"
    }

    @RequestMapping("/login",method = [RequestMethod.POST])
    fun login(@Valid loginForm: LoginForm, result: BindingResult, model:Model): String{
        when(result.hasErrors()){
            true -> {
                model.addAttribute("loginForm", loginForm)
                return "login"
            }
            false -> {
                var check = false
                usuarioService.login(loginForm.correo!!, loginForm.password!!).ifPresent {
                    check=true
                }

                if(check){
                    model.addAttribute("Logeado",loginForm.correo)
                    return "dashboard"
                }
                else{
                    model.addAttribute("errorLogin", "Usuario no encontrado")
                    return "login"
                }
            }
        }
    }

}