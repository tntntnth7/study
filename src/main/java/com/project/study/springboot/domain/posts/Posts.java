package com.project.study.springboot.domain.posts;

import com.project.study.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}

/* 설명
* *******************************
* @Entity
* 테이블과 링크될 클래스임을 나타낸다.
* 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭한다.
* *******************************
* @ID
* 해당 테이블의 PK 필드를 나타낸다.
* *******************************
* @GeneratedValue
* PK의 생성 규칙을 나타낸다.
* 스프링부터 2.0에서는 GeneratedType.IDENTITY 옵션을 추가해만 increment가 된다.
* *******************************
* @Column
* 해당 테이블의 컬럼을 나타낸다. 굳이 선언하지 않아도 해당 클래스의 필드는 모두 컬럼이 된다.
* 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다.
* *******************************
* @NoArgsConstructor
* 기본생성자 자동추가
* *******************************
* @Getter
* 클래스 내 모든 필드의 Getter 메소드 자동생성
* *******************************
* @Builder
* 해당 클래스의 빌더 패턴 클래스를 생성
* 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
* *******************************
*
* */