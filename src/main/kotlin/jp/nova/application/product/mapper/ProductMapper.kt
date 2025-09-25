package jp.nova.application.product.mapper

import jp.nova.api.product.dto.ProductRes
import jp.nova.domain.product.entity.Product
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface ProductMapper {
	@Mapping(source = "id", target = "id")
	@Mapping(source = "productName", target = "productName")
	@Mapping(source = "price", target = "price")
	@Mapping(source = "description", target = "description")
	fun toRes(product: Product): ProductRes

//    @Mapping(target = "id", ignore = true)
//    @Mapping(source = "productName", target = "productName")
//    @Mapping(source = "price", target = "price")
//    @Mapping(source = "description", target = "description")
//    fun toEntity(productReq: ProductReq) : Product
}
