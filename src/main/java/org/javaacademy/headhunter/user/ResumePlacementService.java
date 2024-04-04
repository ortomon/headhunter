package org.javaacademy.headhunter.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * сервис размещения резюме
 */
@Service
@RequiredArgsConstructor
public class ResumePlacementService {
    private final UserRepository userRepository;

    public void createUser(String name, String email) {
        userRepository.add(new User(name, email));
    }

    public void createResume(String userEmail, BigDecimal expectedSalary, String descriptionOfSkills) {
        findUserByEmail(userEmail).setResume(new Resume(expectedSalary, descriptionOfSkills));
    }

    public List<Resume> getResumesOfAllUsers() {
        return userRepository.getUsers().values().stream().map(User::getResume).collect(Collectors.toList());
    }

    private User findUserByEmail(String userEmail) {
        return userRepository.findUser(userEmail).orElseThrow();
    }
}
