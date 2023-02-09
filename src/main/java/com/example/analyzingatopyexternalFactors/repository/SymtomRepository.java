package com.example.analyzingatopyexternalFactors.repository;
// DTO로 전달하기로 결정

import com.example.analyzingatopyexternalFactors.entity.SymtomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SymtomRepository implements JpaRepository<SymtomEntity, Long> {

    List<SymtomEntity> findAllByPostId(Long id);
}
