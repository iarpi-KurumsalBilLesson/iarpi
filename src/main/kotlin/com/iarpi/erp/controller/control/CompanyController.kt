package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.control.request.CreateCompanyRequest
import com.iarpi.erp.controller.control.request.UpdateCompanyRequest
import com.iarpi.erp.controller.control.request.convertToDto
import com.iarpi.erp.controller.response.BaseCollectionResponse
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.control.CompanyDto
import com.iarpi.erp.service.control.CompanyService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/gen")
class CompanyController(val companyService: CompanyService) {

    @GetMapping("/{comCode}")
    fun getCompanyByComCode(@PathVariable comCode: String): BaseResponse<CompanyDto> {
        val upperComCode = comCode.uppercase()
        val response = companyService.getByComCode(upperComCode)

        return BaseResponse.success(response)
    }

    @GetMapping()
    fun getCompanyByComCode(): BaseCollectionResponse<CompanyDto> {
        val response = companyService.getAll()

        return BaseCollectionResponse.success(response)
    }

    @PostMapping
    fun createNewCompany(@Valid @RequestBody req: CreateCompanyRequest): BaseResponse<CompanyDto> {
        val company = req.convertToDto()
        val response = companyService.createNewCompany(company)

        return BaseResponse.success(response)
    }

    @PutMapping("/{id}")
    fun updateCompany(@PathVariable id: Long, @Valid @RequestBody req: UpdateCompanyRequest): BaseResponse<CompanyDto> {
        val company = req.convertToDto()
        company.id = id

        val response = companyService.updateComText(company)

        return BaseResponse.success(response)
    }

    @DeleteMapping("/{id}")
    fun deleteCompany(@PathVariable id: Long): BaseResponse<String> {
        val response = companyService.deleteById(id)

        return BaseResponse.success(response)
    }
}