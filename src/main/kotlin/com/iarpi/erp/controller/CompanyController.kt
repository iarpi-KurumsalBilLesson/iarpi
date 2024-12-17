package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateCompanyRequest
import com.iarpi.erp.controller.request.UpdateCompanyRequest
import com.iarpi.erp.controller.request.convertToDto
import com.iarpi.erp.controller.response.BaseCollectionResponse
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.CompanyDto
import com.iarpi.erp.service.CompanyService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/gen")
class CompanyController(val companyService: CompanyService) {


    @GetMapping("/{comCode}")
    fun getCompanyByComCode(@PathVariable comCode: String): BaseResponse<CompanyDto> {
        val upperComCode = comCode.uppercase()
        val response = companyService.getCompanyByComCode(upperComCode)
        return BaseResponse.success(response)
    }

    @GetMapping()
    fun getCompanyByComCode(): BaseCollectionResponse<CompanyDto> {
        val response = companyService.getAll()
        return BaseCollectionResponse.success(response)
    }

    @PostMapping
    fun createNewCompany(@RequestBody req: CreateCompanyRequest): BaseResponse<CompanyDto> {
        val company = req.convertToDto()
        val response = companyService.createNewCompany(company)
        return BaseResponse.success(response)
    }

    @PutMapping
    fun updateCompany(@RequestBody req: UpdateCompanyRequest): BaseResponse<CompanyDto> {
        //todo : burada hep aklına takılan bir durum var, guncellemeyi nasıl yapıcaz ? * new Instance / same Id *
        val company = req.convertToDto()
        val response = companyService.updateComTextWithComCode(company)
        return BaseResponse.success(response)
    }

    @DeleteMapping("/{comCode}")
    fun deleteCompany(@PathVariable comCode: String): BaseResponse<String> {
        val response = companyService.deleteCompanyWithComCode(comCode)
        return BaseResponse.success(response)
    }
}