package com.second.spring_study.entity.srin;

import com.second.spring_study.entity.BaseEntity;
import com.second.spring_study.entity.srin.user_srin.UserSrin;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardSrin extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private long boardId;

    @Column(name = "board_title")
    private String boardTitle;

    private String boardContent;

    @ManyToOne
    @JoinColumn(name = "id")
    private UserSrin userSrin;

}