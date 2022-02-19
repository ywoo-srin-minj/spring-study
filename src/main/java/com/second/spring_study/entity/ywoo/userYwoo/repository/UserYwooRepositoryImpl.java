package com.second.spring_study.entity.ywoo.userYwoo.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.second.spring_study.dto.request.ywoo.UserRequestUpdateDto;
import com.second.spring_study.dto.response.ywoo.PostFindResponseDto;
import com.second.spring_study.entity.ywoo.userYwoo.UserYwoo;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.second.spring_study.entity.ywoo.postYwoo.QPostYwoo.postYwoo;
import static com.second.spring_study.entity.ywoo.userYwoo.QUserYwoo.userYwoo;

public class UserYwooRepositoryImpl extends QuerydslRepositorySupport implements UserYwooRepositoryExtension {

    private final JPQLQueryFactory queryFactory;

    public UserYwooRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(UserYwoo.class);
        this.queryFactory=jpaQueryFactory;
    }

    @Override
    public void updateUser(long id, UserRequestUpdateDto userRequestUpdateDto) {
        queryFactory.update(userYwoo) //update문
                .set(userYwoo.userPassword, userRequestUpdateDto.getUserPassword()) //객체에 해당되는 값을 넣어줌
                .set(userYwoo.userName, userRequestUpdateDto.getUserName())
                .where(userYwoo.id.eq(id)) //들어온 id와 객체의 id가 같을 경우
                .execute();
    }

    @Override
    public List<PostFindResponseDto> findAllPosts(Long userpk){
        return queryFactory.select(Projections.fields(PostFindResponseDto.class,
                        postYwoo.id,
                        postYwoo.postTitle.as("title"),
                        postYwoo.postContent.as("content"),
                        postYwoo.userYwoo.userName,
                        postYwoo.createdAt))
                .from(postYwoo)
                .where(userpkEquals(userpk))
                .orderBy(postYwoo.createdAt.desc())
                .fetch();
    }

    private BooleanExpression userpkEquals(Long userpk) {
        if(userpk != null) return userYwoo.id.eq(userpk);
        else return null;
    }
}
