package com.salesianostriana.dam._EjemploSpringBoot2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner runner(ApplicationContext ctx, Servicio servicio){
		return args -> {
			/*for(String s : ctx.getBeanDefinitionNames()){
				System.out.println(s);
			}*/
			servicio.run();
		};
	}

}
