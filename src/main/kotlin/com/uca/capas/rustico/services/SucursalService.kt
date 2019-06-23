package com.uca.capas.rustico.services

import com.uca.capas.rustico.domain.Sucursal
import com.uca.capas.rustico.repositories.SucursalRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SucursalService{
    @Autowired
    lateinit var sucursalRepository: SucursalRepository

    fun findall() = sucursalRepository.findAll()
    fun save(sucursal: Sucursal) = sucursalRepository.save(sucursal)
    fun findOne(Id: Int) = sucursalRepository.findById(Id)
}