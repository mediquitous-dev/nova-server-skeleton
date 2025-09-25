package jp.nova.api.product.dto

data class ProductReq(
	// https://medium.com/@hee98.09.14/kotlin-spring-boot%EC%97%90%EC%84%9C-request-%EC%9C%A0%ED%9A%A8%EC%84%B1-%EA%B2%80%EC%82%AC%ED%95%98%EA%B8%B0-f9e68d70fb2f
	// @field:NotBlank(message = "상품명은 필수입니다.")
	val productName: String?,
	val price: Long,
	// @field:NotEmpty(message = "내용을 입력해주세요.")
	val description: String?,
)
