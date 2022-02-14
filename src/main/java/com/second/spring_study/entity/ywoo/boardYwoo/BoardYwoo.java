package com.second.spring_study.entity.ywoo.boardYwoo;

import com.second.spring_study.entity.BaseEntity;
import com.second.spring_study.entity.ywoo.userYwoo.UserYwoo;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table
public class BoardYwoo extends BaseEntity {

    @Id
    @Column(name="board_id", nullable = false)
    private long id;

    @Column(name="board_title",nullable = false)
    private String boardTitle;

    @Column(name = "board_content",nullable = false)
    private String boardContent;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserYwoo userYwoo;

}
