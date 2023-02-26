package com.example.analyzingatopyexternalFactors.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class AtopyUpdateDTO {
        @JsonProperty("id")
        private Long id;
        // id는 알아서 생성될것
        @JsonProperty("date")
        private Date date;
        @JsonProperty("skinState")

        private Integer skinState;
        @JsonProperty("morning")

        private String morning;
        @JsonProperty("lunch")
        private String lunch;

        @JsonProperty("dinner")
        private String dinner;
        @JsonProperty("sleepTime")

        private Integer sleepTime;
        @JsonProperty("exercise")

        private String exercise;


    }

