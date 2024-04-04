package org.javaacademy.headhunter.company;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class CompanyRepository {
    private final Map<String, Company> companies = new HashMap<>();

    public void addCompany(Company company) {
        companies.put(company.getName(), company);
    }

    public Optional<Company> findByName(String name) {
        return  Optional.ofNullable(companies.get(name));
    }

    public void deleteAll() {
        companies.clear();
    }
}
