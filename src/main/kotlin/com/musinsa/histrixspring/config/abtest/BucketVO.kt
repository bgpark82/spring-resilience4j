package com.musinsa.histrixspring.config.abtest

data class BucketVO(
    val id: Long,

    val name: String,

    val ratio: Int,

    val requestInfo: Map<String, Any>,

    val title: String
)
