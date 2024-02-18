package com.musinsa.histrixspring.config.web.handler_adaptor

import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.HandlerAdapter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

// @Configuration
class WebHandlerAdaptorConfig: WebMvcConfigurer {

    @Bean
    fun handlerAdaptor(): HandlerAdapter {
        return MyHandlerAdaptor()
    }
}

