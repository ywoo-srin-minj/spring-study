package com.second.spring_study.entity.ywoo.boardYwoo;

import com.second.spring_study.entity.BaseEntity;
import com.second.spring_study.entity.ywoo.userYwoo.UserYwoo;
import lombok.Getter;


import javax.persistence.*;

@Entity
@Getter
@Table
public class PostYwoo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id", nullable = false)
    private long id;

    @Column(name="post_title",nullable = false)
    private String postTitle;

    @Column(name = "post_content",nullable = false)
    private String postContent;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserYwoo userYwoo;

    public static PostYwoo createPost(UserYwoo userYwoo, String title, String content){
        PostYwoo postYwoo = new PostYwoo();
        postYwoo.userYwoo = userYwoo;
        postYwoo.postTitle = title;
        postYwoo.postContent = content;

        return postYwoo;
    }

    public PostYwoo  updatePost(String title, String content){
        this.postTitle=title;
        this.postContent=content;
        return this;
    }
}
