package com.uca.capas.rustico.repositories

import com.uca.capas.rustico.domain.Sucursal
import org.springframework.data.repository.CrudRepository

interface SucursalRepository : CrudRepository<Sucursal, Int>{

}