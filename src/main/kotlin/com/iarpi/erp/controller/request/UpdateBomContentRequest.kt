package com.iarpi.erp.controller.request

import java.math.BigDecimal

data class UpdateBomContentRequest(
    @field:jakarta.validation.constraints.NotBlank(message = "Komponent boş olamaz")
    @field:jakarta.validation.constraints.Size(max = 255, message = "Komponent 255 karakterden uzun olamaz")
    val component: String,

    @field:jakarta.validation.constraints.DecimalMin(
        value = "0.0",
        inclusive = false,
        message = "Miktar 0'dan büyük olmalıdır"
    )
    val quantity: BigDecimal,

    @field:jakarta.validation.constraints.NotNull(message = "Komponent BOM Türü boş olamaz")
    val compBomTypeId: Long?,

    @field:jakarta.validation.constraints.Size(
        max = 50,
        message = "Komponent BOM Tür Numarası 50 karakterden uzun olamaz"
    )
    val componentBomTypeNumber: String,
)
