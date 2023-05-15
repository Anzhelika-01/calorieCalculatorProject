package com.tusofia.caloriecalculatorproject.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CalculatorForm {

    @NotNull
    public String sex;

    @Min(10)
    @Max(300)
    public double weight;

    @Min(20)
    @Max(250)
    public double height;

    @Min(7)
    @Max(100)
    public int age;

    @NotNull
    public String activityLevel;
}
