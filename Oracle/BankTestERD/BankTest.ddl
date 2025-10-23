-- 생성자 Oracle SQL Developer Data Modeler 24.3.1.347.1153
--   위치:        2025-08-13 09:24:26 KST
--   사이트:      Oracle Database 21c
--   유형:      Oracle Database 21c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE account (
    acc_id            CHAR(14) NOT NULL,
    cust_jumin        CHAR(14),
    acc_type          VARCHAR2(20) NOT NULL,
    acc_balance       NUMBER NOT NULL,
    acc_card          CHAR(1) NOT NULL,
    acc_register_date DATE
);

ALTER TABLE account ADD CONSTRAINT account_pk PRIMARY KEY ( acc_id );

CREATE TABLE card (
    card_no            CHAR(14) NOT NULL,
    cust_jumin         CHAR(14),
    acc_id             CHAR(14),
    card_register_date DATE,
    card_limit         NUMBER,
    card_approve_date  DATE,
    card_type          VARCHAR2(10) NOT NULL
);

ALTER TABLE card ADD CONSTRAINT card_pk PRIMARY KEY ( card_no );

CREATE TABLE customer (
    cust_jumin CHAR(14) NOT NULL,
    name       VARCHAR2(20) NOT NULL,
    address    VARCHAR2(100) NOT NULL,
    birth      CHAR(10) NOT NULL,
    email      VARCHAR2(100),
    hp         VARCHAR2(20) NOT NULL,
    job        VARCHAR2(20)
);

ALTER TABLE customer ADD CONSTRAINT customer_pk PRIMARY KEY ( cust_jumin );

ALTER TABLE customer ADD CONSTRAINT customer__un UNIQUE ( email,
                                                          hp );

CREATE TABLE transaction (
    trans_id      NUMBER NOT NULL,
    trans_acc_id  CHAR(14) NOT NULL,
    trans_type    VARCHAR2(20),
    trans_message VARCHAR2(20),
    trans_money   NUMBER,
    trans_date    DATE NOT NULL
);

ALTER TABLE transaction ADD CONSTRAINT transaction_pk PRIMARY KEY ( trans_id );

ALTER TABLE account
    ADD CONSTRAINT account_customer_fk FOREIGN KEY ( cust_jumin )
        REFERENCES customer ( cust_jumin );

ALTER TABLE card
    ADD CONSTRAINT card_account_fk FOREIGN KEY ( acc_id )
        REFERENCES account ( acc_id );

ALTER TABLE card
    ADD CONSTRAINT card_customer_fk FOREIGN KEY ( cust_jumin )
        REFERENCES customer ( cust_jumin );

ALTER TABLE transaction
    ADD CONSTRAINT transaction_account_fk FOREIGN KEY ( trans_acc_id )
        REFERENCES account ( acc_id );

CREATE SEQUENCE transaction_trans_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER transaction_trans_id_trg BEFORE
    INSERT ON transaction
    FOR EACH ROW
    WHEN ( new.trans_id IS NULL )
BEGIN
    :new.trans_id := transaction_trans_id_seq.nextval;
END;
/



