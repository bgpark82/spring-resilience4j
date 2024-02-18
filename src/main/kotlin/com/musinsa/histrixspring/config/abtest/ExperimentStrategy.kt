package com.musinsa.histrixspring.config.abtest

interface ExperimentStrategy {

    fun start(uuid: String?): ExperimentVO
}