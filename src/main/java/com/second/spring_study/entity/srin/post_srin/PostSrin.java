package com.second.spring_study.entity.srin.post_srin;

import com.second.spring_study.dto.request.srin.PostUpdateRequestDto;
import com.second.spring_study.entity.BaseEntity;
import com.second.spring_study.entity.srin.user_srin.UserSrin;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostSrin extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false)
    private Long id;

    @Column(name = "post_title", nullable = false)
    private String postTitle;

    @Column(name = "post_content", nullable = false)
    private String postContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserSrin userSrin;

    //Builder를 통해 값 저장
    @Builder
    public PostSrin(String postTitle, String postContent, UserSrin userSrin){
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.userSrin = userSrin;
    }

    public PostSrin updatePost(PostUpdateRequestDto postUpdateRequestDto){
        this.postTitle = postUpdateRequestDto.getTitle();
        this.postContent = postUpdateRequestDto.getContent();
        return this;
    }

}
