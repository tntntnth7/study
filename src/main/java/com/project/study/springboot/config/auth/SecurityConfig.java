package com.project.study.springboot.config.auth;

import com.project.study.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Spring security 설정들을 활성화 시켜준다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().headers().frameOptions().disable() //h2-console 화면을 사용하기 위해 해당옵션들을 disable 한다.
                .and()
                    .authorizeRequests() // url 별 권한 관리를 설정하는 옵션의 시작점
                    .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll() // "/" 등 지정된 URL 들은 permitall 옵션을 통해 전체 열람 권한 부여
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // "api/v1/" 주소를 가진 API는 USER 권한을 가진 사람만 가능하도록 설정
                    .anyRequest().authenticated() // 설정된 값을 제외한 모든 url에 authenticated를 추가하여 나머지 url 들은 모두 인증된 사용자들에게만 허용 (인증된 사용자란 로그인한 사용자)
                .and()
                    .logout() // 로그아웃 설정에 대한 진입점
                        .logoutSuccessUrl("/") // 로그아웃 성공시 "/" 주소로 이동
                .and()
                    .oauth2Login() // OAuth2 로그인 기능에 대한 여러 설정의 진입점
                        .userInfoEndpoint() // 로그인 성공 후 사용자 정보를 가져올 때의 설정들을 담당
                            .userService(customOAuth2UserService); // 소셜 로그인 성공 시 후속조치를 진행할 UserService 인터페이스의 구현체를 등록한다.
    }


}
