package com.second.spring_study.entity.srin.user_srin.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.second.spring_study.dto.request.srin.UserUpdateRequestDto;
import com.second.spring_study.entity.srin.user_srin.UserSrin;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
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
}
