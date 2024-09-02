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

UPDATE animal_ins SET ANIMAL_TYPE = 'Cat' WHERE ANIMAL_ID = 'A373219';