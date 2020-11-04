--  Many To One
--  название базы данных - one_to_many_lesson
CREATE DATABASE one_to_many_lesson ENCODING 'UTF-8';
-- название таблицы в конце - cars
CREATE TABLE IF NOT EXISTS cars (
--  поля в базе данных
  id   SERIAL PRIMARY KEY,
  cost INTEGER,
  mark VARCHAR(25)
);

-- строка наполнения таблицы данными
INSERT INTO cars (mark, cost) VALUES ('ford', 100000);
INSERT INTO cars (mark, cost) VALUES ('ford', 10984673);
INSERT INTO cars (mark, cost) VALUES ('mazda', 10984673);


-- таблица - engines вставлена в таблицу - cars
-- название таблицы в конце - engines
CREATE TABLE IF NOT EXISTS engines (
  id       SERIAL PRIMARY KEY,
  name     VARCHAR(25) NOT NULL,
  power    INTEGER     NOT NULL,
  car_mark VARCHAR(25)
);

-- строка наполнения таблицы данными
INSERT INTO engines (name, power, car_mark) VALUES ('super-engine', 10000, 'ford');



/*

--Тоже самое но для MySQL
CREATE SCHEMA `one_to_many_lesson` ;

CREATE TABLE `one_to_many_lesson`.`cars` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cost` INT NOT NULL,
  `mark` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`id`));


INSERT INTO `one_to_many_lesson`.`cars` (`id`, `cost`, `mark`) VALUES ('1', '100000', 'ford');
INSERT INTO `one_to_many_lesson`.`cars` (`id`, `cost`, `mark`) VALUES ('2', '10984673', 'ford');
INSERT INTO `one_to_many_lesson`.`cars` (`id`, `cost`, `mark`) VALUES ('3', '10984673', 'mazda');


CREATE TABLE `one_to_many_lesson`.`engines` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(25) NOT NULL,
  `power` INT NOT NULL,
  `car_mark` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`id`));


INSERT INTO `one_to_many_lesson`.`engines` (`id`, `name`, `power`, `car_mark`) VALUES ('1', 'super-engine', '10000', 'ford');

*/