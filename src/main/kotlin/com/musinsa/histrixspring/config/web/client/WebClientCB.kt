package com.musinsa.histrixspring.config.web.client

import com.musinsa.histrixspring.config.web.client.open.CircuitOpenStrategy
import com.musinsa.histrixspring.config.web.client.open.CircuitOpenVO
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service
import java.net.SocketTimeoutException


@Service
class WebClientCB(
    val circuitOpen: CircuitOpenStrategy
) {

    @CircuitBreaker(name = "ab-test", fallbackMethod = "fallbackTest")
    fun getTest(percentage: Int, timeout: Int): String {
        try {
            circuitOpen.open(CircuitOpenVO(percentage = percentage, timeout = timeout))
        } catch (e: SocketTimeoutException) {
            e.printStackTrace()
            println(e)
        }
        return "success"
    }

    fun fallbackTest(ex: Exception): String {
        return "fail"
    }
}