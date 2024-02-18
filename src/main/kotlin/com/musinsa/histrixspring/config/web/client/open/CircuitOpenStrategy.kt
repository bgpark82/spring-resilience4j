package com.musinsa.histrixspring.config.web.client.open

interface CircuitOpenStrategy {

    fun open(request: CircuitOpenVO)

    fun request()
}