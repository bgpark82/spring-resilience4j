package com.musinsa.histrixspring.config.abtest

import org.springframework.stereotype.Service

@Service
class ABTestService(
    val experimentStrategy: ExperimentStrategy,
    val bucketService: BucketService
) {
    
    fun getLogic(experimentId: String): String {
        val experiment = experimentStrategy.start(experimentId)
        val bucket = bucketService.start(experimentId)

        val currBucket = experiment.buckets?.filter { b ->
            b.id == bucket.id
        }?.firstOrNull()

        return currBucket?.requestInfo?.get("logic")?.toString() ?: "기본"
    }
}