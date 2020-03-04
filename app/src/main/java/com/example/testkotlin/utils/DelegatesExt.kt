package com.example.testkotlin.utils

import kotlin.IllegalStateException
import kotlin.reflect.KProperty

object DelegatesExt{
    fun <T> notNullSingleValue()=NotNullStringValueVar<T>()
}

class NotNullStringValueVar<T>{

    private var value:T?=null

    operator fun getValue(thisRef:Any?,property:KProperty<*>):T=
            value?:throw IllegalStateException("${property.name} not initialized")
    operator fun setValue(thisRef: Any?,property: KProperty<*>,value:T){
        this.value=if (this.value==null)value
        else throw IllegalStateException("${property.name} already initialized")
    }
}