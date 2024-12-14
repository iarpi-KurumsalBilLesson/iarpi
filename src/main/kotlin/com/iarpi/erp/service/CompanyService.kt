package com.iarpi.erp.service

import com.iarpi.erp.model.entity.CompanyEntity

interface CompanyService {

    fun createNewCompany(): CompanyEntity;
    fun deleteCompanyWithComCode();
    fun findCompanyWithComCode();
    fun updateComTextWithComCode();
}