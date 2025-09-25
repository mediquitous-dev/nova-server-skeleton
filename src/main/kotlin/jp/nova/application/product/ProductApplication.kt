package jp.nova.application.product

import jp.nova.application.product.mapper.ProductMapper
import jp.nova.domain.product.ProductQueryService
import jp.nova.api.product.dto.ProductRes
import org.mapstruct.factory.Mappers
import java.util.stream.Collectors

class ProductApplication(
    val productQueryService: ProductQueryService,
) {
    val converter = Mappers.getMapper(ProductMapper::class.java)

    // validation, aggregation
    fun findById(id: Long): ProductRes {
        val product = productQueryService.findById(id)
        val productRes = converter.toRes(product)

        // return ProductRes.of(product.id!!, product.productName, product.price)
        return productRes
    }

    fun findAll(): List<ProductRes> {
        val products = productQueryService.findAll()
        return products
            .stream()
            .map { product -> converter.to(product) }
            .collect(Collectors.toList()) as List<ProductRes>

        // return ProductRes.of(product.id!!, product.productName, product.price)
    }
}
