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
    fun index(model: Model): String {
        model.addAttribute("loginForm", LoginForm())
        return "login"
    }

    @RequestMapping("/login",method = [RequestMethod.POST])
    fun login(@Valid loginForm: LoginForm, result: BindingResult, model:Model): String{
        if(result.hasErrors()){
            model.addAttribute("loginForm", loginForm)
            return "login"
        }
        else{
            usuarioService.login(loginForm.correo, loginForm.password).ifPresent {
                model.addAttribute("logeado",loginForm.correo)
            }
            if(model.containsAttribute("logeado")){
                return "redirect:/sucursal"
            }
            else{
                model.addAttribute("errorLogin", "Usuario no encontrado")
                return "login"
            }
        }
    }

}