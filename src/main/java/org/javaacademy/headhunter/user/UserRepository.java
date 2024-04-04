package org.javaacademy.headhunter.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Getter
public class UserRepository {
    private final Map<String, User> users = new HashMap<>();

    public void add(User user) {
        users.put(user.getEmail(), user);
    }

    public Optional<User> findUser(String email) {
        return Optional.ofNullable(users.get(email));
    }
}
