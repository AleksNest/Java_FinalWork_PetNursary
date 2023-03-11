# Создание БД:

CREATE DATABASE humanFriends;
USE humanFriends;


# Создание таблиц с иеархией из диаграммы БД:

CREATE TABLE humanFriend
(
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    birthday DATE,
    command VARCHAR(60),
    typeOfAnimal VARCHAR (30)
);

CREATE TABLE pet
(
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    birthday DATE,
    command VARCHAR(60),
    species VARCHAR (30)
);

CREATE TABLE packAnimal
(
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    birthday DATE,
    command VARCHAR(60),
    loadCapacity INT,
    species VARCHAR (30)
);

CREATE TABLE cat
(
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    birthday DATE,
    command VARCHAR(60),
    species VARCHAR (30)
);

CREATE TABLE dog
(
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    birthday DATE,
    command VARCHAR(60),
    species VARCHAR (30),
    pedigree VARCHAR (50)
);

CREATE TABLE hamster
(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    birthday DATE,
    command VARCHAR(60),
    species VARCHAR (30)
);

CREATE TABLE horse
(
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    birthday DATE,
    command VARCHAR(60),
    loadCapacity INT,
    species VARCHAR (30)
);

CREATE TABLE camel
(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    birthday DATE,
    command VARCHAR(60),
    loadCapacity INT,
    numberOfHumps INT
);

CREATE TABLE donkey
(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    birthday DATE,
    command VARCHAR(60),
    loadCapacity INT,
    species VARCHAR (30)
);


# заполнение таблиц cat, dog, hamster,horse, camel, donkey

INSERT INTO cat (name, birthday, command, species)
VALUES
    ("Дымок", "2020-03-15", "ко мне","Мейн-кун"),
    ("Мартин", "2021-10-01", "лежать","Манчкин"),
    ("Лео", "2018-03-10", "сидеть","Бурма"),
    ("Саманта", "2023-01-08", "лежать","Шартрез"),
    ("Саймон", "2022-02-11", "ко мне","Сфинкс");

SELECT * FROM cat;

INSERT INTO dog (name, birthday, command, species, pedigree)
VALUES
    ("Зевс", "2019-04-15", "дай лапу","Мопс", "Свидетельство E8L385 от 03.05.2019"),
    ("Мухтар", "2022-12-01", "охранять","Овчарка", "без родословной"),
    ("Чара", "2018-05-10", "сидеть","Доберман", "Свидетельство  697311У от 06.11.2018 "),
    ("Люк", "2023-02-08", "апорт","Алабай", "без родословной "),
    ("Фокси", "2022-10-11", "служить","Бигль", "без родословной "),
    ("Марти", "2022-10-11", "искать","Такса", "без родословной ");

SELECT * FROM dog;

INSERT INTO hamster (name, birthday, command, species)
VALUES
   ("Хомка", "2020-04-15", "кушать","Сирийский"),
    ("Бублик", "2021-11-01", "ко мне","Китайскийн"),
    ("Фунтик", "2018-05-10", "бежать","Кэмпбелла"),
    ("Тимошка", "2023-02-07", "лежать","Китайский");

SELECT * FROM hamster;

INSERT INTO horse (name, birthday, command, loadCapacity, species)
VALUES
    ("Ягодка", "2020-05-16", "ап", 200,  "тяжеловоз"),
    ("Ласточка", "2021-12-01", "назад", 120, "Першерон"),
    ("Осман", "2018-07-10", "на место", 130, "Рысак"),
    ("Пепел", "2023-01-07", "поехали", 200, "Шайр");

SELECT * FROM horse;

INSERT INTO camel (name, birthday, command, loadCapacity, numberOfHumps)
VALUES
    ("Джамаль", "2020-06-15", "вези", 200,  1),
    ("Кунанша", "2021-12-10", "стой", 220, 2),
    ("Джамаль", "2018-07-07", "вези", 220, 2);

SELECT * FROM camel;

INSERT INTO donkey (name, birthday, command, loadCapacity, species)
VALUES
   ("Алдар", "2020-01-16", "поехали", 70,  "Абиссинский"),
    ("Гопал", "2021-10-01", "стой", 90, "Алжирский"),
    ("Садко", "2018-09-05", "стой", 90, "Анатолийский"),
    ("Оссиан", "2022-12-07", "поехали", 130, "Мамонт");

SELECT * FROM donkey;


# удаление данных всех записей из таблицы camel

DELETE FROM camel;
SELECT * FROM camel;


# Обьединение таблиц horse и donkey в одну новую таблицу packAnimalNew:

CREATE TABLE packAnimalNew
(
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    command VARCHAR(60),
    birthday DATE,
    species VARCHAR (30),
    loadCapacity INT,
    typeOfAnimal VARCHAR (30)
);

INSERT into packAnimalNew (name, birthday, command, species, loadCapacity, typeOfAnimal )
SELECT  name,
        birthday,
        command,
        species,
        loadCapacity,
        "donkey"
FROM donkey
UNION
SELECT  name,
        birthday,
        command,
        species,
        loadCapacity,
        "horse"
FROM horse;

SELECT * FROM packAnimalNew;


#  Создать новую таблицу “youngAnimals” в которую попадут все животные старше 1 года,
# но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице

CREATE TABLE youngAnimals
(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    command VARCHAR(60),
    birthday DATE,
    species VARCHAR (30),
    typeOfAnimal VARCHAR (30),
    age INT
);

INSERT into youngAnimals (name, birthday, command, species, typeOfAnimal, age)
SELECT  name,
        birthday,
       command,
        species,
        "cat",
        TIMESTAMPDIFF(MONTH, birthday, CURRENT_DATE)
FROM cat
WHERE TIMESTAMPDIFF(MONTH, birthday, CURRENT_DATE)  > 12 AND TIMESTAMPDIFF(MONTH, birthday, CURRENT_DATE)  < 36
UNION
SELECT  name,
        birthday,
        command,
        species,
        "dog",
       TIMESTAMPDIFF(MONTH, birthday, CURRENT_DATE)
FROM dog
WHERE TIMESTAMPDIFF(MONTH, birthday, CURRENT_DATE)  > 12 AND TIMESTAMPDIFF(MONTH, birthday, CURRENT_DATE)  < 36
UNION
SELECT  name,
        birthday,
        command,
        species,
        "hamster",
        TIMESTAMPDIFF(MONTH, birthday, CURRENT_DATE) AS age
FROM hamster
WHERE TIMESTAMPDIFF(MONTH, birthday, CURRENT_DATE)  > 12 AND TIMESTAMPDIFF(MONTH, birthday, CURRENT_DATE)  < 36
UNION
SELECT  name,
        birthday,
        command,
        species,
        typeOfAnimal,
        TIMESTAMPDIFF(MONTH, birthday, CURRENT_DATE)
FROM packAnimalNew
WHERE TIMESTAMPDIFF(MONTH, birthday, CURRENT_DATE)  > 12 AND TIMESTAMPDIFF(MONTH, birthday, CURRENT_DATE)  < 36;

select * from youngAnimals;


# Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.

INSERT INTO humanFriend (name, Command, birthday, typeOfAnimal)
SELECT  name,
        command,
        birthday,
        "cat"
FROM cat
UNION
SELECT  name,
        command,
        birthday,
        "dog"
FROM dog
UNION
SELECT  name,
        command,
        birthday,
        "hamster"
FROM hamster
UNION
SELECT  name,
        command,
        birthday,
        "horse"
FROM horse
UNION
SELECT  name,
        command,
        birthday,
       "donkey"
FROM donkey;

SELECT * FROM humanFriend;
