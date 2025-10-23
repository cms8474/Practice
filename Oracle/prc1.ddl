-- 생성자 Oracle SQL Developer Data Modeler 24.3.1.347.1153
--   위치:        2025-08-11 10:41:13 KST
--   사이트:      Oracle Database 21c
--   유형:      Oracle Database 21c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE customer (
    custid VARCHAR2(10 BYTE) NOT NULL,
    name   VARCHAR2(10 BYTE),
    hp     CHAR(13 BYTE),
    addr   VARCHAR2(100 BYTE),
    rdate  DATE
);

ALTER TABLE customer ADD CONSTRAINT customer_pk PRIMARY KEY ( custid );

ALTER TABLE customer ADD CONSTRAINT customer__un UNIQUE ( hp );

CREATE TABLE "Order" (
    orderno      NUMBER NOT NULL,
    orderid      VARCHAR2(10 BYTE),
    orderproduct NUMBER,
    ordercount   NUMBER NOT NULL,
    orderdate    DATE NOT NULL
);

ALTER TABLE "Order" ADD CONSTRAINT order_pk PRIMARY KEY ( orderno );

CREATE TABLE product (
    prodno   NUMBER NOT NULL,
    prodname VARCHAR2(10 BYTE) NOT NULL,
    stock    NUMBER NOT NULL,
    price    NUMBER,
    company  VARCHAR2(20 BYTE) NOT NULL
);

ALTER TABLE product ADD CONSTRAINT product_pk PRIMARY KEY ( prodno );

ALTER TABLE "Order"
    ADD CONSTRAINT order_customer_fk FOREIGN KEY ( orderid )
        REFERENCES customer ( custid );

ALTER TABLE "Order"
    ADD CONSTRAINT order_product_fk FOREIGN KEY ( orderproduct )
        REFERENCES product ( prodno );



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

INSERT INTO Customer (custid, name, hp, addr, rdate) VALUES ('c101', '김유신', '010-1234-1001', '경남 김해시', '2023-01-01');
INSERT INTO Customer (custid, name, hp, addr, rdate) VALUES ('c102', '김춘추', '010-1234-1002', '경남 경주시', '2023-01-02');
INSERT INTO Customer (custid, name, hp, addr, rdate) VALUES ('c103', '장보고', '010-1234-1003', '전남 완도군', '2023-01-03');
INSERT INTO Customer (custid, name, hp, addr, rdate) VALUES ('c104', '강감찬', '010-1234-1004', '서울시 관악구', '2023-01-04');
INSERT INTO Customer (custid, name, hp, addr, rdate) VALUES ('c105', '이순신', '010-1234-1005', '부산시 금정구', '2023-01-05');

INSERT INTO Product (prodNo, prodName, stock, price, company) VALUES (1, '새우깡', 5000, 1500, '농심');
INSERT INTO Product (prodNo, prodName, stock, price, company) VALUES (2, '초코파', 2500, 2500, '오리온');
INSERT INTO Product (prodNo, prodName, stock, price, company) VALUES (3, '포카칩', 3600, 1700, '오리온');
INSERT INTO Product (prodNo, prodName, stock, price, company) VALUES (4, '양파링', 1250, 1800, '농심');
INSERT INTO Product (prodNo, prodName, stock, price, company) VALUES (5, '죠리퐁', 2200, NULL, '크라운');

INSERT INTO "Order" (orderNo, orderId, orderProduct, orderCount, orderDate) VALUES (1, 'c102', 3, 2, TO_DATE('2023-01-01 13:15:10', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "Order" (orderNo, orderId, orderProduct, orderCount, orderDate) VALUES (2, 'c101', 4, 1, TO_DATE('2023-01-01 13:15:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "Order" (orderNo, orderId, orderProduct, orderCount, orderDate) VALUES (3, 'c102', 1, 1, TO_DATE('2023-01-01 13:15:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "Order" (orderNo, orderId, orderProduct, orderCount, orderDate) VALUES (4, 'c103', 5, 5, TO_DATE('2023-01-01 13:15:16', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "Order" (orderNo, orderId, orderProduct, orderCount, orderDate) VALUES (5, 'c105', 2, 1, TO_DATE('2023-01-01 13:15:18', 'YYYY-MM-DD HH24:MI:SS'));


-- ■■■■■■■■■■■■■■■■■■■■■■■■■■
-- ■■■■■■■■■■■■■■■■■■■■■■■■■■
-- ■■■■■■■■■■■■■■■■■■■■■■■■■■

SELECT
    O.orderNo,
    C.name AS customerName,
    P.prodName,
    O.orderCount,
    O.orderDate
FROM
    "Order" O
JOIN
    Customer C ON O.orderId = C.custid
JOIN
    Product P ON O.orderProduct = P.prodNo;
    
SELECT
    O.orderNo,
    P.prodNo,
    P.prodName,
    P.price,
    O.orderCount,
    O.orderDate
FROM
    "Order" O
JOIN
    Customer C ON O.orderId = C.custid
JOIN
    Product P ON O.orderProduct = P.prodNo
WHERE
    C.name = '김유신';
    
    
SELECT
    SUM(O.orderCount * P.price) AS totalOrderAmount
FROM
    "Order" O
JOIN
    Product P ON O.orderProduct = P.prodNo;