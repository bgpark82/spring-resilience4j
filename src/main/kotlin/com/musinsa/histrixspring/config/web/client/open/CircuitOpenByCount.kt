package com.musinsa.histrixspring.config.web.client.open

import com.musinsa.histrixspring.config.web.client.WebClientConstant
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

const val PERCENTAGE_FAIL = 10000
const val PERCENTAGE_THROUGHPUT = 5

@Component
class CircuitOpenByCount(
    val restTemplate: RestTemplate
): CircuitOpenStrategy {

    override fun open(request: CircuitOpenVO) {
//        if (request.percentage > PERCENTAGE_THROUGHPUT) {
//            println("에러발생!")
//            throw RuntimeException("percentage must be less than 5!")
//        }
        val url = "${WebClientConstant.CB_TEST_BASE_URL}/count"
        restTemplate.getForObject(url, String::class.java)
    }

    override fun request() {
        for (i in 1..10) {
            RestTemplate().getForObject("${WebClientConstant.CB_TEST_BASE_URL}/my?percentage=$PERCENTAGE_FAIL", String::class.java)
        }
    }
}