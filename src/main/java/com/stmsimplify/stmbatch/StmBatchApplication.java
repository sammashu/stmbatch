package com.stmsimplify.stmbatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// spring batch by default is configure for url database (jdbc) need exclude the DatSourceAutoConfiguration
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class StmBatchApplication{

	public static void main(String[] args) {
		SpringApplication.run(StmBatchApplication.class, args);
	}
}
