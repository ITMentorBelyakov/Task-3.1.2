package ru.itmentor.spring.boot_security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityDemoApplication.class, args);

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode("password");
		System.out.println(encodedPassword);
	}

}
