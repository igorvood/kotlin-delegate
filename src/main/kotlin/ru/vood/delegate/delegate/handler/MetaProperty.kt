package ru.vood.delegate.delegate.handler

data class MetaProperty<OUT_TYPE>(
    val name: ParamName,
//    val function: GenerateFieldValueFunction<ID_TYPE, DataType<OUT_TYPE>>
) : () -> OUT_TYPE
//,Comparable<MetaProperty<ID_TYPE, OUT_TYPE>>/* Comparator<MetaProperty<ID_TYPE, OUT_TYPE>>*/
{
    override fun invoke(): OUT_TYPE {
        TODO("Not yet implemented")
    }

    //    override fun invoke(p1: EntityTemplate<ID_TYPE>): OUT_TYPE = function(p1, name)()
    /* override fun compareTo(other: MetaProperty<ID_TYPE, OUT_TYPE>): Int {
         return this.name.compareTo(other.name)
     }*/

}