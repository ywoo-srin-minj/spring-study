CREATE TABLE user_srin
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    user_id       VARCHAR(30) NOT NULL UNIQUE,
    user_name     VARCHAR(10) NOT NULL,
    user_password VARCHAR(30) NOT NULL
);