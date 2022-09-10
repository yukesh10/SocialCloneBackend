create table app_user(
     USER_ID serial PRIMARY KEY,
     FULL_NAME VARCHAR(200) NOT NULL,
     EMAIL VARCHAR(100) NOT NULL UNIQUE,
     PASSWORD VARCHAR(100) NOT NULL,
     ACTIVE_FLG BOOLEAN NOT NULL DEFAULT(TRUE),
     DATE_CREATED TIMESTAMP NOT NULL
)

CREATE TABLE image
(
    image_id serial PRIMARY KEY,
    image_url VARCHAR(256) NOT NULL,
    date_created TIMESTAMP NOT NULL
)

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