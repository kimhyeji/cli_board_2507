DROP DATABASE IF EXISTS proj1;
CREATE DATABASE proj1;
USE proj1;

CREATE TABLE article (
                         id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                         title VARCHAR(100) NOT NULL,
                         content TEXT NOT NULL,
                         memberId INT UNSIGNED NOT NULL,
                         regDate DATETIME NOT NULL,
                         PRIMARY KEY (id)
);


CREATE TABLE `member` (
                          id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
                          userId VARCHAR(50) NOT NULL UNIQUE,
                          PASSWORD VARCHAR(100) NOT NULL,
                          regDate DATETIME NOT NULL
);

INSERT INTO `member`
SET userId = "member1",
PASSWORD = "1234",
regDate = NOW();

INSERT INTO `member`
SET userId = "member2",
PASSWORD = "1234",
regDate = NOW();

INSERT INTO `member`
SET userId = "member3",
PASSWORD = "1234",
regDate = NOW();

INSERT INTO article
SET title = "test",
content = "test",
memberId = 1,
regDate = NOW();

INSERT INTO article
SET title = "test2",
content = "test2",
memberId = 2,
regDate = NOW();