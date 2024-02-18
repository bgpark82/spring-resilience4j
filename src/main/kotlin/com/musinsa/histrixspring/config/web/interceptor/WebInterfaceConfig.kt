package com.musinsa.histrixspring.config.web.interceptor

import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

class WebInterfaceConfig : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        // registry.addInterceptor(MyInterceptor())
    }
}