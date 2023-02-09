package com.example.analyzingatopyexternalFactors.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtopyController {
    // create , 일단 json
    // controller 에서 Response DTO를 보내는게 나은가>>>>??
    @GetMapping("/")
    public String show(){
        return atopyService.getData();
    }
}
