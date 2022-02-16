package com.second.spring_study.entity.srin.user_srin.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.second.spring_study.dto.request.srin.UserUpdateRequestDto;
import com.second.spring_study.dto.response.srin.PostInquiryResponseDto;
import com.second.spring_study.entity.srin.post_srin.PostSrin;
import com.second.spring_study.entity.srin.post_srin.QPostSrin;
import com.second.spring_study.entity.srin.user_srin.UserSrin;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.stream.Collectors;

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
        //querydsl을 통해 매개변수로 받은 userpk의 post만 findpost변수로 받음
        List<PostSrin> findpost = queryFactory.selectFrom(QPostSrin.postSrin)
                .where(QPostSrin.postSrin.userSrin.id.eq(userpk))
                .fetch();

        //findpost는 PostSrin 형식의 List이므로 이를 DTO의 형태로 변환후 반환
        return (List<PostInquiryResponseDto>) findpost.stream()
                .map(postSrin -> new PostInquiryResponseDto(postSrin.getPostId(), postSrin.getPostTitle(), postSrin.getPostContent(), postSrin.getUserSrin().getUserName(), postSrin.getCreatedAt()))
                .collect(Collectors.toList());
    }

}
