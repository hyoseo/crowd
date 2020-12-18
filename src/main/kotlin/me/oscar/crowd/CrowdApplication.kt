package me.oscar.crowd

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CrowdApplication

fun main(args: Array<String>) {
    runApplication<CrowdApplication>(*args)
}
