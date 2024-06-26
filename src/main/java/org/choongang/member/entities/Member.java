package org.choongang.member.entities;

import lombok.Builder;
import lombok.Data;
import org.choongang.member.constants.UserType;

import java.time.LocalDateTime;

@Data
@Builder
public class Member {
    private long userNo;
    private String email;
    private String password;
    private String userName;
    private UserType userType = UserType.USER;
    private long myPokemonSeq;  // 마이 포켓몬 seq 추가
    private LocalDateTime regDt;
    private LocalDateTime modDt;
}