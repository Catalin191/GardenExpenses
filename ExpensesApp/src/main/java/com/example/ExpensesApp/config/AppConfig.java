package com.example.ExpensesApp.config;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan("com.example.ExpensesApp")
@EntityScan("com.example.ExpensesApp.entity")
@EnableJpaRepositories("com.example.ExpensesApp.repository")
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
}
