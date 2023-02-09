package com.example.analyzingatopyexternalFactors.controller;

import com.example.analyzingatopyexternalFactors.service.atopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

// 자동 직렬화
public class AtopyController {
    @Autowired
    atopyService atopyService;
    // create , 일단 json
    // controller 에서 Response DTO를 보내는게 나은가>>>>??
    @GetMapping("/")
    public String show(){
        return atopyService.getData();
    }
}
