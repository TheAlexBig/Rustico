package com.uca.capas.rustico.controller

import com.uca.capas.rustico.domain.Sucursal
import com.uca.capas.rustico.services.SucursalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import javax.validation.Valid

@Controller
class SucursalController {
    @Autowired
    lateinit var sucursalService: SucursalService

    @RequestMapping("/sucursal")
    fun mostrarTodos(model:Model):String{
        model.addAttribute("sucursales", sucursalService.findall().toList())
        return "dashboard"
    }
    @RequestMapping("/sucursal/editar/{sucId}", method = [RequestMethod.GET, RequestMethod.POST])
    fun editar(@PathVariable("sucId") Id: Int ,model:Model) :String {
        val suc = sucursalService.findOne(Id)
        val check = suc.isPresent
        if(check){
            model.addAttribute("sucursal", suc)
            return "editar-suc"
        }
        return "dashboard"
    }

    @RequestMapping("/sucursal/actualizar/{sucId}", method = [RequestMethod.POST])
    fun actualizar(@Valid sucursal: Sucursal, result: BindingResult, model: Model): String{
        model.addAttribute("sucursal", sucursal)
        if(result.hasErrors()){
            model.addAttribute("errorSucursal", "No se inserto la sucursal")
        }
        return "editar-suc"
    }
}