/*
날짜 20250717
이름 최민수
내용 DB5장 객체
*/

--워크북 p13
--실습하기 3-1

select * from dictionary;
select table_name from user_tables;
select owner, table_name from all_tables;
select * from dba_tables;
select * from dba_users;

select instance_name, status, database_status, host_name from V$INSTANCE;

-- 실습하기 3-2
SELECT * FROM USER_INDEXES;
SELECT * FROM USER_IND_COLUMNS;

-- 실습하기 3-3
CREATE INDEX IDX_USER1_ID ON USER1(USER_ID);
SELECT * FROM USER_IND_COLUMNS;

-- 인덱스 삭제
--DROP INDEX IDX_USER1_ID;

-- 실습하기 3-6 뷰
-- 유저를 위한 것이 아닌 개발자(low level)를 위해 만듬
-- 테이블의 민감한 내용을 제외한 뷰를 만들고 권한을 고위 관리자가 줌
CREATE VIEW VW_USER1 AS (SELECT NAME, HP, AGE FROM USER1);
create view VW_USER2_AGE_UNDER30 AS (SELECT * FROM USER2 WHERE AGE<30);
SELECT * FROM USER_VIEWS;

-- 실습하기 3-9
CREATE TABLE USER6 (
    SEQ NUMBER PRIMARY KEY,
    NAME VARCHAR2(20),
    GENDER CHAR(1),
    AGE NUMBER,
    ADDR VARCHAR2(255)
);

-- 실습 3-10 시퀀스 생성
CREATE SEQUENCE SEQ_USER6 INCREMENT BY 1 START WITH 1;

-- 3-11 시퀀스 삽입
INSERT INTO USER6 VALUES (SEQ_USER6.NEXTVAL, '김유신', 'M', 25, '김해시');
INSERT INTO USER6 VALUES (SEQ_USER6.NEXTVAL, '김춘추', 'M', 23, '경주시');
INSERT INTO USER6 VALUES (SEQ_USER6.NEXTVAL, '신사임당', 'F', 27, '강릉시');

-- 4-1 사용자 생성
// 오라클에서 내부 스크립트 실행이나 일반사용자 생성을 위한 세션 설정
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;
CREATE USER TEST1 IDENTIFIED BY 1234;

// 4-2 사용자 조회
SELECT * FROM ALL_USERS;
// 비번 변경
ALTER USER TEST1 IDENTIFIED BY 1234;

-- 4-4 권한 부여
GRANT CONNECT, RESOURCE TO TEST1;
GRANT UNLIMITED TABLESPACE TO TEST1;


















