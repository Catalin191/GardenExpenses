package com.example.ExpensesApp;

import com.example.ExpensesApp.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpensesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}

}
