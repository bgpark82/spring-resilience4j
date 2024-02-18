package com.musinsa.histrixspring

import com.musinsa.histrixspring.config.web.client.open.CircuitOpenStrategy
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class HistrixSpringApplication(
    val circuitOpen: CircuitOpenStrategy
): CommandLineRunner {

    override fun run(vararg args: String?) {
        circuitOpen.request()
    }
}

fun main(args: Array<String>) {
    runApplication<HistrixSpringApplication>(*args)
}
