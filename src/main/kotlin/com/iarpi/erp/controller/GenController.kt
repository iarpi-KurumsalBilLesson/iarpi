package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateCompanyRequest
import com.iarpi.erp.controller.request.UpdateCompanyRequest
import com.iarpi.erp.model.dto.Company
import com.iarpi.erp.model.entity.CompanyEntity
import com.iarpi.erp.service.CompanyService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/gen")
class GenController(val companyService: CompanyService) {

    //todo : Create+ / Update+ / Delete+ / Pagination ??

    @PostMapping
    fun createNewCompany(@RequestBody req: CreateCompanyRequest): CompanyEntity {
        val company = Company(req.comCode, req.comText)
        return companyService.createNewCompany(company)
    }

    @PutMapping
    fun updateCompany(@RequestBody req: UpdateCompanyRequest): CompanyEntity {
        //todo : burada hep aklına takılan bir durum var, guncellemeyi nasıl yapıcaz ? * new Instance / same Id *
        val company = Company(req.comCode, req.comText)
        return companyService.updateComTextWithComCode(company)
    }

    @DeleteMapping
    fun deleteCompany(comCode: String): String {
        return companyService.deleteCompanyWithComCode(comCode)
    }
}