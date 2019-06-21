package com.uca.capas.rustico.repositories

import com.uca.capas.rustico.domain.Empleado
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository
import java.util.Optional;

interface EmpleadoRepository : CrudRepository<Empleado, Int>{
    fun findBySucursalId(sucId: Int?, pageable: Pageable): Page<Empleado>
    fun findByIdAndSucursalId(id: Int?, sucId: Int?): Optional<Empleado>
}