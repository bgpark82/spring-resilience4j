package com.musinsa.histrixspring.config.web.client.open

import com.musinsa.histrixspring.config.web.client.WebClientConstant
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

const val TIMEOUT_SUCCESS = 1
const val TIMEOUT_FAIL = 10000

//@Component
class CircuitOpenByTimeout(
    val restTemplate: RestTemplate
): CircuitOpenStrategy {

    override fun open(request: CircuitOpenVO) {
        val url = "${WebClientConstant.CB_TEST_BASE_URL}/timeout?timeout=${request.timeout}"
        restTemplate.getForObject(url, String::class.java)
    }

    override fun request() {
        for (i in 1..10) {
            RestTemplate().getForObject("${WebClientConstant.CB_TEST_BASE_URL}/my?delay=$TIMEOUT_FAIL", String::class.java)
        }

        Thread.sleep(12000)

        for (i in 1..100) {
            RestTemplate().getForObject("${WebClientConstant.CB_TEST_BASE_URL}/my?delay=$TIMEOUT_SUCCESS", String::class.java)
        }
    }
}