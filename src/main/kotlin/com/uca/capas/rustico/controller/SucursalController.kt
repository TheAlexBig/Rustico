package com.uca.capas.rustico.controller

import com.uca.capas.rustico.domain.Sucursal
import com.uca.capas.rustico.services.SucursalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Controller
@SessionAttributes("sucursal")
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
        sucursalService.findOne(Id).ifPresent{
            model.addAttribute("sucursal", it)
        }
        if(model.containsAttribute("sucursal")){
            return "editar-suc"
        }
        return "dashboard"
    }

    @PostMapping("/sucursal/actualizar/{sucId}")
    fun actualizar(@PathVariable("sucId") Id: Int,
                   @ModelAttribute("sucursal") @Valid  sucursal: Sucursal,
                   result: BindingResult, model: Model): String{
        model.addAttribute("sucursal", sucursal)
        if(result.hasErrors()){
            model.addAttribute("errorSucursal", "No se inserto la sucursal")
            return "editar-suc"
        }
        sucursalService.save(sucursal)
        return "editar-suc"

    }

    @RequestMapping(value ="/sucursal/guardar}",method = [RequestMethod.POST, RequestMethod.GET] )
    fun guardar(@Valid sucursal: Sucursal, result: BindingResult, model: Model):String{
        if(result.hasErrors()){
            return "guardar"
        }
        sucursalService.save(sucursal)
        model.addAttribute("sucursales", sucursalService.findall().toList())
        return "dashboard"
    }
}