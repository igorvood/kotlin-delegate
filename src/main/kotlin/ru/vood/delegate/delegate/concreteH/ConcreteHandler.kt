package ru.vood.delegate.delegate.concreteH

import org.springframework.stereotype.Service
import ru.vood.delegate.delegate.handler.AbstractHandler
import ru.vood.delegate.delegate.handler.MethodInvokeDto

@Service
class ConcreteHandler : AbstractHandler() {

    val s1: (MethodInvokeDto) -> String by string()

    val sNullable: (MethodInvokeDto) -> String? by PropBuilder<String?>()

    val listNullable: (MethodInvokeDto) -> List<String?> by paramType<List<String?>>()

    override fun handle(methodInvokeDto: MethodInvokeDto) {
        val s11: String = s1(methodInvokeDto)
        val sNullable1: String? = sNullable(methodInvokeDto)
        val listNullable1: List<String?> = listNullable(methodInvokeDto)

        println(s11)
        println(sNullable1)
        println(listNullable1)
    }
}