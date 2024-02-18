package com.musinsa.histrixspring.config.web.interceptor

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletRequestWrapper
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception

class MyInterceptor: HandlerInterceptor {

    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any
    ): Boolean {
        println("[${this.javaClass.simpleName}] preHandler")

        request.setAttribute("logic", "B")

        return super.preHandle(request, response, handler)
    }

    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        modelAndView: ModelAndView?
    ) {
        println("[${this.javaClass.simpleName}] postHandler")
        super.postHandle(request, response, handler, modelAndView)
    }

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {
        println("[${this.javaClass.simpleName}] afterCompletion")
        super.afterCompletion(request, response, handler, ex)
    }

    class CustomRequestWrapper(request: HttpServletRequest) : HttpServletRequestWrapper(request) {
        private val additionalParams = mutableMapOf<String, String>()

        override fun getParameter(name: String): String? {
            return additionalParams[name] ?: request.getParameter(name)
        }

        fun setParameter(key: String, value: String) {
            additionalParams[key] = value
        }
    }
}