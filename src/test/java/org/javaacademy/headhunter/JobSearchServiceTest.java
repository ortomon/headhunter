package org.javaacademy.headhunter;

import org.javaacademy.headhunter.company.JobPlacementService;
import org.javaacademy.headhunter.company.Vacancy;
import org.javaacademy.headhunter.user.Resume;
import org.javaacademy.headhunter.user.ResumePlacementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
@ActiveProfiles("china")
public class JobSearchServiceTest {
    @Autowired
    private JobSearchService jobSearchService;
    @MockBean
    private JobPlacementService jobPlacementService;
    @MockBean
    private ResumePlacementService resumePlacementService;

    @Test
    void createCompanySuccess() {
        Assertions.assertDoesNotThrow(() -> jobSearchService.createCompany(""));
    }

    @Test
    void createVacancyInCompanySuccess() {
        Assertions.assertDoesNotThrow(
                () -> jobSearchService.createVacancyInCompany("", "", "", "2"));
    }

    @Test
    void createVacancyInCompanyFail() {
        Assertions.assertThrows(
                NumberFormatException.class,
                () -> jobSearchService.createVacancyInCompany("", "", "", ""));
    }

    @Test
    void findVacanciesByCompanyNameSuccess() {
        Mockito.when(jobPlacementService.findVacanciesByCompanyName(Mockito.any())).thenReturn(List.of());
        List<Vacancy> vacanciesByCompanyName = jobSearchService.findVacanciesByCompanyName("");
        Assertions.assertEquals(List.of(), vacanciesByCompanyName);
    }

    @Test
    void createUserSuccess() {
        Assertions.assertDoesNotThrow(() -> jobSearchService.createUser("", ""));
    }

    @Test
    void createResumeSuccess() {
        Assertions.assertDoesNotThrow(() -> jobSearchService.createResume("", BigDecimal.ONE, ""));
    }

    @Test
    void getResumesOfAllUsersSuccess() {
        Mockito.when(resumePlacementService.getResumesOfAllUsers()).thenReturn(List.of());
        List<Resume> resumesOfAllUsers = jobSearchService.getResumesOfAllUsers();
        Assertions.assertEquals(List.of(), resumesOfAllUsers);
    }
}
