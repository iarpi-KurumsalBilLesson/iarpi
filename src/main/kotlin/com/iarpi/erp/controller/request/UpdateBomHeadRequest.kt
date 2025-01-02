package com.iarpi.erp.controller.request

import java.math.BigDecimal

data class UpdateBomHeadRequest(
    @field:jakarta.validation.constraints.DecimalMin(
        value = "0.0",
        inclusive = false,
        message = "Miktar 0'dan büyük olmalıdır"
    )
    val quantity: BigDecimal,
)