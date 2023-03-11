# �������� ��:

CREATE DATABASE humanFriends;
USE humanFriends;


# �������� ������ � �������� �� ��������� ��:

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


# ���������� ������ cat, dog, hamster,horse, camel, donkey

INSERT INTO cat (name, birthday, command, species)
VALUES
    ("�����", "2020-03-15", "�� ���","����-���"),
    ("������", "2021-10-01", "������","�������"),
    ("���", "2018-03-10", "������","�����"),
    ("�������", "2023-01-08", "������","�������"),
    ("������", "2022-02-11", "�� ���","������");

SELECT * FROM cat;

INSERT INTO dog (name, birthday, command, species, pedigree)
VALUES
    ("����", "2019-04-15", "��� ����","����", "������������� E8L385 �� 03.05.2019"),
    ("������", "2022-12-01", "��������","�������", "��� �����������"),
    ("����", "2018-05-10", "������","��������", "�������������  697311� �� 06.11.2018 "),
    ("���", "2023-02-08", "�����","������", "��� ����������� "),
    ("�����", "2022-10-11", "�������","�����", "��� ����������� "),
    ("�����", "2022-10-11", "������","�����", "��� ����������� ");

SELECT * FROM dog;

INSERT INTO hamster (name, birthday, command, species)
VALUES
   ("�����", "2020-04-15", "������","���������"),
    ("������", "2021-11-01", "�� ���","����������"),
    ("������", "2018-05-10", "������","���������"),
    ("�������", "2023-02-07", "������","���������");

SELECT * FROM hamster;

INSERT INTO horse (name, birthday, command, loadCapacity, species)
VALUES
    ("������", "2020-05-16", "��", 200,  "���������"),
    ("��������", "2021-12-01", "�����", 120, "��������"),
    ("�����", "2018-07-10", "�� �����", 130, "�����"),
    ("�����", "2023-01-07", "�������", 200, "����");

SELECT * FROM horse;

INSERT INTO camel (name, birthday, command, loadCapacity, numberOfHumps)
VALUES
    ("�������", "2020-06-15", "����", 200,  1),
    ("�������", "2021-12-10", "����", 220, 2),
    ("�������", "2018-07-07", "����", 220, 2);

SELECT * FROM camel;

INSERT INTO donkey (name, birthday, command, loadCapacity, species)
VALUES
   ("�����", "2020-01-16", "�������", 70,  "�����������"),
    ("�����", "2021-10-01", "����", 90, "���������"),
    ("�����", "2018-09-05", "����", 90, "������������"),
    ("������", "2022-12-07", "�������", 130, "������");

SELECT * FROM donkey;


# �������� ������ ���� ������� �� ������� camel

DELETE FROM camel;
SELECT * FROM camel;


# ����������� ������ horse � donkey � ���� ����� ������� packAnimalNew:

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


#  ������� ����� ������� �youngAnimals� � ������� ������� ��� �������� ������ 1 ����,
# �� ������ 3 ��� � � ��������� ������� � ��������� �� ������ ���������� ������� �������� � ����� �������

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


# ���������� ��� ������� � ����, ��� ���� �������� ����, ����������� �� ������� �������������� � ������ ��������.

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
