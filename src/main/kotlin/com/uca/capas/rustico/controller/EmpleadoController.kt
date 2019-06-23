package com.uca.capas.rustico.controller

import com.uca.capas.rustico.domain.Empleado
import com.uca.capas.rustico.domain.Sucursal
import com.uca.capas.rustico.services.EmpleadoService
import com.uca.capas.rustico.services.SucursalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.data.domain.Pageable
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Controller
class EmpleadoController{
    @Autowired
    lateinit var empleadoService: EmpleadoService

    @Autowired
    lateinit var sucursalService: SucursalService


    @RequestMapping("/sucursal/{sucId}/empleado")
    fun perfil(@PathVariable("sucId") Id: Int, model: Model, pageable: Pageable ):String{
        model.addAttribute("empleados",empleadoService.findBySucursalId(Id, pageable).toList())
        model.addAttribute("sucId", Id)
        return "empleados"
    }



    @RequestMapping("/sucursal/{sucId}/empleado/editar/{empId}",
            method = [RequestMethod.GET, RequestMethod.POST])
    fun editar(@PathVariable("sucId") sucId: Int, @PathVariable("empId") empId: Int,
               model:Model, pageable: Pageable) :String {
        model.addAttribute("sucId", sucId)
        empleadoService.findOne(empId).ifPresent{
            model.addAttribute("empleado", it)
        }
        if(model.containsAttribute("empleado")){
            return "editar-emp"
        }
        model.addAttribute("empleados",empleadoService.findBySucursalId(sucId, pageable).toList())
        return "empleados"
    }

    @PostMapping("/sucursal/{sucId}/empleado/actualizar/{empId}")
    fun actualizar(@PathVariable("sucId") sucId: Int,
                   @PathVariable("empId") empId: Int,
                   @Valid  empleado: Empleado,
                   result: BindingResult, model: Model , pageable: Pageable): String{
        model.addAttribute("sucId", sucId)
        empleado.id = empId
        if(result.hasErrors()){
            return "editar-emp"
        }
        sucursalService.findOne(sucId).ifPresent {
            empleado.sucursal = it
            empleadoService.save(empleado)
        }
        model.addAttribute("empleados",empleadoService.findBySucursalId(sucId, pageable).toList())
        return "empleados"
    }

    @GetMapping("/sucursal/{sucId}/empleado/preparar")
    fun preparar(empleado: Empleado, @PathVariable("sucId") Id: Int,
                 model: Model): String {
        model.addAttribute("empleado", empleado)
        model.addAttribute("sucId", Id)
        return "guardar-emp"
    }

    @PostMapping("/sucursal/{sucId}/empleado/guardar" )
    fun guardar(@Valid empleado: Empleado,result: BindingResult,
                @PathVariable("sucId") Id: Int, pageable: Pageable, model: Model):String{
        if(result.hasErrors()){
            return "guardar-emp"
        }
        sucursalService.findOne(Id).ifPresent {
            empleado.sucursal = it
            empleadoService.save(empleado)
        }
        model.addAttribute("empleados",empleadoService.findBySucursalId(Id, pageable).toList())
        model.addAttribute("sucId", Id)
        return "empleados"
    }

    @GetMapping("/sucursal/{sucId}/empleado/borrar/{id}")
    fun borrar(@PathVariable("id") empId:Int, @PathVariable("sucId") sucId:Int,
               model: Model, pageable: Pageable ): String{
        empleadoService.findOne(empId).ifPresent {
            empleadoService.delete(it)
        }
        model.addAttribute("empleados",empleadoService.findBySucursalId(sucId, pageable).toList())
        model.addAttribute("sucId", sucId)
        return "empleados"
    }
}