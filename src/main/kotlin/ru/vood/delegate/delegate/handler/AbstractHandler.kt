package ru.vood.delegate.delegate.handler

import kotlin.properties.ReadOnlyProperty

abstract class AbstractHandler {


    abstract fun handle(methodInvokeDto: MethodInvokeDto)

    val meta: MutableMap<ParamName, MetaParam> = mutableMapOf()

    fun <T> getParam(name: ParamName, data: MethodInvokeDto): T {
        return data.inParam[name]!! as T
    }

    fun <T> getParamNullable(name: ParamName, data: MethodInvokeDto): T? {
        return data.inParam[name] as T
    }

    fun string() = PropBuilder<String>()

    fun <T> paramType() = PropBuilder<T>()

    inner class PropBuilder<R> {

        operator fun provideDelegate(
            thisRef: AbstractHandler,
            property: kotlin.reflect.KProperty<*>,
        ): ReadOnlyProperty<AbstractHandler, (MethodInvokeDto) -> R> {
            val paramName = ParamName(property.name)
            val returnType = property.returnType
            val kTypeProjection = returnType.arguments[1]
            val classNameStr = ClassNameStr(kTypeProjection.type.toString())

            thisRef.addProp(paramName, classNameStr)
            return ReadOnlyProperty { thisRef, property ->
                return@ReadOnlyProperty { q -> thisRef.getParam<R>(paramName, q) }
            }

        }

//        override fun build(): MetaProperty<R> = MetaProperty(name)
    }

    fun addProp(build: ParamName, classNameStr: ClassNameStr) {
        meta[build] = MetaParam(classNameStr)
    }

}