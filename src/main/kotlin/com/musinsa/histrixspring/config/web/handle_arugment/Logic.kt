package com.musinsa.histrixspring.config.web.handle_arugment

@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class Logic(

    val enable: Boolean = true
)