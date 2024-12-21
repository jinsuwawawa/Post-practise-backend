package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@MapperScan("org.example.mapper")
@SpringBootApplication
public class StudentCourseManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentCourseManagementSystemApplication.class, args);
    }
}
