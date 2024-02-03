## Команды для создания базы данных друзья человека.
1. CREATE DATABASE Друзья_человека;
2. CREATE TABLE Pets ( 
    - id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    - name VARCHAR (100) NOT NULL, 
    - type VARCHAR (30) NOT NULL,
    - birthDate DATE NOT NULL, 
    - comands VARCHAR (255)
    - );
3. CREATE TABLE Pack_Animals ( 
    - id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    - name VARCHAR (100) NOT NULL, 
    - type VARCHAR (30) NOT NULL,
    - birthDate DATE NOT NULL, 
    - comands VARCHAR (255)
    - );
4.  INSERT INTO Pets (name, type, birthDate, Comands) VALUES
    - ('Fido', 'Dog', '2020-01-01', 'Sit, Stay, Fetch'),
    - ('Whiskers', 'Cat', '2019-05-15', 'Sit, Pounce'),
    - ('Hammy', 'Hamster', '2021-03-10', 'Roll, Hide'),
    - ('Buddy', 'Dog', '2018-12-10', 'Sit, Paw, Bark'),
    - ('Smudge', 'Cat', '2020-02-20', 'Sit, Pounce, Scratch'),
    - ('Peanut', 'Hamster', '2021-08-01', 'Roll, Spin'),
    - ('Bella', 'Dog', '2019-11-11', 'Sit, Stay, Roll'),
    - ('Oliver', 'Cat', '2020-06-30', 'Meow, Scratch, Jump'
    - );
5. INSERT INTO Pack_Animals (name, type, birthDate, Comands) VALUES
    - ('Thunder', 'Horse', '2015-07-21', 'Trot, Canter, Gallop'),
    - ('Sandy', 'Camel', '2016-11-03', 'Walk, Carry Load'),
    - ('Eeyore', 'Donkey', '2017-09-18', 'Walk, Carry Load, Bray'),
    - ('Storm', 'Horse', '2014-05-05', 'Trot, Canter'),
    - ('Dune', 'Camel', '2018-12-12', 'Walk, Sit'),
    - ('Burro', 'Donkey', '2019-01-23', 'Walk, Bray, Kick'),
    - ('Blaze', 'Horse', '2016-02-29', 'Trot, Jump, Gallop'),
    - ('Sahara', 'Camel', '2015-08-14', 'Walk, Run'
    - );
6. DELETE FROM Pack_Animals WHERE Type = 'Camel';
7. CREATE TABLE YoungAnimals AS
    - SELECT *, TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) AS AgeInMonths FROM (
    - SELECT * FROM Pets
    - UNION ALL
    - SELECT * FROM Pack_Animals
    - ) AS Combined
    - WHERE TIMESTAMPDIFF(YEAR, BirthDate, CURDATE()) BETWEEN 1 AND 3
    - ;
8. CREATE TABLE AllAnimals AS
    - SELECT 'Pet' AS Source, ID, name, type, birthDate, comands FROM Pets
    - UNION ALL
    - SELECT 'Pack_Animal' AS Source, ID, name, type, birthDate, comands FROM Pack_Animals
    - UNION ALL
    - SELECT 'YoungAnimal' AS Source, ID, name, type, birthDate, comands FROM YoungAnimals
    - ;

