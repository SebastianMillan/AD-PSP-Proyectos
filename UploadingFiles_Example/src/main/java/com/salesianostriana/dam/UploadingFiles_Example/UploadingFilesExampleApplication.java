package com.salesianostriana.dam.UploadingFiles_Example;

import com.salesianostriana.dam.UploadingFiles_Example.prop.StorageProperties;
import com.salesianostriana.dam.UploadingFiles_Example.services.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class UploadingFilesExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadingFilesExampleApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}

