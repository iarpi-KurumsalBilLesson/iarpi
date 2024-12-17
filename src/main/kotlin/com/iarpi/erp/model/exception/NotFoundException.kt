package com.iarpi.erp.model.exception

import com.iarpi.erp.model.exception.error.IarpiError

class NotFoundException(field: String) :
    BaseException(IarpiError.NOT_FOUND, String.format(IarpiError.NOT_FOUND.message, field)) {
}
