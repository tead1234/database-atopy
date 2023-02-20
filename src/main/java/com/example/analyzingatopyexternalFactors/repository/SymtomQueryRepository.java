package com.example.analyzingatopyexternalFactors.repository;

import com.example.analyzingatopyexternalFactors.entity.QSymEntity;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;


// 메소드 구현 레포
// JPA와 위 인터페이스를 상속받는
@Repository
@AllArgsConstructor
public class SymtomQueryRepository {
    private final JPAQueryFactory queryFactory;
    Expression<?>[] expressions;


    // 피부상태가 4 또는 5를 기록하는 날의 영향을 주는 음식, 식단, 운동 상태
    public List<Tuple> findMostFactors(String category){
        QSymEntity qSymEntity =  QSymEntity.symEntity;

        if (category != null && category.equals("sleepTime")) {
             expressions =  new Expression<?>[]{qSymEntity.sleepTime, qSymEntity.sleepTime.count()};
            return queryFactory.select(expressions)
                    .from(qSymEntity)
                    .where(qSymEntity.skinState.eq(5).or(qSymEntity.skinState.eq(4)))
                    // groupby를 동적할당 할수 이쓴ㄴ 방법이 없네
                    .groupBy(qSymEntity.sleepTime)
                    .orderBy(qSymEntity.sleepTime.count().desc())
                    .fetch();
        }
        if (category != null && category.equals("exercise")) {
            expressions =  new Expression<?>[]{qSymEntity.exercise};
            return queryFactory.select(expressions)
                    .from(qSymEntity)
                    .where(qSymEntity.skinState.eq(5).or(qSymEntity.skinState.eq(4)))
                    // groupby를 동적할당 할수 이쓴ㄴ 방법이 없네
                    .groupBy(qSymEntity.exercise)
                    .orderBy(qSymEntity.exercise.count().desc())
                    .fetch();
        }
        if (category != null && category.equals("food")) {
            expressions =  new Expression<?>[]{qSymEntity.food};
            return queryFactory.select(expressions)
                    .from(qSymEntity)
                    .where(qSymEntity.skinState.eq(5).or(qSymEntity.skinState.eq(4)))
                    // groupby를 동적할당 할수 이쓴ㄴ 방법이 없네
                    .groupBy(qSymEntity.food)
                    .orderBy(qSymEntity.food.count().desc())
                    .fetch();
        }
        // tuple로 나오는데 이걸 dto로 바꿔야 됨
        return Arrays.asList();
    }
}
