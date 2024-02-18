package com.musinsa.histrixspring.controller

import com.musinsa.histrixspring.config.web.handle_arugment.Logic
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController {

    @GetMapping("/my")
    fun my(
        @Logic logic: String?,
        @RequestParam(value = "delay", defaultValue = "0") delayed: Int = 0,
        @RequestParam(value = "percentage", defaultValue = "0") percentage: Int = 0
    ): String {
        println("[${this.javaClass.simpleName}] logic=${logic}")
        return logic ?: "null"
    }

    @GetMapping("/timeout")
    fun timeout(
        @RequestParam(value = "timeout", defaultValue = "100") timeout: Int = 100
    ): String {
        Thread.sleep(timeout.toLong())
        return timeout.toString()
    }

    @GetMapping("/count")
    fun count(): String {
        throw IllegalStateException("에러 발생!")
    }
}