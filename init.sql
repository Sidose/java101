CREATE SCHEMA IF NOT EXISTS `users_storage`;

USE `users_storage`;

CREATE TABLE IF NOT EXISTS users
(
    id    BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255),
    phone_number VARCHAR(255),
    password VARCHAR(255)
);

GRANT ALL PRIVILEGES ON users_storage.* TO 'user'@'%';
