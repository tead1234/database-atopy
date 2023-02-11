package com.example.analyzingatopyexternalFactors.repository;
// DTO로 전달하기로 결정

import com.example.analyzingatopyexternalFactors.entity.SymEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// 대체 이걸로 만들어진 테이블은 어디??
@Repository
public interface SymtomRepository extends JpaRepository<SymEntity, Long> {

    @Override
    List<SymEntity> findAll();
}
