package com.tw.apistackbase.api;

import com.tw.apistackbase.core.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tw.apistackbase.repository.CompanyRepository;

@RestController
@RequestMapping("/companies")
public class CompanyResource {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping(produces = {"application/json"})
    public Iterable<Company> list() {
        return companyRepository.findAll();
    }
    
    @PostMapping(produces = {"application/json"})
    public Company add(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @PutMapping(produces = {"application/json"})
    public Company update(@RequestBody Company company) {
        companyRepository.save(company);
        return company;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        companyRepository.deleteById(id);
    }

}
