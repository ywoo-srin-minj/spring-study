package com.second.spring_study.entity.srin.post_srin.repository;

import com.second.spring_study.entity.srin.post_srin.PostSrin;
import org.springframework.data.repository.CrudRepository;

public interface PostSrinRepository extends CrudRepository<PostSrin, Long> {
    @Override
    PostSrin save(PostSrin postSrin);
}
