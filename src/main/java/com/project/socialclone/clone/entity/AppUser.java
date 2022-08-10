package com.project.socialclone.clone.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "app_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "FULL_NAME", nullable = false, length = 200)
    private String name;

    @Column(name = "EMAIL", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "PASSWORD", nullable = false, length = 100)
    private String password;

    @Column(name="ACTIVE_FLG", nullable = false)
    private Boolean activeFlg;

    @Column(name="DATE_CREATED", nullable = false)
    private LocalDate dateCreated;
}

/*
create table app_user(
	USER_ID serial PRIMARY KEY,
	FULL_NAME VARCHAR(200) NOT NULL,
	EMAIL VARCHAR(100) NOT NULL UNIQUE,
	PASSWORD VARCHAR(100) NOT NULL,
	ACTIVE_FLG BOOLEAN NOT NULL DEFAULT(TRUE),
	DATE_CREATED TIMESTAMP NOT NULL
)
 */
