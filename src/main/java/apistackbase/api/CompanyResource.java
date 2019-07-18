package apistackbase.api;


import apistackbase.core.Company;
import apistackbase.core.Employee;
import apistackbase.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

    @PutMapping
    public Company update(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        companyRepository.deleteById(id);
    }

    @DeleteMapping
    public void multipleDelete(@RequestBody List<Company> companies) {
        companyRepository.deleteAll(companies);
    }

    @GetMapping(value = "", params = {"companyName"})
    public List<Company> findCompanyByCompanyName(@RequestParam String companyName) {
        return companyRepository.findByName(companyName);
    }

    @PostMapping("/{id}/employees")
    public Company addEmployees(@PathVariable Long id,@RequestBody Employee employee) {
        Company company=companyRepository.findById(id).orElse(null);
        if(company==null){
            return null;
        }
        if(company.getEmployees().stream().mapToLong(Employee::getSalary).sum()+employee.getSalary()>company.getCost()){
            return null;
        }
        int male= (int) company.getEmployees().stream().filter(it->it.getGender().equals("male")).count();
        int female= company.getEmployees().size()-male;
        company.getEmployees().add(employee);
        if(Math.abs(male-female)>3){
            return null;
        }
       return companyRepository.save(company);
    }

}
