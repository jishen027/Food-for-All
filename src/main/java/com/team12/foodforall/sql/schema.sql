CREATE TABLE users
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255),
    email    VARCHAR(255),
    password VARCHAR(255),
    CONSTRAINT pk_users PRIMARY KEY (id)
);