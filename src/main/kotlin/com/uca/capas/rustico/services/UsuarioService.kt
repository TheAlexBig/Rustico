package com.uca.capas.rustico.services

import com.uca.capas.rustico.domain.Usuario
import com.uca.capas.rustico.repositories.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsuarioService{
    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    fun findall()=usuarioRepository.findAll()
    fun save(usuario: Usuario) = usuarioRepository.save(usuario)
}