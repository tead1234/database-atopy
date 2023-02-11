package com.example.analyzingatopyexternalFactors.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Any;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SymEntity {
    // DB안에 들어갈 entity 속성
    // id, 날짜, 피부상태, 먹었던 것들, 수면시간, 운동 유무
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private Integer skinState;
    private String food;

    private Integer sleepTime;

    private String exercise;

    // 위 정보들을 한번에 담을 리스트1234



}
