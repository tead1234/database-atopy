package com.example.analyzingatopyexternalFactors.repository;

import com.example.analyzingatopyexternalFactors.entity.SymEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

// 메소드 구현 레포
// JPA와 위 인터페이스를 상속받는
@Repository
@AllArgsConstructor
@RequiredArgsConstructor
public class SymtomQueryRepository {
    private final JPAQueryFactory queryFactory;
    public List<SymEntity> findAll() {
        return queryFactory
                .selectFrom(symentity)
                .fetch();
    }


    // 피부상태가 4 또는 5를 기록하는 날의 영향을 주는 음식, 식단, 운동 상태
    public List<Object> findMostFactors(String category){
        return queryFactory.selectFrom(symentity)
                .groupBy(symentity.skinState)
                .fetch();
    }
}
