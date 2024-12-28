package com.iarpi.erp.model.dto

data class MaterialDto(val materialHeadDto: MaterialHeadDto?, val materialTextDto: MaterialTextDto?)

/*
fun MaterialDto.convertToEntity() : MaterialHeadEntity{
    return MaterialHeadEntity(
        null,
        this.materialHeadDto.docNumber,
        this.materialHeadDto.matDocFrom,
        this.materialHeadDto.matDocUntil,
        this.materialHeadDto.supplyType,
        this.materialHeadDto.netWeight,
        this.materialHeadDto.brutWeight,
        this.materialHeadDto.isBom,
        this.materialHeadDto.bomDocNumber,
        this.materialHeadDto.isRoute,
        this.materialHeadDto.rotDocNum,
        this.materialHeadDto.isDeleted,
        this.materialHeadDto.isPassive,

    )
}*/
