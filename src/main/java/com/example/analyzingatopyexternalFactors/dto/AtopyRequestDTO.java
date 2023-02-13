package com.example.analyzingatopyexternalFactors.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtopyRequestDTO {
    // id는 알아서 생성될것
    @JsonProperty("date")
    private Date date;
    @JsonProperty("skinState")

    private Integer skinState;
    @JsonProperty("food")

    private String food;
    @JsonProperty("sleepTime")

    private Integer sleepTime;
    @JsonProperty("exercise")

    private String exercise;


}
