package com.uca.capas.rustico.services

import com.uca.capas.rustico.domain.Empleado
import com.uca.capas.rustico.repositories.EmpleadoRepository
import org.springframework.data.domain.Pageable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmpleadoService{
    @Autowired
    lateinit var empleadoRepository: EmpleadoRepository

    fun findAll() = empleadoRepository.findAll()
    fun findBySucursalId(sucId: Int, pageable: Pageable) = empleadoRepository.findBySucursalId(sucId,pageable)
    fun findByIdAndSucursalId(Id:Int, sucId:Int) = empleadoRepository.findByIdAndSucursalId(Id, sucId)
    fun save(empleado: Empleado) = empleadoRepository.save(empleado)
    fun findOne(Id: Int) = empleadoRepository.findById(Id)
    fun delete(empleado:Empleado) = empleadoRepository.delete(empleado)
}