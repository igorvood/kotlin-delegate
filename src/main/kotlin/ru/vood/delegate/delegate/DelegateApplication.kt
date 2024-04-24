package ru.vood.delegate.delegate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DelegateApplication

fun main(args: Array<String>) {
    runApplication<DelegateApplication>(*args)
}
