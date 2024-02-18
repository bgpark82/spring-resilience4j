package com.musinsa.histrixspring.config.abtest

import com.musinsa.histrixspring.config.web.client.WebClientAB
import org.springframework.stereotype.Component

@Component
class ExperimentByCategory(
    val webClientAB: WebClientAB
): ExperimentStrategy {

    override fun start(uuid: String?): ExperimentVO {
        return webClientAB.getExperimentById(uuid) ?: ExperimentVO("ranking_goods_default", null)
    }
}