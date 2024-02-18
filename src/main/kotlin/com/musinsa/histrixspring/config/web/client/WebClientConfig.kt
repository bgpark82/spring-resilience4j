package com.musinsa.histrixspring.config.web.client

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import java.time.Duration

@Configuration
class WebClientConfig {

    //https://mangkyu.tistory.com/256
    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplateBuilder()
            .setConnectTimeout(Duration.ofMillis(WebClientConstant.CONNECTION_TIMEOUT)) // 연결 타임아웃 설정
            .setReadTimeout(Duration.ofMillis(WebClientConstant.READ_TIMEOUT)) // 읽기 타임아웃 설정
            .build()
    }
}