package com.musinsa.histrixspring.config.abtest

data class ExperimentVO(

    val uuid: String,

    val buckets: List<BucketVO>?
)

