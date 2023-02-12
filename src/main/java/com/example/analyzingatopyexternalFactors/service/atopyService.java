package com.example.analyzingatopyexternalFactors.service;

import com.example.analyzingatopyexternalFactors.dto.AtopyRequestDTO;
import com.example.analyzingatopyexternalFactors.dto.SymtomResponseDTO;
import com.example.analyzingatopyexternalFactors.entity.SymEntity;
import com.example.analyzingatopyexternalFactors.repository.SymtomRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class atopyService {
    // 요청이 들어오면 ResponseDTo로 받은걸 전달
    // getData로 List로 받아서 toString으로 전달
    // >>> List를 ResponseDTO에 담아서 보내자??
    @Autowired
    SymtomRepository symtomRepository;
    //create
    public String create(AtopyRequestDTO dto){
        // dto를 여기서 처리해서 보내는게 맞지 않을까??
        // dto > entity
        // dto를 entity로 변환하는 함수를 작성하는게 낫지 않을까???

        // 저 변환함수를 entity에 만들면 각 dto에서 얻어온 값을 바탕으로 변환할 수있음
        // 앞으로 dto가 많아질테니 이게 더 나은 방법일듯하다.
        SymEntity sym = SymEntity.of(
                dto.getDate(),
                dto.getSkinState(),
                dto.getFood(),
                dto.getSleepTime(),
                dto.getExercise()
        );
        // 생성된 entity를 db에 저장
        symtomRepository.saveAndFlush(sym);
        return "";
    }

    // read
    public SymtomResponseDTO getData(){
        // repository 자리
        // symToms = data
        log.info("getData");

        List<SymEntity> symToms = symtomRepository.findAll();
        ArrayList<Object> newList = new ArrayList<>();
        symToms.forEach(symEntity -> {
            newList.add(new ArrayList<Object>(Arrays.asList(symEntity.getId(),
                    symEntity.getDate(),
                    symEntity.getSkinState(),
                    symEntity.getFood(),
                    symEntity.getSleepTime(),
                    symEntity.getExercise()
            )
            )
            );
        });
        return new SymtomResponseDTO().from(200, newList);
    }

    // delete 서비스
    public String deleteByID(Long id){
        symtomRepository.deleteById(id);
        return "complete";
    }


}
