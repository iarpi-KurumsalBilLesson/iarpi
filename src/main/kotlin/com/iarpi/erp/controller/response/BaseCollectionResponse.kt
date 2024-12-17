package com.iarpi.erp.controller.response

import com.iarpi.erp.model.exception.error.IarpiError
import org.springframework.http.HttpStatus

class BaseCollectionResponse<T>(
    val status: HttpStatus,
    val data: List<T>?,
    val error: IarpiError?
) {
    companion object {
        fun <T> success(data: List<T>): BaseCollectionResponse<T> {
            return BaseCollectionResponse(HttpStatus.OK, data, null)
        }

        fun <T> failed(data: T, error: IarpiError): BaseCollectionResponse<T> {
            return BaseCollectionResponse(error.status, null, error)
        }
    }
}