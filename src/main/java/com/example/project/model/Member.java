package com.example.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    /*
     * oneToOne, manyToOne은 eager가 기본 값이기때문에 lazy로 변경 추천
     * eager: 연관된 데이터들을 한꺼번에 로딩 -> 예측이 어렵고 어떤 게 실행된지 확인 어려움
     * lazy(지연): 필요할 때 데이터를 로딩한다.
     */
    @ManyToOne(fetch = FetchType.LAZY) // member가 다 Team이 원, 다대일
    @JoinColumn(name = "TEAM_ID") // 컬럼명 Team의 ID
    private Team team;

    // 연관관계 편의 메서드
    public void setTeam(Team team) {
        if (this.team != null) { // 기존에 이미 팀이 존재한다면
            this.team.getMembers().remove(this); // 관계를 끊는다.
        }
        this.team = team;
        team.getMembers().add(this);
    }

}
