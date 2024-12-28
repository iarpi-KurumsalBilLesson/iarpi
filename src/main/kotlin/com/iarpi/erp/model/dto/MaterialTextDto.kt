package com.iarpi.erp.model.dto

import java.time.LocalDate

data class MaterialTextDto(
    val id : Long,
    val docNumber : String,
    val matDocFrom : LocalDate,
    val matDocUntil : LocalDate,
    val matsText : String,
    val matltText : String,
    val companyId : Long,
    val matDocTypeId : Long,
    val lanCodeId : Long,

)
