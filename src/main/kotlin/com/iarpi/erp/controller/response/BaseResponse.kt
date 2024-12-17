package com.iarpi.erp.controller.response

import com.iarpi.erp.model.exception.BaseException
import com.iarpi.erp.model.exception.error.IarpiError
import org.springframework.http.HttpStatus

class BaseResponse<T>(
    val status: HttpStatus,
    val data: T?,
    val error: IarpiError?
) {

    companion object {
        fun <T> success(data: T): BaseResponse<T> {
            return BaseResponse(HttpStatus.OK, data, null)
        }

        fun failed(ex: BaseException, status: HttpStatus): BaseResponse<*> {
            return BaseResponse(status, ex.message, ex.error)
        }
    }

}