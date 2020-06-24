package com.sharpenroll.tcmmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableTransactionManagement
@EnableAsync
@EnableScheduling
@SpringBootApplication
@MapperScan("com.sharpenroll.tcmmanager.*.mapper")
public class TcmManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcmManagerApplication.class, args);
	}

}
