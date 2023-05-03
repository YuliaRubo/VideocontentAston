CREATE TABLE films
(
    id int(10) PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    year int(4),
    genre VARCHAR(20)

)
ENGINE = InnoDB;