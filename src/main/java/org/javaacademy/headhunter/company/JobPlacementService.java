package org.javaacademy.headhunter.company;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * сервис размещения вакансий
 */
@Service
@RequiredArgsConstructor
public class JobPlacementService {
    private final CompanyRepository companyRepository;
    @Value("${currency}")
    private String currency;

    public void createCompany(String name) {
        companyRepository.addCompany(new Company(name));
    }

    public void createVacancyInCompany(String companyName,
                                       String position,
                                       String jobDescription,
                                       BigDecimal salary) {

        findCompanyByName(companyName).getVacancies().add(new Vacancy(position, jobDescription, salary, currency));
    }

    public List<Vacancy> findVacanciesByCompanyName(String companyName) {
        return findCompanyByName(companyName).getVacancies();
    }

    private Company findCompanyByName(String name) {
        return companyRepository.findByName(name).orElseThrow();
    }
}
