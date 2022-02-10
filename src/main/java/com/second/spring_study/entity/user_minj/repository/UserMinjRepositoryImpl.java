package com.second.spring_study.entity.user_minj.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.second.spring_study.dto.request.minj.UpdateUserRequestDto;
import static com.second.spring_study.entity.user_minj.QUserMinj.userMinj;
import com.second.spring_study.entity.user_minj.UserMinj;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;


public class UserMinjRepositoryImpl extends QuerydslRepositorySupport implements UserMinjRepositoryExtension {

    private final JPAQueryFactory queryFactory;

    public UserMinjRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(UserMinj.class);
        this.queryFactory = jpaQueryFactory;
    }

    @Override
    public void updateUser(long id, UpdateUserRequestDto updateUserRequestDto) {
        queryFactory.update(userMinj)
                .set(userMinj.userPassword, updateUserRequestDto.getUserPassword())
                .set(userMinj.userName, updateUserRequestDto.getUserName())
                .where(userMinj.id.eq(id))
                .execute();
    }
}
