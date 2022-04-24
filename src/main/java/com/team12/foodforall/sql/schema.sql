-- Delete all tables firstly
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS users;

-- Create Project Table
CREATE TABLE projects
(
    id            BIGINT AUTO_INCREMENT NOT NULL ,
    title         VARCHAR(255)         ,
    content       VARCHAR(255)         ,
    img           VARCHAR(255)         ,
    progress      VARCHAR(255),
    position_name VARCHAR(255),
    lat           FLOAT,
    lng           FLOAT,
    charity       VARCHAR(255),
    price         VARCHAR(255),
    currency      VARCHAR(255),
    user_id       BIGINT,
    CONSTRAINT pk_projects PRIMARY KEY (id)
);

-- Create User Table
CREATE TABLE users
(
    id                 BIGINT AUTO_INCREMENT NOT NULL ,
    first_name         VARCHAR(20)           ,
    last_name          VARCHAR(20)           ,
    email              VARCHAR(45)           ,
    password           VARCHAR(64)           ,
    CONSTRAINT pk_users PRIMARY KEY (id)
);


ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

-- Link projects to users
ALTER TABLE projects
    ADD CONSTRAINT FK_PROJECTS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);
