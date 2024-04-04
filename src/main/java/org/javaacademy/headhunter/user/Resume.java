package org.javaacademy.headhunter.user;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class Resume {
    private BigDecimal expectedSalary;
    private String descriptionOfSkills;
}
