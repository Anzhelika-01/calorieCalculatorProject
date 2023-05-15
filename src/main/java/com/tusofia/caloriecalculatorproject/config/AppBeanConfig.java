package com.tusofia.caloriecalculatorproject.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tusofia.caloriecalculatorproject.dto.CalculatorForm;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class AppBeanConfig {
    @Bean
    public Gson gson() {
        return new GsonBuilder().setPrettyPrinting().create();
    }

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();

        modelMapper.addConverter(mappingContext ->
                        LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                String.class,
                LocalDate.class);

        return modelMapper;
    }

    @Bean
    public CalculatorForm calorieCalculatorForm(){
        return new CalculatorForm();
    }
}