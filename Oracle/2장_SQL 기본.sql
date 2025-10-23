-- 날짜 2025 0714
-- 이름 최민수
-- 내용 1장 데이터베이스와 DBMS 개요

-- 실습 1-2. NUMBER 자료형 이해
//NUMBER(정수자릿수,소수점 자릿수)
create table TYPE_TEST_NUMBER (
    num1 NUMBER,
    num2 NUMBER(2),
    num3 NUMBER(3, 1),
    num4 NUMBER(4, 2),
    num5 NUMBER(5, 6),
    num6 NUMBER(6, -1)
);
delete from type_test_number;

//num1 NUMBER
insert into TYPE_TEST_NUMBER (num1) values (1);
insert into TYPE_TEST_NUMBER (num1) values (123);
insert into TYPE_TEST_NUMBER (num1) values (123.74);
insert into TYPE_TEST_NUMBER (num1) values (123.12345);

//num2 NUMBER(2)
insert into TYPE_TEST_NUMBER (num2) values (12);
//insert into TYPE_TEST_NUMBER (num2) values (123);
insert into TYPE_TEST_NUMBER (num2) values (1.2);
insert into TYPE_TEST_NUMBER (num2) values (1.23);
insert into TYPE_TEST_NUMBER (num2) values (12.34567);
insert into TYPE_TEST_NUMBER (num2) values (12.56789);
//insert into TYPE_TEST_NUMBER (num2) values (123.56789);

//num3 NUMBER(3,1)
insert into TYPE_TEST_NUMBER (num3) values (12);
//insert into TYPE_TEST_NUMBER (num3) values (123); //오류
insert into TYPE_TEST_NUMBER (num3) values (12.1);
insert into TYPE_TEST_NUMBER (num3) values (12.1234);
insert into TYPE_TEST_NUMBER (num3) values (12.56789);
//insert into TYPE_TEST_NUMBER (num3) values (123.56789); //오류

// 실습하기 1-4.테이블생성

CREATE TABLE USER1 (
    USER_ID VARCHAR2(20),
    NAME    VARCHAR2(20),
    HP      CHAR(13),
    AGE     NUMBER
);

//DROP TABLE USER1;

// 실습하기 1-5
INSERT INTO USER1 VALUES ('A101', '김유신', '010-1234-1111', 25);
INSERT INTO USER1 VALUES ('A102', '김춘추', '010-1234-2222', 23);
INSERT INTO USER1 VALUES ('A103', '장보고', '010-1234-3333', 32);
INSERT INTO USER1 (user_id, NAME, AGE) VALUES ('A104', '강감찬', 45);
INSERT INTO USER1 (USER_ID, NAME, HP) VALUES ('A105', '이순신', '010-1234-5555');

// 실습하기 1-6
SELECT * FROM USER1;
SELECT user_id,name FROM USER1;
SELECT * FROM USER1 WHERE user_id='A101';
SELECT * FROM USER1 WHERE AGE >30;

// 실습하기 1-7
UPDATE USER1 SET HP='010-1234-4444' WHERE user_id = 'A104';
UPDATE USER1 SET 
                AGE =   51,
                HP  =   '010-1234-1001' 
            WHERE
                user_id = 'A105';
                
// 실습하기 1-8
DELETE FROM USER1 WHERE user_id = 'A101';
DELETE FROM USER1 WHERE user_id = 'A102' AND AGE = 25;
DELETE FROM USER1 WHERE AGE >=30;



