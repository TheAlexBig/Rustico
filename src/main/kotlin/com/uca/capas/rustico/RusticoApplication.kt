package com.uca.capas.rustico

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["com.uca.capas.rustico.repositories"])
@EnableTransactionManagement
@EntityScan(basePackages = ["com.uca.capas.rustico.domain"])
class RusticoApplication

fun main(args: Array<String>) {
    runApplication<RusticoApplication>(*args)
}
