package com.uca.capas.rustico.repositories

import com.uca.capas.rustico.domain.Usuario
import org.springframework.data.repository.CrudRepository

interface UsuarioRepository : CrudRepository<Usuario, Int>{

}