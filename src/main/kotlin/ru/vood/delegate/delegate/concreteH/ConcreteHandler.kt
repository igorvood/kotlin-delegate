package ru.vood.delegate.delegate.concreteH

import org.springframework.stereotype.Service
import ru.vood.delegate.delegate.handler.AbstractHandler
import ru.vood.delegate.delegate.handler.MethodInvokeDto

@Service
class ConcreteHandler : AbstractHandler() {

    val s1 by string()

    val sNullable by PropBuilder<String?>()

    val listNullable by paramType<List<String>>()

    override fun handle(methodInvokeDto: MethodInvokeDto) {

        val s11 = s1(methodInvokeDto)
        val sNullable1 = sNullable(methodInvokeDto)
        val listNullable1 = listNullable(methodInvokeDto)

        println(s11)
        println(sNullable1)
        println(listNullable1)



    }
}