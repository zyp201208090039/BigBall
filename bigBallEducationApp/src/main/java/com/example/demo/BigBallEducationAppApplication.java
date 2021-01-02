package com.example.demo;

import com.example.demo.DataBase.ConfigDataBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class BigBallEducationAppApplication {

	public static void main(String[] args) {
		System.out.println("初始化进入main 函数");
		ConfigDataBase.Initial();
		SpringApplication.run(BigBallEducationAppApplication.class, args);
	}

}
