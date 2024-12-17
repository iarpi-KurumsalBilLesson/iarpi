package com.iarpi.erp.controller.response

import com.iarpi.erp.model.exception.AlreadyExistException
import com.iarpi.erp.model.exception.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerAdvice {

    @ExceptionHandler
    fun handleNotFoundException(ex: NotFoundException): BaseResponse<*> {
        return BaseResponse.failed(ex, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleAlreadyExistException(ex: AlreadyExistException): BaseResponse<*> {
        return BaseResponse.failed(ex, HttpStatus.BAD_REQUEST)
    }
}