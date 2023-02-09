package com.example.analyzingatopyexternalFactors.service;

import com.example.analyzingatopyexternalFactors.entity.SymEntity;
import com.example.analyzingatopyexternalFactors.repository.SymtomRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class atopyService {
    // 요청이 들어오면 ResponseDTo로 받은걸 전달
    // getData로 List로 받아서 toString으로 전달
    @Autowired
    SymtomRepository symtomRepository;
    public String getData(){
        // repository 자리
        List<SymEntity> symToms = symtomRepository.findAll();
        return symToms.toString();
    }
}
