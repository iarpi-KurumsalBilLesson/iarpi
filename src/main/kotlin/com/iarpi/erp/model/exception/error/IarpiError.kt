package com.iarpi.erp.model.exception.error

import org.springframework.http.HttpStatus

enum class IarpiError(val message: String, val status: HttpStatus) {

    NOT_FOUND("Record not founded by %s", HttpStatus.NOT_FOUND),
    ALREADY_EXISTS("Record not founded by %s", HttpStatus.BAD_REQUEST),
    BAD_REQUEST("Request must be correct",HttpStatus.BAD_REQUEST)
}
