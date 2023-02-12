package com.example.analyzingatopyexternalFactors.controller;

import com.example.analyzingatopyexternalFactors.dto.AtopyRequestDTO;
import com.example.analyzingatopyexternalFactors.service.atopyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
// 자동 직렬화
// responseDTO형태를 json으로 ㅂ ㅕㄴ경
public class AtopyController {
    @Autowired
    atopyService atopyService;
    // create , 일단 json
    // controller 에서 Response DTO를 보내는게 나은가>>>>??
    @GetMapping("/read")
    public String show(){
        log.info("show함수 실행");
        return atopyService.getData().toString();
    }
    /// 프론트엔드단 생성작업 생성이 된다면 다시 게시글 페이지로 넘어감
    //dto로 받은걸로 처리해야됨
    @PostMapping("/create")
    public String save(@RequestBody AtopyRequestDTO dto){
        atopyService.create(dto);
        return "redirect/";
    }
    // delete id 별로
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        atopyService.deleteByID(id);
        return "redirect:/";
    }
    // delete ALl


}
