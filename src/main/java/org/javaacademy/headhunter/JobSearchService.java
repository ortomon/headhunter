package org.javaacademy.headhunter;

import lombok.RequiredArgsConstructor;
import org.javaacademy.headhunter.company.JobPlacementService;
import org.javaacademy.headhunter.company.Vacancy;
import org.javaacademy.headhunter.user.Resume;
import org.javaacademy.headhunter.user.ResumePlacementService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * сервис поиска работы
 */
@Service
@RequiredArgsConstructor
public class JobSearchService {
    private final JobPlacementService jobPlacementService;
    private final ResumePlacementService resumePlacementService;

    public void createCompany(String name) {
        jobPlacementService.createCompany(name);
    }

    public void createVacancyInCompany(String companyName,
                                       String position,
                                       String jobDescription,
                                       String salary) {

        jobPlacementService.createVacancyInCompany(companyName, position, jobDescription, new BigDecimal(salary));
    }

    public List<Vacancy> findVacanciesByCompanyName(String companyName) {
        return jobPlacementService.findVacanciesByCompanyName(companyName);
    }

    public void createUser(String name, String email) {
        resumePlacementService.createUser(name, email);
    }

    public void createResume(String userEmail, BigDecimal expectedSalary, String descriptionOfSkills) {
        resumePlacementService.createResume(userEmail, expectedSalary, descriptionOfSkills);
    }

    public List<Resume> getResumesOfAllUsers() {
        return resumePlacementService.getResumesOfAllUsers();
    }
}
