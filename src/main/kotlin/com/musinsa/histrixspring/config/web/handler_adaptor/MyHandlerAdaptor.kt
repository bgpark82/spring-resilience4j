package com.musinsa.histrixspring.config.web.handler_adaptor

import com.musinsa.histrixspring.controller.MyController
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerAdapter
import org.springframework.web.servlet.ModelAndView

class MyHandlerAdaptor: HandlerAdapter {

    override fun supports(handler: Any): Boolean {
        println("[${this.javaClass.simpleName}] supports")
        return true
    }

    override fun handle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any
    ): ModelAndView? {
        println("[${this.javaClass.simpleName}] handler=${handler.javaClass.simpleName}")

        /**
         * handler의 메소드를 직접 호출
         * handler를 특정해야만 한다
         * 어노테이션을 사용할 수도 있겠다..
         */
        if (handler is HandlerMethod) {
            /** handler의 타입은 HandlerMethod이고 실제 빈은 MyController가 된다 */
            val bean = handler.bean
            if (bean is MyController) {
                /** HandlerAdaptor에서 로직을 추가할 수도 있음 */
                val logic = getLogic()

                val res = bean.my(request.queryString ?: "tmp")

                response.writer.write(res)
                /** @RestController는 ModelAndView를 반환하지 않는다.대신 response.body에 정보를 보낸다 */
                return null
            }
        }
        return null
    }

    private fun getLogic() {
        val logic = "logicA"
    }

    override fun getLastModified(
        request: HttpServletRequest,
        handler: Any
    ): Long {
        println("[${this.javaClass.simpleName}] getLastModified")
        return -1;
    }
}