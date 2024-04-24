package ru.vood.delegate.delegate.handler

@JvmInline
value class ClassNameStr(private val value: String) {

    fun className() = value.replace("?", "", true)

    fun isOptional() = value.contains("?")
}
