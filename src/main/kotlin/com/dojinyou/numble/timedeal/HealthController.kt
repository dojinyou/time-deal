package com.dojinyou.numble.timedeal

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController {
    @GetMapping("health")
    @ResponseStatus(HttpStatus.OK)
    fun healthCheck() { /* 헬스체크용 api */ }
}
