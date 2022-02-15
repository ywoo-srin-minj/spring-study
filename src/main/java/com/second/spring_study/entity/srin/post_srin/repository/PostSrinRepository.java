package com.second.spring_study.entity.srin.post_srin.repository;

import com.second.spring_study.entity.srin.post_srin.PostSrin;
import org.springframework.data.repository.CrudRepository;

public interface PostSrinRepository extends CrudRepository<PostSrin, Long> {

//save는 내장 메서드 이므로 따로 명시하지 않아도 된다.
//    @Override
//    PostSrin save(PostSrin postSrin);
}
