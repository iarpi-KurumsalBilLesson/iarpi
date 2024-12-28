package com.iarpi.erp.controller.request

import java.time.LocalDate

//todo: buraya ekleme yapabiliriz.
data class CreateNewMaterialHeadRequest(
    val docNumber : String,
    val matDocFrom : LocalDate,
    val matDocUntil : LocalDate,
    val supplyType : Boolean,
    val netWeight : Float,
    val brutWeight : Float,
    val isBom : Int,
    val bomDocNumber : String,
    val isRoute : Int,
    val rotDocNum : String,
    val isDeleted : Boolean,
    val isPassive : Boolean,
    val stUnitId : Long,
    val companyId : Long,
    val materialId : Long,
    val nwUnitId : Long,
    val bwUnitId : Long,
    val bomDocTypeId : Long,
    val rotDocTypeId : Long,
    val lanId : Long,
    val matsText : String,
    val matlText : String,
)
