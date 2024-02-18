package com.musinsa.histrixspring.config.web.handle_arugment

import com.musinsa.histrixspring.config.web.client.WebClientCB
import org.springframework.core.MethodParameter
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer


class MyHandlerArgumentResolver(
    private val webClient: WebClientCB
): HandlerMethodArgumentResolver {

    override fun supportsParameter(parameter: MethodParameter): Boolean {
        /* 어노테이션으로 반환한다 (https://engineerinsight.tistory.com/80) */
        println("[${this.javaClass.simpleName}] supportsParameter=${parameter}")
        return parameter.hasParameterAnnotation(Logic::class.java)
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?
    ): Any? {
        println("[${this.javaClass.simpleName}] percentage=${webRequest.getParameter("percentage")}")
        println("[${this.javaClass.simpleName}] delay=${webRequest.getParameter("delay")}")
        println("[${this.javaClass.simpleName}] test=${webRequest.getParameter("test")}")

        if(parameter.hasParameterAnnotation(Logic::class.java)) {
            val percentage = webRequest.getParameter("percentage")?.toInt() ?: 0
            val delay = webRequest.getParameter("delay")?.toInt() ?: 0

            val res = webClient.getTest(percentage = percentage, timeout = delay)

            return res
        }
        return "Basic"
    }
}