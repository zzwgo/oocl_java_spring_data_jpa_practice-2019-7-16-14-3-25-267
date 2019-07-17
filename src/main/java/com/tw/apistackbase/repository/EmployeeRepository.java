package com.tw.apistackbase.repository;

import com.tw.apistackbase.core.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
