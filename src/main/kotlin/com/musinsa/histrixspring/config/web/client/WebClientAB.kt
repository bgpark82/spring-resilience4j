package com.musinsa.histrixspring.config.web.client

import com.musinsa.histrixspring.config.abtest.BucketVO
import com.musinsa.histrixspring.config.abtest.ExperimentVO
import com.musinsa.histrixspring.config.web.client.WebClientConstant.AB_TEST_BASE_URL
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class WebClientAB {

    @CircuitBreaker(name = "ab-test-experiments-cb", fallbackMethod = "fallbackExperiment")
    fun getExperiments(): String {
        val url = "$AB_TEST_BASE_URL/experiments?apiType=RANKING&deleteYn=N"
        val response = RestTemplate().getForObject(url, String::class.java)
        return "RANKING_1"
    }

    @CircuitBreaker(name = "ab-test-experiment-cb", fallbackMethod = "fallbackExperiment")
    fun getExperimentById(experimentId: String?): ExperimentVO? {
        val url = "$AB_TEST_BASE_URL/experiments/${experimentId}"
        return RestTemplate().getForObject(url, ExperimentVO::class.java)
    }

    @CircuitBreaker(name = "ab-test-bucket-cb", fallbackMethod = "fallbackBucket")
    fun getBuckets(experimentId: String): BucketVO? {
        val url = "$AB_TEST_BASE_URL/abtest?uuid=${experimentId}&requestKey=12345"
        return RestTemplate().getForObject(url, BucketVO::class.java)
    }

    fun fallbackExperiment(): String {
        return "RANKING_1"
    }

    fun fallbackBucket(): String {
        return "RANKING_1"
    }
}