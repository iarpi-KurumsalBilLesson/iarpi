package com.iarpi.erp.model.exception

import com.iarpi.erp.model.exception.error.IarpiError

open class BaseException(
    val error: IarpiError,
    override val message: String = error.message
) : RuntimeException(message)
