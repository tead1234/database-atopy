package com.example.analyzingatopyexternalFactors.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtopyRequestDTO {
    // id는 알아서 생성될것
    private Date date;

    private Integer skinState;
    private String food;

    private Integer sleepTime;

    private String exercise;


}
