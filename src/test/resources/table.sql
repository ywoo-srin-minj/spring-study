CREATE TABLE IF NOT EXISTS user_minj
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    user_id       VARCHAR(30) NOT NULL UNIQUE,
    user_name     VARCHAR(10) NOT NULL,
    user_password VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_srin
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    user_id       VARCHAR(30) NOT NULL UNIQUE,
    user_name     VARCHAR(10) NOT NULL,
    user_password VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_ywoo
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    user_id       VARCHAR(30) NOT NULL UNIQUE,
    user_name     VARCHAR(10) NOT NULL,
    user_password VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS post_ywoo
(
    post_id INT AUTO_INCREMENT PRIMARY KEY,
    post_title VARCHAR(30) NOT NULL,
    post_content TEXT NOT NULL,
    created_at DATE NOT NULL,
    last_modified_at DATE NOT NULL,
    user_id INT AUTO_INCREMENT,
    FOREIGN KEY (user_id)
    REFERENCES user_ywoo(id) ON DELETE CASCADE
    );