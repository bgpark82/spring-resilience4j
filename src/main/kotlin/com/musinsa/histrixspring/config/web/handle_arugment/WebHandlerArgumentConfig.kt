package com.musinsa.histrixspring.config.web.handle_arugment

import com.musinsa.histrixspring.config.web.client.WebClientCB
import com.musinsa.histrixspring.config.web.handler_adaptor.MyHandlerAdaptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.HandlerAdapter
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebHandlerArgumentConfig(
    private val webClient: WebClientCB
): WebMvcConfigurer {

    override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
        resolvers.addAll(arrayOf(MyHandlerArgumentResolver(webClient)))
    }
}