package com.iarpi.erp.controller.control.request

import com.iarpi.erp.model.entity.control.BomEntity

data class UpdateBomRequest(
    var docText: String,
    var isPassive: Boolean
)

fun UpdateBomRequest.applyUpdatesTo(entity: BomEntity): BomEntity {
    return entity.apply {
        this.docText = this@applyUpdatesTo.docText
        this.isPassive = this@applyUpdatesTo.isPassive
    }
}
