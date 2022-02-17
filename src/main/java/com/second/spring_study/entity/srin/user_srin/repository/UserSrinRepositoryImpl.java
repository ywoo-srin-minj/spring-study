package com.second.spring_study.entity.srin.user_srin.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.second.spring_study.dto.request.srin.UserUpdateRequestDto;
import com.second.spring_study.dto.response.srin.PostInquiryResponseDto;
import com.second.spring_study.entity.srin.user_srin.UserSrin;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.second.spring_study.entity.srin.post_srin.QPostSrin.postSrin;
import static com.second.spring_study.entity.srin.user_srin.QUserSrin.userSrin;

public class UserSrinRepositoryImpl extends QuerydslRepositorySupport implements UserSrinRepositoryExtension{
    private final JPAQueryFactory queryFactory;

    public UserSrinRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(UserSrin.class);
        this.queryFactory = jpaQueryFactory;
    }

    @Override
    public void updateUser(long id, UserUpdateRequestDto userUpdateRequestDto) {
        queryFactory.update(userSrin)
                .set(userSrin.userPassword, userUpdateRequestDto.getUserPassword())
                .set(userSrin.userName, userUpdateRequestDto.getUserName())
                .where(userSrin.id.eq(id))
                .execute();
    }

    @Override
    public List<PostInquiryResponseDto> findAllPosts(Long userpk) {
        return queryFactory
                .select(Projections.fields(PostInquiryResponseDto.class,
                                postSrin.id,
                                postSrin.postTitle.as("title"),
                                postSrin.postContent.as("content"),
                                postSrin.userSrin.userName,
                                postSrin.createdAt))
                .from(postSrin)
                .where(userpkEq(userpk))
                .fetch();
    }

    private BooleanExpression userpkEq(Long userpk){
        return userpk != null ? userSrin.id.eq(userpk) : null;
    }
}
