package ru.vood.delegate.delegate.handler

import kotlin.properties.ReadOnlyProperty

abstract class AbstractHandler {


    val meta: MutableMap<ParamName, MetaParam> = mutableMapOf()

    fun<T> getParam(name: ParamName, data: MethodInvokeDto): T{
        val any = data.inParam[name]!! as T
        return any
    }

    fun string() = PropBuilder<String>()


    inner class PropBuilder<R>(
//         var name: ParamName = ParamName(""),
//        var function: GenerateFieldValueFunction<ID_TYPE, DataType<R>> = { _, _ ->
//            error("Необходимо определить ф-цию в мете")
//        }
    ) //: Builder<(MethodInvokeDto) -> R>
    {

        operator fun provideDelegate(
            thisRef: AbstractHandler,
            property: kotlin.reflect.KProperty<*>
        ): ReadOnlyProperty<AbstractHandler, (MethodInvokeDto) -> R> {
            val paramName = ParamName(property.name)
            val returnType = property.returnType
            val kTypeProjection = returnType.arguments[1]
            val classNameStr = ClassNameStr(kTypeProjection.type.toString())
//            val build: MetaProperty<R> = this@PropBuilder.build()

            thisRef.addProp(paramName, classNameStr)
            return ReadOnlyProperty { thisRef, property ->
                return@ReadOnlyProperty { q -> thisRef.getParam<R>(paramName, q) }
            }

        }

//        override fun build(): MetaProperty<R> = MetaProperty(name)
    }

    fun  addProp(build: ParamName, classNameStr: ClassNameStr){
        meta[build] = MetaParam(classNameStr)
    }

}