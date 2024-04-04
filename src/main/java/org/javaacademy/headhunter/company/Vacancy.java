package org.javaacademy.headhunter.company;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@ToString
public class Vacancy {
    private String position;
    private String jobDescription;
    private BigDecimal salary;
    private String currency;
}
