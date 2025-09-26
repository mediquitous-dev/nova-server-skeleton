package jp.nova.domain.product

import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = false)
class ProductCommandService
