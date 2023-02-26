package com.example.analyzingatopyexternalFactors.controller;

import com.example.analyzingatopyexternalFactors.dto.AtopyRequestDTO;
import com.example.analyzingatopyexternalFactors.dto.AtopyUpdateDTO;
import com.example.analyzingatopyexternalFactors.dto.SymtomResponseDTO;
import com.example.analyzingatopyexternalFactors.service.atopyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name= "post", description = "증상 및 외부 변인 등록")
@RestController
@Slf4j
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = SymtomResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "404", description = "NOT FOUND"),
        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
})
// 자동 직렬화
// responseDTO형태를 json으로 ㅂ ㅕㄴ경
public class AtopyController {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    atopyService atopyService;
    // create , 일단 json
    // controller 에서 Response DTO를 보내는게 나은가>>>>??
    @GetMapping("/read")
    public String show() throws JsonProcessingException {
        log.info("show함수 실행");
        /// read할때 json형태로 받을 수 있어야 하지 않을까??
        return objectMapper.writeValueAsString(atopyService.getData());
    }
    @GetMapping("/read/spec")
    public String showById(@RequestParam Long id) throws JsonProcessingException {
        // 여기서 id 값을 보내는 프론트 엔드가 필요함
        return objectMapper.writeValueAsString(atopyService.getDataById(id));
    }
    @GetMapping("/read/most")
    public String showByCategory(@RequestParam String category) throws JsonProcessingException {
        return objectMapper.writeValueAsString(atopyService.getDataByCategory(category));
    }

    // read >> id별로 읽어오기 상세페이지
    // 이 두개의 함수를 하나로 묶을 수 있지 않을까???

    // update
    // read/spec에서 받은 id값을 재활용하는 방법밖에 없을거같다.
    // 아니면 update만을 위한 dto를 따로 만들던지
    // 따로 만드는 방법이 더 유리할 거같다.
    // 주소창에 굳이 id를 노출할 필요가 없음
    // dto로 받아올 거니깐
    @PostMapping("/update")
    public String update(@RequestBody AtopyUpdateDTO dto){
        atopyService.updateById(dto);
        return "";
    }
    // jpql로 피부상태를 악화 시켰던 요인들 중 빈도수가 가장 높았던 요인들을 보여주자
    /// 프론트엔드단 생성작업 생성이 된다면 다시 게시글 페이지로 넘어감
    //dto로 받은걸로 처리해야됨
    @PostMapping("/create")
    public String save(@RequestBody AtopyRequestDTO dto){
        atopyService.create(dto);
        return "redirect:read";
    }
    // delete id 별로
    @GetMapping("/delete")
    public String delete(@RequestParam Long id){
        atopyService.deleteByID(id);
        return "redirect:read";
    }
    @GetMapping("/deleteAll")
    public String deleteAll(){
        atopyService.deleteAll();
        return "";
    }
    // delete ALl


}
