package com.example.analyzingatopyexternalFactors.entity;

import lombok.Getter;
import org.springframework.cglib.core.GeneratorStrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
public class SymtomEntity {
    // DB안에 들어갈 entity 속성
    // id, 날짜, 피부상태, 먹었던 것들, 수면시간, 운동 유무
    @Id
    @GeneratedValue(GeneratorStrategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private Integer skinState;
    private String food;

    private Integer sleepTime;

    private String exercise;
}
