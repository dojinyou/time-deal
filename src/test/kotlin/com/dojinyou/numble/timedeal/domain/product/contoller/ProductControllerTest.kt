package com.dojinyou.numble.timedeal.domain.product.contoller

import com.dojinyou.numble.timedeal.BaseControllerTest
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc


@RunWith(SpringRunner::class)
@WebMvcTest(ProductController::class)
class ProductControllerTest: BaseControllerTest() {

    @Autowired
    private lateinit var mockMvc: MockMvc
}
