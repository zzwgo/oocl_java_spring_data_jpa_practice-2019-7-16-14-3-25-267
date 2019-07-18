package apistackbase.repository;

import apistackbase.core.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query
    public List<Company> findByName(String name);

}
