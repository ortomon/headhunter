package org.javaacademy.headhunter.user;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class User {
    @NonNull
    private String name;
    @NonNull
    private String email;
    @Setter
    private Resume resume;
}
