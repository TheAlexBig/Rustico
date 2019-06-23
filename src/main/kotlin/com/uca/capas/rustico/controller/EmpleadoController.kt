package com.uca.capas.rustico.controller

import com.uca.capas.rustico.services.EmpleadoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

@Controller
class EmpleadoController{
    @Autowired
    lateinit var empleadoService: EmpleadoService

    @RequestMapping("/sucursal/{sucId}/empleados")
    fun perfil(@PathVariable("sucId") id: Int, model: Model, pageable: Pageable ):String{
        model.addAttribute("empleados",empleadoService.findBySucursalId(id, pageable).toList())
        return "trabajadores"
    }
}