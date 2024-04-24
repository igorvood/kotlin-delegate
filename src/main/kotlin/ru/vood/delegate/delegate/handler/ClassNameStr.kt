package ru.vood.delegate.delegate.handler

@JvmInline
value class ClassNameStr(private val value: String) {

    fun className() = if (isOptional())
            value.dropLast(1)
        else value

    fun isOptional() = value.last()=='?'
}
