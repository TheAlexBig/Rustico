package com.uca.capas.rustico.repositories

import com.uca.capas.rustico.domain.Usuario
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UsuarioRepository : CrudRepository<Usuario, Int>{
    fun findFirstByCorreoAndPassword(correo:String, password:String) : Optional<Usuario>
}