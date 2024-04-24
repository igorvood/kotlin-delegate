package ru.vood.delegate.delegate.handler

import java.util.*
import kotlin.properties.ReadOnlyProperty

abstract class AbstractHandler {


    val meta: MutableMap<ParamName, String> = mutableMapOf()

    fun<T> getParam(name: ParamName, data: MethodInvokeDto): T{
        val any = data.inParam[name]!! as T
        return any
    }

    fun string() = PropBuilder<String>()


    inner class PropBuilder<R>(
        private var name: ParamName = ParamName(""),
//        var function: GenerateFieldValueFunction<ID_TYPE, DataType<R>> = { _, _ ->
//            error("Необходимо определить ф-цию в мете")
//        }
    ) : Builder<MetaProperty<R>>
    {

        operator fun provideDelegate(
            thisRef: AbstractHandler,
            property: kotlin.reflect.KProperty<*>
        ): ReadOnlyProperty<AbstractHandler, MetaProperty<R>> {
            name = ParamName(property.name)
            val returnType = property.returnType

            val build: MetaProperty<R> = this@PropBuilder.build()
            thisRef.addProp(build)
            return ReadOnlyProperty { thisRef, property ->
                return@ReadOnlyProperty build
            }

        }

        override fun build(): MetaProperty<R> = MetaProperty(name)
    }

    fun <R> addProp(build: MetaProperty<R>){
        meta[build.name] = build.name.value
    }

}