-- Oracle SQL Developer Data Modeler 요약 보고서: 
-- 
-- CREATE TABLE                             4
-- CREATE INDEX                             0
-- ALTER TABLE                              9
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           1
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
-- CREATE SEQUENCE                          1
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
/* ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
   ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
   ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/

-- ■■■ CUSTOMER
INSERT INTO CUSTOMER VALUES ('760121-1234567', '정우성', '서울', '1976-01-21', '-', '010-1101-7601', '배우');
INSERT INTO CUSTOMER VALUES ('750611-1234567', '이정재', '서울', '1975-06-11', '-', '010-1102-7506', '배우');
INSERT INTO CUSTOMER VALUES ('890530-1234567', '전지현', '대전', '1989-05-30', 'jjh@naver.com', '010-1103-8905', '자영업');
INSERT INTO CUSTOMER VALUES ('790413-1234567', '이나영', '대전', '1979-04-13', 'lee@naver.com', '010-2101-7904', '회사원');
INSERT INTO CUSTOMER VALUES ('660912-1234567', '원빈', '대전', '1966-09-12', 'one@daum.net', '010-2104-6609', '배우');

-- ■■■ ACCOUNT
INSERT INTO ACCOUNT VALUES ('1011-1001-1001', '760121-1234567', '자유입출금', 4160000, 'Y', '2020-01-21 13:00:02');
INSERT INTO ACCOUNT VALUES ('1011-1001-1002', '890530-1234567', '자유입출금', 376000, 'Y', '2020-06-11 13:00:02');
INSERT INTO ACCOUNT VALUES ('1011-1001-1003', '790413-1234567', '자유입출금', 1200000, 'Y', '2020-05-30 13:00:02');
INSERT INTO ACCOUNT VALUES ('1011-2001-1004', '660912-1234567', '정기적금', 1000000, 'N', '2020-04-13 13:00:02');
INSERT INTO ACCOUNT VALUES ('1011-1002-1005', '750611-1234567', '자유입출금', 820000, 'Y', '2020-09-12 13:00:02');

-- ■■■ CARD
INSERT INTO CARD VALUES('2111-1001-1001', '760121-1234567', '1011-1001-1001', '2020-01-21', 1000000, '2020-02-10', 'check');
INSERT INTO CARD VALUES('2041-1001-1002', '890530-1234567', '1011-1001-1002', '2020-06-11', 3000000, '2020-06-15', 'check');
INSERT INTO CARD VALUES('2011-1001-1003', '790413-1234567', '1011-1001-1003', '2020-05-30', 5000000, '2020-06-25', 'check');
INSERT INTO CARD VALUES('2611-1001-1005', '750611-1234567', '1011-1002-1005', '2020-09-12', 1500000, '2020-10-10', 'check');

-- ■■■ TRANSACTION
INSERT INTO TRANSACTION (TRANS_ACC_ID, TRANS_TYPE, TRANS_MESSAGE, TRANS_MONEY, TRANS_DATE) VALUES('1011-1001-1001', '입금', '2월 정기급여', 3500000, '2020-02-10 12:36:12');
INSERT INTO TRANSACTION (TRANS_ACC_ID, TRANS_TYPE, TRANS_MESSAGE, TRANS_MONEY, TRANS_DATE) VALUES('1011-1001-1003', '출금', 'ATM 출금', 300000,'2020-02-10 12:37:21');
INSERT INTO TRANSACTION (TRANS_ACC_ID, TRANS_TYPE, TRANS_MESSAGE, TRANS_MONEY, TRANS_DATE) VALUES('1011-1001-1002', '입금', '2월 급여', 2800000,'2020-02-10 12:38:21');
INSERT INTO TRANSACTION (TRANS_ACC_ID, TRANS_TYPE, TRANS_MESSAGE, TRANS_MONEY, TRANS_DATE) VALUES('1011-1001-1001', '출금', '2월 공과금', 116200,'2020-02-10 12:39:21');
INSERT INTO TRANSACTION (TRANS_ACC_ID, TRANS_TYPE, TRANS_MESSAGE, TRANS_MONEY, TRANS_DATE) VALUES('1011-1002-1005', '출금', 'ATM 출금', 50000,'2020-02-10 12:40:21');

   
   
   
   
   
/* ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
   ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
   ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/

-- ■■■ Q.1) "모든 고객" 정보 조회
SELECT * FROM CUSTOMER;

-- ■■■ Q.2) "모든 카드" 정보 조회
SELECT * FROM CARD;

-- ■■■ Q.3) "모든 예금계좌" 정보 조회
SELECT * FROM ACCOUNT;

-- ■■■ Q.4) "가장 최근 거래 내역 3건" 조회
SELECT 
    TRANS_DATE "최근 거래 내역" 
    FROM TRANSACTION
    ORDER BY trans_date DESC
    OFFSET 0 ROWS FETCH NEXT 3 ROWS ONLY
;

-- ■■■ Q.5) "카드한도금액 200만원 이상" "고객이름, 카드종류" 조회
SELECT 
    C.NAME "고객이름", 
    CA.CARD_TYPE "카드종류"
    FROM CUSTOMER C
    JOIN CARD CA ON c.cust_jumin = CA.cust_jumin
    WHERE CA.CARD_LIMIT >= 2000000
;

-- ■■■ Q.6) "예금계좌별" "거래 건수" 조회
SELECT 
    A.ACC_ID "예금 계좌", 
    COUNT(*)"거래 건수" 
    FROM ACCOUNT A
    JOIN TRANSACTION T ON a.acc_id = t.trans_acc_id
    GROUP BY A.ACC_ID
;

-- ■■■ Q.7) "거래금액 100만 이상" "거래 내역" "최근 거래순" 조회
SELECT * 
    FROM TRANSACTION
    WHERE trans_money >= 1000000
    ORDER BY trans_date DESC
;

-- ■■■ Q.8) "계좌와 연결된" "계좌ID, 카드ID, 카드종류" 조회
SELECT 
    A.ACC_ID "계좌ID", 
    C.CARD_NO "카드ID", 
    C.CARD_TYPE "카드종류"
    FROM ACCOUNT A
    JOIN CARD C ON A.ACC_ID = C.ACC_ID
;

-- ■■■ Q.9) "예금구분 = 입금" "거래 총합" 조회
SELECT SUM(TRANS_MONEY) "거래 총합"
    FROM TRANSACTION
    WHERE TRANS_TYPE = '입금'
;

-- ■■■ Q.10) "잔고 400만 이상 고객" "고객명, 주민번호, 전화번호, 주소" 조회
SELECT 
    C.NAME "고객명", 
    C.CUST_JUMIN "주민번호", 
    C.HP "전화번호", 
    C.ADDRESS "주소"
    FROM ACCOUNT A
    JOIN CUSTOMER C ON A.CUST_JUMIN = C.CUST_JUMIN
    WHERE A.acc_balance >= 4000000
;
   
/* ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
   ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
   ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/   














