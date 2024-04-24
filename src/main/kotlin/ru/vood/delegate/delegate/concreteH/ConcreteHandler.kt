package ru.vood.delegate.delegate.concreteH

import org.springframework.stereotype.Service
import ru.vood.delegate.delegate.handler.AbstractHandler

@Service
class ConcreteHandler: AbstractHandler() {

    val s1 by string()


}