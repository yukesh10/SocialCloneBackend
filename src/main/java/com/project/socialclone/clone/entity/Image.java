package com.project.socialclone.clone.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "image")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IMAGE_ID", nullable = false, unique = true)
    private Long postId;

    @Column(name = "IMAGE_URL", nullable = false, length = 256)
    private String imageUrl;

    @Column(name = "DATE_CREATED", nullable = false)
    private Timestamp dateCreated;
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
