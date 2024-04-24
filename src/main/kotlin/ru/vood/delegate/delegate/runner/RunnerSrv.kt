package ru.vood.delegate.delegate.runner

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ru.vood.delegate.delegate.concreteH.ConcreteHandler

@Component
class RunnerSrv(
    val concreteHandler: ConcreteHandler
): CommandLineRunner {

    override fun run(vararg args: String?) {

        println(concreteHandler.meta)
    }
}