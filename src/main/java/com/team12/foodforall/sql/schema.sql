DROP TABLE IF EXISTS users;
CREATE TABLE users (
                         id   INTEGER      NOT NULL AUTO_INCREMENT,
                         name VARCHAR(128) NOT NULL, PRIMARY KEY (id),
                         email VARCHAR(128) NOT NULL,
                         password VARCHAR(128) NOT NULL
                  );
