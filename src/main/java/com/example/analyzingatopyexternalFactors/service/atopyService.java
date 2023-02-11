package com.example.analyzingatopyexternalFactors.service;

import com.example.analyzingatopyexternalFactors.dto.SymtomResponseDTO;
import com.example.analyzingatopyexternalFactors.entity.SymEntity;
import com.example.analyzingatopyexternalFactors.repository.SymtomRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import org.hibernate.annotations.Any;
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
