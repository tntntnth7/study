package com.project.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
* 화면설명
* 앞으로 만들 프로젝트의 메인 클래스
* SpringBootApplication 으로 인해 스프링 부트의 자동설정, 스프링 Bean 읽기와 생성 모두 자동 설정
* 해당 클래스가 가장 최상단 해당 클래스부터 설정 읽기 진행
* */

//@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS 역할 수행
    }
}
