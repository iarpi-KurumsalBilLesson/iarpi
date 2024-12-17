package com.iarpi.erp.model.exception

import com.iarpi.erp.model.exception.error.IarpiError

class AlreadyExistException(field: String) :
    BaseException(IarpiError.ALREADY_EXISTS, String.format(IarpiError.ALREADY_EXISTS.message, field)) {

}
