package com.project.socialclone.clone.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID", nullable = false, unique = true)
    private Long postId;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name="DESCRIPTION", nullable = false)
    private String description;

    @Column(name="IMAGE_ID")
    private Long imageId;

    @Column(name="DATE_CREATED", nullable = false)
    private LocalDate dateCreated;
}

/*
create table post(
	POST_ID serial PRIMARY KEY,
	CONSTRAINT fk_user
      FOREIGN KEY(user_id)
	  REFERENCES app_user(user_id),
	CONSTRAINT fk_image
      FOREIGN KEY(image_id)
	  REFERENCES image(image_id),
	DESCRIPTION VARCHAR(MAX) NOT NULL,
	DATE_CREATED TIMESTAMP NOT NULL
)
 */
