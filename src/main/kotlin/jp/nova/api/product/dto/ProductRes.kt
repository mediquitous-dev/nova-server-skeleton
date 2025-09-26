package jp.nova.api.product.dto

data class ProductRes(
    val id: Long,
    val productName: String,
    val price: Long,
    val description: String?,
) {
    companion object {
        fun of(
            id: Long,
            productName: String,
            price: Long,
        ): ProductRes = ProductRes(id, productName, price, null)
    }
}
