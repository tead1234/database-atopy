package com.example.analyzingatopyexternalFactors.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtopyController {
    // create , 일단 json
    @GetMapping("/")
    public String show(){
        return atopyService.getData();
    }
}
