package com.musinsa.histrixspring.config.abtest

import com.musinsa.histrixspring.config.web.client.WebClientAB
import org.springframework.stereotype.Service

@Service
class BucketService(
    val webClientAB: WebClientAB
) {

    fun start(experimentId: String): BucketVO {
        return webClientAB.getBuckets(experimentId) ?: BucketVO(1, "default", 100, emptyMap(), "title")
    }
}