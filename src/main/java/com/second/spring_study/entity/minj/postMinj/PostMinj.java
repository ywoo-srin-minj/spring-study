package com.second.spring_study.entity.minj.postMinj;

import com.second.spring_study.dto.request.minj.PostRequestDto;
import com.second.spring_study.entity.BaseEntity;
import com.second.spring_study.entity.minj.userMinj.UserMinj;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostMinj extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false)
    private Long id;

    @Column(name = "post_title", nullable = false)
    private String postTitle;

    @Column(name = "post_content", nullable = false)
    private String postContent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserMinj userMinj;

    public static PostMinj createPost(PostRequestDto postRequestDto, UserMinj userMinj) {
        PostMinj postMinj = new PostMinj();
        postMinj.postTitle = postRequestDto.getTitle();
        postMinj.postContent = postRequestDto.getContent();
        postMinj.userMinj = userMinj;
        return postMinj;
    }

    public PostMinj updatePost(PostRequestDto postRequestDto){
        this.postTitle = postRequestDto.getTitle();
        this.postContent = postRequestDto.getContent();
        return this;
    }
}
