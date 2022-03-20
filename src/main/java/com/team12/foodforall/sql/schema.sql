CREATE TABLE users
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    first_name         VARCHAR(20)           NOT NULL,
    last_name          VARCHAR(20)           NOT NULL,
    email              VARCHAR(45)           NOT NULL,
    password           VARCHAR(64)           NOT NULL,
    confirmed_password VARCHAR(64)           NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);