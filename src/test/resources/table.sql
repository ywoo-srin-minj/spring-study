CREATE TABLE user_minj
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    user_id       VARCHAR(30) NOT NULL UNIQUE,
    user_name     VARCHAR(10) NOT NULL,
    user_password VARCHAR(30) NOT NULL
);

CREATE TABLE user_srin
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    user_id       VARCHAR(30) NOT NULL UNIQUE,
    user_name     VARCHAR(10) NOT NULL,
    user_password VARCHAR(30) NOT NULL
);

CREATE TABLE user_ywoo
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    user_id       VARCHAR(30) NOT NULL UNIQUE,
    user_name     VARCHAR(10) NOT NULL,
    user_password VARCHAR(30) NOT NULL
);

CREATE TABLE post_srin
(
    post_id INT AUTO_INCREMENT PRIMARY KEY,
    created_at DATE NOT NULL,
    last_modified_at DATE NOT NULL,
    post_title VARCHAR(30) NOT NULL,
    post_content TEXT NOT NULL,
    user_id INT AUTO_INCREMENT,
    FOREIGN KEY (user_id)
    REFERENCES user_srin(user_id) ON DELETE CASCADE
);