package ru.vood.delegate.delegate.runner

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ru.vood.delegate.delegate.concreteH.ConcreteHandler
import ru.vood.delegate.delegate.handler.MethodInvokeDto
import ru.vood.delegate.delegate.handler.ParamName

@Component
class RunnerSrv(
    val concreteHandler: ConcreteHandler
): CommandLineRunner {

    override fun run(vararg args: String?) {

        println(concreteHandler.meta)

//        val s1 by string()
//
//        val sNullable by PropBuilder<String?>()


        concreteHandler.handle(MethodInvokeDto(
            mapOf(ParamName("s1") to "value_s1")
        ))
    }
}