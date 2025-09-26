package jp.nova.domain.product.entity

// @Entity
class Product(
    val id: Long?,
    val productName: String,
    val price: Long,
    val description: String?,
)
