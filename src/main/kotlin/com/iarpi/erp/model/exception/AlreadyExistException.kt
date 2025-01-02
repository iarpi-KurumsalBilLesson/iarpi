package com.iarpi.erp.model.exception

import com.iarpi.erp.model.exception.error.IarpiError

class AlreadyExistException(field: String) :
    BaseException(IarpiError.ALREADY_EXISTS, field) {

}
