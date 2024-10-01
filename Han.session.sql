-- SELECT * FROM ANIMAL_INS ORDER BY DATETIME DESC 

-- ALTER TABLE product 
-- ADD PRIMARY KEY (PRODUCT_ID),
-- ADD CONSTRAINT UNIQUE(PRODUCT_CODE);

SELECT * FROM product
-- UPDATE PRODUCT 
-- SET PRODUCT_CODE = CASE
--     WHEN PRODUCT_ID = 1 THEN "A1000011"
--     WHEN PRODUCT_ID = 3 THEN "C3000002"
--     WHEN PRODUCT_ID = 4 THEN "C3000006"
--     WHEN PRODUCT_ID = 5 THEN "C3000010"
--     WHEN PRODUCT_ID = 6 THEN "K1000023"
--     ELSE PRODUCT_CODE
-- END
-- WHERE PRODUCT_ID IN (1,2,3,4,5,6)

-- CREATE TABLE IF NOT EXISTS PRODUCT(
--     PRODUCT_ID INT NOT NULL,
--     PRODUCT_CODE VARCHAR(8) NOT NULL,
--     PRICE INT NOT NULL
-- )

-- INSERT INTO animal_ins VALUES 
--    ("A349996", "Cat", "2018-01-22 14:32:00", "Normal", "Sugar", "Neutered Male"),
--    ("A352555", "Dog", "2014-08-08 04:20:00", "Normal", "Harley", "Spayed Female"),
--    ("A352713", "Cat", "2017-04-13 16:29:00", "Normal", "Gia", "Spayed Female");

-- INSERT INTO ANIMAL_INS VALUES 
--     ("A350276", "Cat", "2017-08-13 13:50:00", "Normal", "Jewel", "Spayed Female"),
--     ("A350375", "Cat", "2017-03-06 15:01:00", "Normal", "Meo", "Neutered Male"),
--     ("A368930", "Dog", "2014-06-08 13:20:00", "Normal", NULL, "Spated Female");

-- UPDATE food_product SET PRICE = 6500 WHERE PRODUCT_ID = "P0020"

-- INSERT INTO food_product VALUES 
--     ("P0018", "맛있는고추기름", "CD_OL00008", "식용유", 6100),
--     ("P0019", "맛있는카놀라유", "CD_OL00009", "식용유", 5100),
--     ("P0020", "맛있는산초유", "CD_OL00010", "식용유", 6100),
--     ("P0021", "맛있는케첩", "CD_OL00001", "소스", 4500),
--     ("P0022", "맛있는마요네즈", "CD_OL00002", "소스", 4700);

-- CREATE TABLE IF NOT EXISTS FOOD_PRODUCT(
--     PRODUCT_ID VARCHAR(10) NOT NULL,
--     PRODUCT_NAME VARCHAR(50) NOT NULL,
--     PRODUCT_CD VARCHAR(10),
--     CATEGORY VARCHAR(10),
--     PRICE INT,
--     PRIMARY KEY(PRODUCT_ID)
-- )

-- CREATE TABLE ANIMAL_INS(
--     ANIMAL_ID VARCHAR(20) NOT NULL,
--     ANIMAL_TYPE	VARCHAR(20) NOT NULL,
--     DATETIME DATETIME DEFAULT CURRENT_TIMESTAMP,
--     INTAKE_CONDITION VARCHAR(20) NOT NULL,
--     NAME VARCHAR(20),
--     SEX_UPON_INTAKE	VARCHAR(20)	NOT NULL,
--     PRIMARY KEY(ANIMAL_ID)
-- )

-- INSERT INTO ANIMAL_INS VALUES 
--     ('A396810', 'Dog', '2016-08-22 16:13:00', 'Injured'	,'Raven', 'Spayed Female'), 
--     ('A377750', 'Dog', '2017-10-25 17:17:00', 'Normal', 'Lucy', 'Spayed Female'),
--     ('A355688', 'Dog', '2014-01-26 13:48:00', 'Normal', 'Shadow', 'Neutered Male'),
--     ('A399421', 'Dog', '2014-01-26 13:48:00', 'Normal', 'Lucy', 'Spayed Female'),
--     ('A400680', 'Dog', '2017-06-17 13:29:00', 'Normal', 'Lucy', 'Spayed Female'),
--     ('A410668', 'Dog', '2015-11-19 13:41:00', 'Normal', 'Raven', 'Spayed Female')

-- INSERT INTO ANIMAL_INS VALUES 
--     ('A355753', 'Dog', '2015-09-10 13:14:00', 'Injured'	,'Elijah', 'Neutered Male'), 
--     ('A352872', 'Dog', '2015-07-09 17:51:00', 'Aged', 'Peanutbutter', 'Neutered Male'),
--     ('A353259', 'Dog', '2016-05-08 12:57:00', 'Injured', 'Bj', 'Neutered Male'),
--     ('A373219', 'Dog', '2014-07-29 11:43:00', 'Normal', 'Ella', 'Spayed Female'),
--     ('A382192', 'Dog', '2015-03-13 13:14:00', 'Normal', 'Maxwell 2', '	Intact Male')

-- UPDATE animal_ins SET ANIMAL_TYPE = 'Cat' WHERE ANIMAL_ID = 'A373219';

-- INSERT INTO animal_ins VALUES 
--     ('A562649', 'Dog', '2014-03-20 18:06:00', 'Sick', NULL, 'Spayed Female'),
--     ('A412626', 'Dog', '2016-03-13 11:17:00', 'Normal', '*Sam', 'Neutered Male'),
--     ('A563492', 'Dog', '2014-10-24 14:45:00', 'Normal', '*Sam', 'Neutered Male'),
--     ('A513956', 'Dog', '2017-06-14 11:54:00', 'Normal', '*Sweetie', 'Spayed Female');

-- SELECT * FROM animal_ins


