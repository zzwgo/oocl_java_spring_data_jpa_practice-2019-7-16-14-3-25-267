package com.tw.apistackbase.repository;


import apistackbase.core.Company;
import apistackbase.core.CompanyProfile;
import apistackbase.repository.CompanyProfileRepository;
import apistackbase.repository.CompanyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class CompanyRepositoryTest {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyProfileRepository companyProfileRepository;

    @Test
    public void should_save_and_fetch_companyProfile_entity() {
        CompanyProfile companyProfile = new CompanyProfile();
        companyProfile.setCertId("CompanyProfile");

        CompanyProfile companyProfileInDb = companyProfileRepository.save(companyProfile);
        CompanyProfile companyProfileFetched = companyProfileRepository.findById(companyProfileInDb.getId()).orElse(null);

        assertNotNull(companyProfileFetched);
        assertEquals(companyProfile.getCertId(), companyProfileFetched.getCertId());
    }

    @Test
    public void should_not_save_companyProfile_when_length_of_name_more_than_64() {
        CompanyProfile companyProfile = new CompanyProfile();
        companyProfile.setCertId("This is a fucking loooooooooooooooooooooooooooooooooooong name test for companyProfile.");

        assertThrows(Exception.class, () -> companyProfileRepository.saveAndFlush(companyProfile));
    }

    @Test
    public void should_find_company_profile_when_save_company() {
        CompanyProfile companyProfile = new CompanyProfile();
        companyProfile.setCertId("CRET1234");
        Company company = new Company();
        company.setName("Name");
        company.setProfile(companyProfile);

        CompanyProfile companyProfileInDb = companyRepository.saveAndFlush(company).getProfile();
        CompanyProfile fetchedCompanyProfile = companyProfileRepository.findById(companyProfileInDb.getId()).orElse(null);

        assertNotNull(fetchedCompanyProfile);
        assertEquals(companyProfile.getCertId(), fetchedCompanyProfile.getCertId());
    }

    @Test
    public void should_not_save_company_without_companyProfile() {
        Company company = new Company();
        company.setName("Name");

        assertThrows(Exception.class, () -> companyRepository.saveAndFlush(company));
    }
}