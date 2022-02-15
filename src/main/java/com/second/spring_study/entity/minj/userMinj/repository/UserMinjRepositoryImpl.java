package com.second.spring_study.entity.minj.userMinj.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.second.spring_study.dto.request.minj.UpdateUserRequestDto;

import static com.second.spring_study.entity.minj.postMinj.QPostMinj.postMinj;
import static com.second.spring_study.entity.minj.userMinj.QUserMinj.userMinj;

import com.second.spring_study.dto.response.minj.PostResponseDto;
import com.second.spring_study.entity.minj.userMinj.UserMinj;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;


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

    @Override
    public List<PostResponseDto> getPosts(Long userPk) {
        return queryFactory
                .select(Projections.fields(
                        PostResponseDto.class,
                        postMinj.postTitle.as("title"),
                        postMinj.postContent.as("content"),
                        postMinj.userMinj.userName,
                        postMinj.createdAt))
                .from(postMinj)
                .where(userPkEq(userPk))
                .orderBy(postMinj.createdAt.desc())
                .fetch();
    }

    private BooleanExpression userPkEq(Long userPk) {
        return userPk != null ? userMinj.id.eq(userPk) : null;
    }
}
