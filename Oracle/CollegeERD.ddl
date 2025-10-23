-- 생성자 Oracle SQL Developer Data Modeler 24.3.1.347.1153
--   위치:        2025-08-11 12:33:14 KST
--   사이트:      Oracle Database 21c
--   유형:      Oracle Database 21c
/*
drop table REGISTER;
drop table STUDENT;
drop table LECTURE;
*/
-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE lecture (
    lecno     NUMBER NOT NULL,
    lecname   VARCHAR2(50) NOT NULL,
    leccredit NUMBER NOT NULL,
    lectime   NUMBER NOT NULL,
    lecclass  VARCHAR2(20)
);

ALTER TABLE lecture ADD CONSTRAINT lecture_pk PRIMARY KEY ( lecno );

CREATE TABLE register (
    regstdno      CHAR(8) NOT NULL,
    reglecno      NUMBER NOT NULL,
    regmidscore   NUMBER,
    regfinalscore NUMBER,
    regtotalscore NUMBER,
    reggrade      CHAR(1)
);

-- ALTER TABLE register ADD CONSTRAINT register_pk PRIMARY KEY ( regstdno );

CREATE TABLE student (
    stdno      CHAR(8) NOT NULL,
    stdname    VARCHAR2(20) NOT NULL,
    stdhp      CHAR(13) NOT NULL,
    stdyear    NUMBER NOT NULL,
    stdaddress VARCHAR2(100)
);

ALTER TABLE student ADD CONSTRAINT student_pk PRIMARY KEY ( stdno );

ALTER TABLE student ADD CONSTRAINT student__un UNIQUE ( stdhp );

ALTER TABLE register
    ADD CONSTRAINT register_lecture_fk FOREIGN KEY ( reglecno )
        REFERENCES lecture ( lecno );

ALTER TABLE register
    ADD CONSTRAINT register_student_fk FOREIGN KEY ( regstdno )
        REFERENCES student ( stdno );



-- Oracle SQL Developer Data Modeler 요약 보고서: 
-- 
-- CREATE TABLE                             3
-- CREATE INDEX                             0
-- ALTER TABLE                              6
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0

-- ■■■■■■■■■■■■■■■■■■■■■■■■■■
-- ■■■■■■■■■■■■■■■■■■■■■■■■■■
-- ■■■■■■■■■■■■■■■■■■■■■■■■■■
INSERT INTO Student (stdNo, stdName, stdHp, stdYear, stdAddress) VALUES ('20201011', '김유신', '010-1234-1001', 3, '경남 김해시');
INSERT INTO Student (stdNo, stdName, stdHp, stdYear, stdAddress) VALUES ('20201122', '김춘추', '010-1234-1002', 3, '경남 경주시');
INSERT INTO Student (stdNo, stdName, stdHp, stdYear, stdAddress) VALUES ('20210213', '장보고', '010-1234-1003', 2, '전남 완도군');
INSERT INTO Student (stdNo, stdName, stdHp, stdYear, stdAddress) VALUES ('20210324', '강감찬', '010-1234-1004', 2, '서울 관악구');
INSERT INTO Student (stdNo, stdName, stdHp, stdYear, stdAddress) VALUES ('20220415', '이순신', '010-1234-1005', 1, '서울 종로구');

INSERT INTO Lecture (lecNo, lecName, lecCredit, lecTime, lecClass) VALUES (101, '컴퓨터과학 개론', 2, 40, '본301');
INSERT INTO Lecture (lecNo, lecName, lecCredit, lecTime, lecClass) VALUES (102, '프로그래밍 언어', 3, 52, '본302');
INSERT INTO Lecture (lecNo, lecName, lecCredit, lecTime, lecClass) VALUES (103, '데이터베이스', 3, 56, '본303');
INSERT INTO Lecture (lecNo, lecName, lecCredit, lecTime, lecClass) VALUES (104, '자료구조', 3, 60, '본304');
INSERT INTO Lecture (lecNo, lecName, lecCredit, lecTime, lecClass) VALUES (105, '운영체제', 3, 52, '본305');

INSERT INTO Register (regStdNo, regLecNo, regMidScore, regFinalScore) VALUES ('20220415', 101, 60, 30);
INSERT INTO Register (regStdNo, regLecNo, regMidScore, regFinalScore) VALUES ('20210324', 103, 54, 36);
INSERT INTO Register (regStdNo, regLecNo, regMidScore, regFinalScore) VALUES ('20201011', 105, 52, 28);
INSERT INTO Register (regStdNo, regLecNo, regMidScore, regFinalScore) VALUES ('20220415', 102, 38, 40);
INSERT INTO Register (regStdNo, regLecNo, regMidScore, regFinalScore) VALUES ('20210324', 104, 56, 32);
INSERT INTO Register (regStdNo, regLecNo, regMidScore, regFinalScore) VALUES ('20210213', 103, 48, 40);

-- ■■■■■■■■■■■■■■■■■■■■■■■■■■
-- ■■■■■■■■■■■■■■■■■■■■■■■■■■
-- ■■■■■■■■■■■■■■■■■■■■■■■■■■
--☞실습6-9.다음데이터를조회하시오. 
--> 이번학기에수강신청하지않은학생의학번,이름,연락처,학년을조회하시오. 


--> 중간고사점수와기말고사점수의총합을구하고등급을구하시오. 


--> 2학년학생의학번,이름,학년,수강강좌명,중간점수,기말점수,총합,등급을조회하시오.
