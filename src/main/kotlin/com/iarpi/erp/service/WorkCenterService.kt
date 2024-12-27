package com.iarpi.erp.service

import com.iarpi.erp.model.dto.WorkCenterDto

interface WorkCenterService {

    fun getAll(): List<WorkCenterDto>
    fun getById(id: Long): WorkCenterDto
    fun createNewWorkCenter(workCenterDto: WorkCenterDto): WorkCenterDto
    fun updateWorkCenter(id: Long, workCenterDto: WorkCenterDto): WorkCenterDto
    fun deleteWorkCenter(id: Long): String

}
