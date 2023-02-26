package com.example.analyzingatopyexternalFactors.entity;

import com.example.analyzingatopyexternalFactors.dto.AtopyRequestDTO;
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
import javax.validation.constraints.NotNull;
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
    @NotNull
    private Date date;
    @NotNull
    private Integer skinState;
    private String morning;
    private String lunch;

    private String dinner;
    @NotNull
    private Integer sleepTime;

    private String exercise;
    // id 없이 구현할 수 있는 함수
    public static SymEntity of(

            Date date,
            Integer skinState,
            String morning,
            String lunch,
            String dinner,
            Integer sleepTime,
            String exercise
    ){
        return new SymEntity(
                null,
                date,
                skinState,
                morning,
                lunch,
                dinner,
                sleepTime,
                exercise

        );
    }
    // id를 넣어서 구현해야 함수
    public static SymEntity usingId(
            Long id,
            Date date,
            Integer skinState,
            String morning,
            String lunch,
            String dinner,
            Integer sleepTime,
            String exercise
    ){
        return new SymEntity(
                id,
                date,
                skinState,
                morning,
                lunch,
                dinner,
                sleepTime,
                exercise

        );
    }

    // 위 정보들을 한번에 담을 리스트1234



}
