package com.example.analyzingatopyexternalFactors.service;

import com.example.analyzingatopyexternalFactors.dto.AtopyRequestDTO;
import com.example.analyzingatopyexternalFactors.dto.AtopyUpdateDTO;
import com.example.analyzingatopyexternalFactors.dto.SymtomResponseDTO;
import com.example.analyzingatopyexternalFactors.entity.QSymEntity;
import com.example.analyzingatopyexternalFactors.entity.SymEntity;
import com.example.analyzingatopyexternalFactors.repository.SymtomQueryRepository;
import com.example.analyzingatopyexternalFactors.repository.SymtomRepository;
import com.querydsl.core.Tuple;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.http.HttpClient;
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
    @Autowired
    SymtomQueryRepository symtomQueryRepository;
    //create
    @Transactional
    public String create(AtopyRequestDTO dto){
        // dto를 여기서 처리해서 보내는게 맞지 않을까??
        // dto > entity
        // dto를 entity로 변환하는 함수를 작성하는게 낫지 않을까???

        // 저 변환함수를 entity에 만들면 각 dto에서 얻어온 값을 바탕으로 변환할 수있음
        // 앞으로 dto가 많아질테니 이게 더 나은 방법일듯하다.
        SymEntity sym = SymEntity.of(
                dto.getDate(),
                dto.getSkinState(),
                dto.getMorning(),
                dto.getLunch(),
                dto.getDinner(),
                dto.getSleepTime(),
                dto.getExercise()
        );
        // 생성된 entity를 db에 저장
        symtomRepository.saveAndFlush(sym);
        return "";
    }

    // read
    @Transactional
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
                            symEntity.getMorning(),
                            symEntity.getLunch(),
                            symEntity.getDinner(),
                            symEntity.getSleepTime(),
                            symEntity.getExercise()
            )
            )
            );
        });
        return new SymtomResponseDTO().from(200, newList);
    }
    // readByID
    public SymtomResponseDTO getDataById(Long id){
        SymEntity sym =  symtomRepository.findById(id).orElse(null);
        return new SymtomResponseDTO().from(
                200
                ,
                Arrays.asList(


                    sym.getId(),
                    sym.getDate(),
                    sym.getSkinState(),
                        sym.getMorning(),
                sym.getLunch(),
        sym.getDinner(),
        sym.getSleepTime(),
        sym.getExercise(),
                    sym.getSleepTime(),
                    sym.getExercise()
                )
        );
    }

    // delete 서비스
    @Transactional
    public String deleteByID(Long id){
        symtomRepository.deleteById(id);
        return "complete";
    }
    @Transactional
    public void deleteAll(){
        symtomRepository.deleteAll();
    }


    @Transactional
    public void updateById(AtopyUpdateDTO dto) {
        //
        SymEntity a = symtomRepository.findById(dto.getId()).orElse(null);
        log.info(a.toString());
        if(a != null){
            // id 가 일치하면 알아서 update됨
            // a에 직접 setter를 달고 건드리면 정합성이 깨질 우려가 있음
            // id를 넣고 만들수 있는 함수를 따로 구현하는게 더 안전할 거 같은데
            SymEntity sym = SymEntity.usingId(
                    dto.getId(),
                    dto.getDate(),
                    dto.getSkinState(),
                    dto.getMorning(),
                    dto.getLunch(),
                    dto.getDinner(),
                    dto.getSleepTime(),
                    dto.getExercise()
            );
            log.info(sym.getId().toString());
            symtomRepository.saveAndFlush(sym);
        }else{

        }
    }

    public SymtomResponseDTO getDataByCategory(String category) {
            List<Tuple> a = symtomQueryRepository.findMostFactors(category);
            log.info(a.toString());
            List<Object> b = new ArrayList<>();
            a.forEach(tuple -> {
                        log.info(tuple.toString());
                        b.add(tuple.get(0, Integer.class));

            });
            return new SymtomResponseDTO().from(200,b);

        }


}
