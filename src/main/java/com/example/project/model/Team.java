package com.example.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "tbl_member")
public class Team {

    //ㅇㅁㄴㅇㄴㅁ
    @Column(name = "TEAM_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;

    @Builder.Default //builder패턴 사용 시 해당 변수 사용 안 할 경우 new ArrayList로 자동 할당 안 쓰면 null로 됨
    @OneToMany(mappedBy = "team") // 주인이 아닌 쪽에 mappedBy 선언
    private List<Member> members = new ArrayList<>();

}
