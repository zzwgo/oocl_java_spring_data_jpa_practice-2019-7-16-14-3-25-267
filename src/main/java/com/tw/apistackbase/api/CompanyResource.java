package com.tw.apistackbase.api;

import com.tw.apistackbase.core.Company;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyResource {
    
    @GetMapping(produces = {"application/json"})
    public Iterable<Company> list() {
        return null;
    }
    
    @PostMapping(produces = {"application/json"})
    public Company add(@RequestBody Company company) {
        return null;
    }
}
