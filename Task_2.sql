CREATE SCHEMA `students` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

CREATE TABLE `students`.`list` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `patronymic` VARCHAR(45) NOT NULL,
  `class` VARCHAR(45) NOT NULL,
  `birthday` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

INSERT INTO `students`.`list` (`id`, `name`, `surname`, `patronymic`, `class`, `birthday`)
VALUES ('1', 'Ivan', 'Ivanov', 'Ivanovich', '11A', '2003-06-07');
INSERT INTO `students`.`list` (`id`, `name`, `surname`, `patronymic`, `class`, `birthday`)
VALUES ('2', 'Lev', 'Lvov', 'Lvovich', '11A', '2003-04-18');
INSERT INTO `students`.`list` (`id`, `name`, `surname`, `patronymic`, `class`, `birthday`)
VALUES ('3', 'Pyotr', 'Petrov', 'Petrovich', '11B', '2003-05-20');