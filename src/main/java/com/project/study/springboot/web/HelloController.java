package com.project.study.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* ① RestController
* 컨트롤러를 Json 으로 반환하는 컨트롤러로 변환
* 예전 ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있도록 해준다.
* */

/*
 * ② GetMapping
 * http method 인 Get의 요청을 받을 수 있는 API를 만들어준다.
 * */

@RestController // ①
public class HelloController {

    @GetMapping("/hello") // ②
    public String hello(){
        return "hello";
    }
}
