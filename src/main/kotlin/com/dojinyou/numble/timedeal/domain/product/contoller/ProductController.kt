package com.dojinyou.numble.timedeal.domain.product.contoller

import com.dojinyou.numble.timedeal.domain.product.dto.CreateProductDto
import com.dojinyou.numble.timedeal.domain.product.dto.ProductDto
import com.dojinyou.numble.timedeal.domain.product.dto.UpdateProductDto
import com.dojinyou.numble.timedeal.domain.product.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID


@RequestMapping("products")
@RestController
class ProductController(
    private val productService: ProductService,
) {
    //TODO: AUTH(사용자)
    @PostMapping("/{productId}")
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(
        userId: UUID, // session에 저장된 userId 가져오기
        @PathVariable productId: UUID,
    ) {}

    //TODO: AUTH(관리자)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody createProductDto: CreateProductDto) {}

    //TODO: AUTH(관리자)
    @PatchMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    fun update(@PathVariable productId: UUID, @RequestBody updateProductDto: UpdateProductDto) {}

    //TODO: AUTH(관리자)
    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable productId: UUID) {}


    //TODO: Pagination
    @GetMapping("/open")
    fun findAllCurrentOpenedProducts(): List<ProductDto> {
        return emptyList()
    }

    //TODO: Pagination
    @GetMapping("/closed")
    fun findAllClosedProducts(): List<ProductDto> {
        return emptyList()
    }

    @GetMapping("/{productId}")
    fun getProduct(@PathVariable productId: UUID): ProductDto? {
        //TODO: nullable 제거
        return null
    }

    //TODO: AUTH(관리자)
    @GetMapping("/{productId}/purchase-users")
    fun getProductPurchaseUsers(@PathVariable productId: UUID): ProductDto? {
        //TODO: nullable 제거
        return null
    }

    //TODO: AUTH(사용자)
    //TODO: Pagination
    @GetMapping("/purchased/my")
    fun getAllPurchaseProductsByUser(
        userId: UUID, // session에 저장된 userId 가져오기
    ): List<ProductDto> {
        return emptyList()
    }
}

