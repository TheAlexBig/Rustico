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
class SucursalController {
    @Autowired
    lateinit var sucursalService: SucursalService

    @RequestMapping("/sucursal")
    fun mostrarTodos(model:Model):String{
        model.addAttribute("sucursales", sucursalService.findAll().toList())
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
                   @Valid  sucursal: Sucursal,
                   result: BindingResult, model: Model): String{
        model.addAttribute("sucursal", sucursal)
        sucursal.id = Id
        if(result.hasErrors()){
            return "editar-suc"
        }
        sucursalService.save(sucursal)
        model.addAttribute("sucursales", sucursalService.findAll())
        return "dashboard"

    }

    @GetMapping("/sucursal/preparar")
    fun preparar(sucursal: Sucursal, model: Model): String {
        model.addAttribute("sucursal", sucursal)
        return "guardar-suc"
    }

    @PostMapping("/sucursal/guardar" )
    fun guardar(@Valid sucursal: Sucursal, result: BindingResult, model: Model):String{
        if(result.hasErrors()){
            model.addAttribute("sucursal", sucursal)
            return "guardar-suc"
        }
        sucursalService.save(sucursal)
        model.addAttribute("sucursales", sucursalService.findAll().toList())
        return "dashboard"
    }

    @GetMapping("sucursal/borrar/{sucId}")
    fun borrar(model: Model, @PathVariable("sucId") Id: Int):String{
        sucursalService.findOne(Id).ifPresent {
            sucursalService.delete(it)
        }
        model.addAttribute("sucursales", sucursalService.findAll().toList())
        return "dashboard"
    }
}