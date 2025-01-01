package com.iarpi.erp.controller.control.request

import com.iarpi.erp.model.entity.control.CompanyEntity
import com.iarpi.erp.model.entity.control.OperationEntity
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CreateOperationRequest(
    @field:NotNull(message = "Company ID must not be null")
    val companyId: Long,

    @field:NotBlank(message = "Doc Type must not be empty")
    @field:Size(max = 4, message = "Doc Type cannot be longer than 4 characters")
    val docType: String,

    @field:NotBlank(message = "Doc Text must not be empty")
    @field:Size(max = 80, message = "Doc Text cannot be longer than 80 characters")
    val docText: String,

    val isPassive: Boolean = false
)

fun CreateOperationRequest.convertToEntity(company: CompanyEntity): OperationEntity {
    return OperationEntity(
        id = null,
        docType = this.docType,
        docText = this.docText,
        isPassive = this.isPassive,
        company = company
    )
}
