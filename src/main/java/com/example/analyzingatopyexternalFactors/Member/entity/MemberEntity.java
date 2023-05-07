package com.example.analyzingatopyexternalFactors.Member.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "member_entity")
// member > id, email, password
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long Id;

    @NotNull
    private String email;
    @NotNull
    private  Int password;
}