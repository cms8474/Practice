-- 생성자 Oracle SQL Developer Data Modeler 24.3.1.347.1153
--   위치:        2025-08-11 16:00:41 KST
--   사이트:      Oracle Database 21c
--   유형:      Oracle Database 21c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE cart (
    cartno        NUMBER NOT NULL,
    userid        VARCHAR2(20) NOT NULL,
    prodno        NUMBER(6) NOT NULL,
    cartprodcount NUMBER DEFAULT 1,
    cartproddate  DATE NOT NULL
);

COMMENT ON COLUMN cart.cartno IS
    '일련번호 SEQUENCE';

COMMENT ON COLUMN cart.userid IS
    '고객아이디 (FK)';

COMMENT ON COLUMN cart.cartprodcount IS
    '상품수량';

COMMENT ON COLUMN cart.cartproddate IS
    '상품등록일';

ALTER TABLE cart ADD CONSTRAINT cart_pk PRIMARY KEY ( cartno );

CREATE TABLE category (
    cateno   NUMBER(2) NOT NULL,
    catename VARCHAR2(100) NOT NULL
);

ALTER TABLE category ADD CONSTRAINT category_pk PRIMARY KEY ( cateno );

CREATE TABLE orders (
    orderno         CHAR(11) NOT NULL,
    userid          VARCHAR2(20) NOT NULL,
    ordertotalprice NUMBER NOT NULL,
    orderaddress    VARCHAR2(200) NOT NULL,
    orderstatus     NUMBER DEFAULT 0,
    orderdate       DATE NOT NULL
);

COMMENT ON COLUMN orders.userid IS
    '고객아이디(FK)';

ALTER TABLE orders ADD CONSTRAINT orders_pk PRIMARY KEY ( orderno );

CREATE TABLE ordersitem (
    itemno       NUMBER NOT NULL,
    orderno      CHAR(11) NOT NULL,
    prodno       NUMBER(6) NOT NULL,
    itemprice    NUMBER NOT NULL,
    itemdiscount NUMBER NOT NULL,
    itemcount    NUMBER DEFAULT 1
);

COMMENT ON COLUMN ordersitem.itemno IS
    '일련번호 SEQUENCE';

COMMENT ON COLUMN ordersitem.orderno IS
    '주문번호 (FK)';

ALTER TABLE ordersitem ADD CONSTRAINT ordersitem_pk PRIMARY KEY ( itemno );

CREATE TABLE point (
    pointno   NUMBER NOT NULL,
    userid    VARCHAR2(20) NOT NULL,
    point     NUMBER NOT NULL,
    "desc"    VARCHAR2(100) NOT NULL,
    pointdate DATE NOT NULL
);

COMMENT ON COLUMN point.userid IS
    '고객아이디 (FK)';

ALTER TABLE point ADD CONSTRAINT point_pk PRIMARY KEY ( pointno );

CREATE TABLE product (
    prodno       NUMBER(6) NOT NULL,
    cateno       NUMBER(2) NOT NULL,
    sellerno     NUMBER(5) NOT NULL,
    prodname     VARCHAR2(50) NOT NULL,
    prodprice    NUMBER NOT NULL,
    prodstock    NUMBER DEFAULT 0,
    prodsold     NUMBER DEFAULT 0,
    proddiscount NUMBER DEFAULT 0
);

ALTER TABLE product ADD CONSTRAINT product_pk PRIMARY KEY ( prodno );

CREATE TABLE seller (
    sellerno NUMBER(5) NOT NULL,
    company  VARCHAR2(100) NOT NULL,
    tel      VARCHAR2(20) NOT NULL,
    manager  VARCHAR2(20) NOT NULL,
    address  VARCHAR2(100) NOT NULL
);

ALTER TABLE seller ADD CONSTRAINT seller_pk PRIMARY KEY ( sellerno );

CREATE TABLE "User" (
    userid  VARCHAR2(20) NOT NULL,
    name    VARCHAR2(20) NOT NULL,
    birth   CHAR(10) NOT NULL,
    gender  CHAR(1) NOT NULL,
    hp      CHAR(13) NOT NULL,
    email   VARCHAR2(100),
    point   NUMBER DEFAULT 0,
    "level" NUMBER DEFAULT 1,
    address VARCHAR2(100),
    regdate DATE NOT NULL
);

ALTER TABLE "User"
    ADD CONSTRAINT chk_userid_format
        CHECK ( length(userId) >= 4
                AND REGEXP_LIKE ( userId,
                                  '^[a-zA-Z0-9]+$' ) );

ALTER TABLE "User"
    ADD CONSTRAINT mf CHECK ( gender IN ( 'F', 'M' ) );

ALTER TABLE "User" ADD CONSTRAINT user_pk PRIMARY KEY ( userid );

ALTER TABLE cart
    ADD CONSTRAINT cart_product_fk FOREIGN KEY ( prodno )
        REFERENCES product ( prodno );

ALTER TABLE cart
    ADD CONSTRAINT cart_user_fk FOREIGN KEY ( userid )
        REFERENCES "User" ( userid );

ALTER TABLE orders
    ADD CONSTRAINT orders_user_fk FOREIGN KEY ( userid )
        REFERENCES "User" ( userid );

ALTER TABLE ordersitem
    ADD CONSTRAINT ordersitem_orders_fk FOREIGN KEY ( orderno )
        REFERENCES orders ( orderno );

ALTER TABLE ordersitem
    ADD CONSTRAINT ordersitem_product_fk FOREIGN KEY ( prodno )
        REFERENCES product ( prodno );

ALTER TABLE point
    ADD CONSTRAINT point_user_fk FOREIGN KEY ( userid )
        REFERENCES "User" ( userid );

ALTER TABLE product
    ADD CONSTRAINT product_category_fk FOREIGN KEY ( cateno )
        REFERENCES category ( cateno );

ALTER TABLE product
    ADD CONSTRAINT product_seller_fk FOREIGN KEY ( sellerno )
        REFERENCES seller ( sellerno );

CREATE SEQUENCE cart_cartno_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER cart_cartno_trg BEFORE
    INSERT ON cart
    FOR EACH ROW
    WHEN ( new.cartno IS NULL )
BEGIN
    :new.cartno := cart_cartno_seq.nextval;
END;
/

CREATE SEQUENCE ordersitem_itemno_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER ordersitem_itemno_trg BEFORE
    INSERT ON ordersitem
    FOR EACH ROW
    WHEN ( new.itemno IS NULL )
BEGIN
    :new.itemno := ordersitem_itemno_seq.nextval;
END;
/

CREATE SEQUENCE point_pointno_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER point_pointno_trg BEFORE
    INSERT ON point
    FOR EACH ROW
    WHEN ( new.pointno IS NULL )
BEGIN
    :new.pointno := point_pointno_seq.nextval;
END;
/



-- Oracle SQL Developer Data Modeler 요약 보고서: 
-- 
-- CREATE TABLE                             8
-- CREATE INDEX                             0
-- ALTER TABLE                             18
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           3
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
-- CREATE SEQUENCE                          3
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


-- ■고객 (User) 테이블■■■■■■■■■■■■■■■■■■■■■■■■■■
INSERT INTO "User" (userid, name, birth, gender, hp, email, point, "level", address, regdate) VALUES ('user1', '김유신', '1976-01-21', 'M', '010-1101-1976', 'kimys@naver.com', 7000, 1, '서울', TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "User" (userid, name, birth, gender, hp, email, point, "level", address, regdate) VALUES ('user2', '계백', '1975-06-11', 'M', '010-1102-1975', NULL, 5650, 1, '서울', TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "User" (userid, name, birth, gender, hp, email, point, "level", address, regdate) VALUES ('user3', '김춘추', '1989-05-30', 'M', '010-1103-1989', NULL, 4320, 2, '서울', TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "User" (userid, name, birth, gender, hp, email, point, "level", address, regdate) VALUES ('user4', '이사부', '1979-04-13', 'M', '010-2101-1979', 'leesabu@gmail.com', 0, 1, '서울', TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "User" (userid, name, birth, gender, hp, email, point, "level", address, regdate) VALUES ('user5', '장보고', '1966-09-12', 'M', '010-2104-1966', 'jangbg@naver.com', 3000, 4, '대전', TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "User" (userid, name, birth, gender, hp, email, point, "level", address, regdate) VALUES ('user6', '선덕여왕', '1979-07-28', 'M', '010-3101-1979', 'gueen@naver.com', 15840, 2, '대전', TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "User" (userid, name, birth, gender, hp, email, point, "level", address, regdate) VALUES ('user7', '강감찬', '1984-06-15', 'F', '010-4101-1984', 'kang@daum.net', 3610, 0, '대구', TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "User" (userid, name, birth, gender, hp, email, point, "level", address, regdate) VALUES ('user8', '신사임당', '1965-10-21', 'M', '010-5101-1965', 'sinsa@gmail.com', 0, 1, '대구', TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "User" (userid, name, birth, gender, hp, email, point, "level", address, regdate) VALUES ('user9', '이이', '1972-11-28', 'F', '010-6101-1972', 'leelee@nate.com', 0, 3, '부산', TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "User" (userid, name, birth, gender, hp, email, point, "level", address, regdate) VALUES ('user10', '허난설헌', '1992-09-07', 'F', '010-7103-1992', NULL, 0, 3, '광주', TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));

-- ■포인트 (Point) 테이블■■■■■■■■■■■■■■■■■■■■■■■■■■
INSERT INTO point (userid, point, "desc", pointdate) VALUES ('user1', 1000, '회원가입 1000 적립', TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO point (userid, point, "desc", pointdate) VALUES ('user1', 6000, '상품구매 5% 적립', TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO point (userid, point, "desc", pointdate) VALUES ('user3', 2820, '상품구매 5% 적립', TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO point (userid, point, "desc", pointdate) VALUES ('user7', 3610, '상품구매 5% 적립', TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO point (userid, point, "desc", pointdate) VALUES ('user5', 3000, '이벤트 응모 3000 적립', TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO point (userid, point, "desc", pointdate) VALUES ('user2', 1000, '회원가입 1000 적립', TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO point (userid, point, "desc", pointdate) VALUES ('user2', 2000, '이벤트 응모 2000 적립', TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO point (userid, point, "desc", pointdate) VALUES ('user2', 2650, '상품구매 5% 적립', TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO point (userid, point, "desc", pointdate) VALUES ('user3', 1500, '이벤트 응모 1500 적립', TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO point (userid, point, "desc", pointdate) VALUES ('user6', 15840, '상품구매 2% 적립', TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));

-- ■판매자 (Seller) 테이블■■■■■■■■■■■■■■■■■■■■■■■■■■
INSERT INTO seller (sellerno, company, tel, manager, address) VALUES (10001, '(주)다팔아', '02-201-1976', '정우성', '서울');
INSERT INTO seller (sellerno, company, tel, manager, address) VALUES (10002, '판매의민족', '02-102-1975', '이정재', '서울');
INSERT INTO seller (sellerno, company, tel, manager, address) VALUES (10003, '멋남', '031-103-1989', '원빈', '경기');
INSERT INTO seller (sellerno, company, tel, manager, address) VALUES (10004, '스타일살아', '032-201-1979', '이나영', '경기');
INSERT INTO seller (sellerno, company, tel, manager, address) VALUES (10005, '(주)삼성전자', '02-214-1966', '장동건', '서울');
INSERT INTO seller (sellerno, company, tel, manager, address) VALUES (10006, '복실이옷짱', '051-301-1979', '고소영', '부산');
INSERT INTO seller (sellerno, company, tel, manager, address) VALUES (10007, '컴퓨존(주)', '055-401-1984', '유재석', '대구');
INSERT INTO seller (sellerno, company, tel, manager, address) VALUES (10008, '(주)LG전자', '02-511-1965', '강호동', '서울');
INSERT INTO seller (sellerno, company, tel, manager, address) VALUES (10009, '굿바디스포츠', '070-6101-1972', '조인성', '부산');
INSERT INTO seller (sellerno, company, tel, manager, address) VALUES (10010, '누리푸드', '051-710-1992', '강동원', '부산');

-- ■상품 카테고리 (Category) 테이블■■■■■■■■■■■■■■■■■■■■■■■■■■
INSERT INTO category (cateno, catename) VALUES (10, '여성의류패션');
INSERT INTO category (cateno, catename) VALUES (11, '남성의류패션');
INSERT INTO category (cateno, catename) VALUES (12, '식품·생필품');
INSERT INTO category (cateno, catename) VALUES (13, '취미·반려견');
INSERT INTO category (cateno, catename) VALUES (14, '홈·문구');
INSERT INTO category (cateno, catename) VALUES (15, '자동차·공구');
INSERT INTO category (cateno, catename) VALUES (16, '스포츠·건강');
INSERT INTO category (cateno, catename) VALUES (17, '컴퓨터·가전·디지털');
INSERT INTO category (cateno, catename) VALUES (18, '여행');
INSERT INTO category (cateno, catename) VALUES (19, '도서');

-- ■상품 (Product) 테이블■■■■■■■■■■■■■■■■■■■■■■■■■■
INSERT INTO product (prodno, cateno, sellerno, prodname, prodstock, prodprice, prodsold, proddiscount) VALUES (100101, 11, 10003, '반팔티 L~2XL', 869, 25000, 132, 20);
INSERT INTO product (prodno, cateno, sellerno, prodname, prodstock, prodprice, prodsold, proddiscount) VALUES (100110, 10, 10004, '트레이닝 통바지', 1602, 38000, 398, 15);
INSERT INTO product (prodno, cateno, sellerno, prodname, prodstock, prodprice, prodsold, proddiscount) VALUES (110101, 10, 10003, '신상 여성운동화', 160, 76000, 40, 5);
INSERT INTO product (prodno, cateno, sellerno, prodname, prodstock, prodprice, prodsold, proddiscount) VALUES (120101, 12, 10010, '암소 1등급 구이셋트 1.2kg', NULL, 150000, 87, 15);
INSERT INTO product (prodno, cateno, sellerno, prodname, prodstock, prodprice, prodsold, proddiscount) VALUES (120103, 12, 10010, '바로구이 부채살 250g', NULL, 21000, 61, 10);
INSERT INTO product (prodno, cateno, sellerno, prodname, prodstock, prodprice, prodsold, proddiscount) VALUES (130101, 13, 10006, '[ANF] 식스프리 강아지 사료', 58, 56000, 142, 0);
INSERT INTO product (prodno, cateno, sellerno, prodname, prodstock, prodprice, prodsold, proddiscount) VALUES (130112, 13, 10006, '중대형 사계절 강아지옷', 120, 15000, 80, 0);
INSERT INTO product (prodno, cateno, sellerno, prodname, prodstock, prodprice, prodsold, proddiscount) VALUES (141001, 14, 10001, '라떼 2인 소파/방수 패브릭', NULL, 320000, 42, 0);
INSERT INTO product (prodno, cateno, sellerno, prodname, prodstock, prodprice, prodsold, proddiscount) VALUES (170115, 17, 10007, '지포스 3080 그래픽카드', 28, 900000, 12, 12);
INSERT INTO product (prodno, cateno, sellerno, prodname, prodstock, prodprice, prodsold, proddiscount) VALUES (160103, 16, 10009, '치닝디핑 33BR 철봉', 32, 120000, 28, 0);

-- ■ 주문 (Orders) 테이블■■■■■■■■■■■■■■■■■■■■■■■■■■
INSERT INTO orders (orderno, userid, ordertotalprice, orderaddress, orderstatus, orderdate) VALUES ('22010210001', 'user2', 52300, '서울시 마포구 121', 1, TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO orders (orderno, userid, ordertotalprice, orderaddress, orderstatus, orderdate) VALUES ('22010210002', 'user3', 56700, '서울시 강남구 21-1', 1, TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO orders (orderno, userid, ordertotalprice, orderaddress, orderstatus, orderdate) VALUES ('22010210010', 'user4', 72200, '서울시 강서구 큰대로 38', 2, TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO orders (orderno, userid, ordertotalprice, orderaddress, orderstatus, orderdate) VALUES ('22010310001', 'user5', 127000, '경기도 광주시 초월로 21', 1, TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO orders (orderno, userid, ordertotalprice, orderaddress, orderstatus, orderdate) VALUES ('22010310100', 'user1', 120000, '경기도 수원시 120번지', 0, TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO orders (orderno, userid, ordertotalprice, orderaddress, orderstatus, orderdate) VALUES ('22010410101', 'user6', 792000, '부산시 남구 21-1', 2, TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO orders (orderno, userid, ordertotalprice, orderaddress, orderstatus, orderdate) VALUES ('22010510021', 'user7', 92200, '부산시 부산진구 56 10층', 4, TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO orders (orderno, userid, ordertotalprice, orderaddress, orderstatus, orderdate) VALUES ('22010510027', 'user8', 112000, '대구시 팔달로 19', 3, TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO orders (orderno, userid, ordertotalprice, orderaddress, orderstatus, orderdate) VALUES ('22010510031', 'user10', 792000, '대전시 한밭로 24-1', 2, TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO orders (orderno, userid, ordertotalprice, orderaddress, orderstatus, orderdate) VALUES ('22010710110', 'user9', 94500, '광주시 충열로 11', 1, TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));

-- ■주문상품상세 (OrdersItem) 테이블■■■■■■■■■■■■■■■■■■■■■■■■■■
INSERT INTO ordersitem (orderno, prodno, itemprice, itemdiscount, itemcount) VALUES ('22010210001', 100110, 38000, 15, 1);
INSERT INTO ordersitem (orderno, prodno, itemprice, itemdiscount, itemcount) VALUES ('22010210001', 100101, 25000, 20, 1);
INSERT INTO ordersitem (orderno, prodno, itemprice, itemdiscount, itemcount) VALUES ('22010210002', 120103, 21000, 10, 3);
INSERT INTO ordersitem (orderno, prodno, itemprice, itemdiscount, itemcount) VALUES ('22010310001', 130112, 15000, 0, 1);
INSERT INTO ordersitem (orderno, prodno, itemprice, itemdiscount, itemcount) VALUES ('22010310001', 130101, 56000, 0, 2);
INSERT INTO ordersitem (orderno, prodno, itemprice, itemdiscount, itemcount) VALUES ('22010210010', 110101, 76000, 5, 1);
INSERT INTO ordersitem (orderno, prodno, itemprice, itemdiscount, itemcount) VALUES ('22010310100', 160103, 120000, 0, 1);
INSERT INTO ordersitem (orderno, prodno, itemprice, itemdiscount, itemcount) VALUES ('22010410101', 170115, 900000, 12, 1);
INSERT INTO ordersitem (orderno, prodno, itemprice, itemdiscount, itemcount) VALUES ('22010510021', 110101, 76000, 5, 1);
INSERT INTO ordersitem (orderno, prodno, itemprice, itemdiscount, itemcount) VALUES ('22010510027', 130101, 56000, 0, 2);
INSERT INTO ordersitem (orderno, prodno, itemprice, itemdiscount, itemcount) VALUES ('22010510021', 100101, 25000, 20, 1);
INSERT INTO ordersitem (orderno, prodno, itemprice, itemdiscount, itemcount) VALUES ('22010510031', 170115, 900000, 12, 1);
INSERT INTO ordersitem (orderno, prodno, itemprice, itemdiscount, itemcount) VALUES ('22010710110', 120103, 21000, 10, 5);


/*DROP SEQUENCE cart_cartno_seq;
CREATE SEQUENCE cart_cartno_seq
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE
  NOCYCLE
  NOCACHE;*/
-- ■장바구니 (Cart) 테이블■■■■■■■■■■■■■■■■■■■■■■■■■■
INSERT INTO cart (userid, prodno, cartprodcount, cartproddate) VALUES ('user1', 100101, 1, TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO cart (userid, prodno, cartprodcount, cartproddate) VALUES ('user1', 100110, 2, TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO cart (userid, prodno, cartprodcount, cartproddate) VALUES ('user3', 120103, 1, TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO cart (userid, prodno, cartprodcount, cartproddate) VALUES ('user4', 130112, 1, TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO cart (userid, prodno, cartprodcount, cartproddate) VALUES ('user5', 130101, 1, TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO cart (userid, prodno, cartprodcount, cartproddate) VALUES ('user2', 110101, 3, TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO cart (userid, prodno, cartprodcount, cartproddate) VALUES ('user2', 160103, 1, TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO cart (userid, prodno, cartprodcount, cartproddate) VALUES ('user2', 170115, 1, TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO cart (userid, prodno, cartprodcount, cartproddate) VALUES ('user3', 110101, 1, TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO cart (userid, prodno, cartprodcount, cartproddate) VALUES ('user6', 130101, 1, TO_DATE('2022-01-10 10:50:12', 'YYYY-MM-DD HH24:MI:SS'));



-- ■5. SQL ■■■■■■■■■■■■■■■■■■■■■■■

--문제1. 모든 장바구니 내역에서 고객명, 상품명, 상품수량을 조회하시오. 
--단 상품수량 2건이상만 조회 할 것
SELECT U.NAME, P.PRODNAME, C.CARTPRODCOUNT
    FROM CART C
    JOIN "User" U ON C.USERID = U.USERID
    JOIN PRODUCT P ON C.PRODNO = P.PRODNO
    WHERE C.CARTPRODCOUNT >= 2
;


--문제2. 모든 상품내역에서 
--상품번호, 상품카테고리명, 상품명, 상품가격, 판매자이름, 판매자 연락처를 조회
SELECT P.PRODNO, C.CATENAME, P.PRODNAME, S.MANAGER, S.TEL
    FROM PRODUCT P
    JOIN CATEGORY C ON P.CATENO = C.CATENO
    JOIN SELLER S ON P.SELLERNO = S.SELLERNO;


--문제3. 모든 고객의 아이디, 이름, 휴대폰, 현재포인트, 적립포인트 총합을 조회하시오.
--단 적립포인트 내역이 없으면 0으로 출력
SELECT U.USERID, U.NAME, U.HP, U.POINT, COALESCE(SUM(P.POINT), 0)
    FROM "User" U
    LEFT JOIN POINT P ON U.USERID = P.USERID
    GROUP BY U.USERID, U.NAME, U.HP, U.POINT
;



--문제4. 모든 주문의 주문번호, 주문자 아이디, 고객명, 주문가격, 주문일자를 조회하시오. 단 주문금액에 10만원 이상, 큰 금액순으로 조회, 금액이 같으면 이름이 사전순으로 될것
SELECT O.ORDERNO, U.USERID, U.NAME, orderTotalPrice, O.ORDERDATE
    FROM ORDERS O
    JOIN "User" U ON O.USERID = U.USERID;



--문제5. 모든 주문의 주문번호, 주문자 아이디, 고객명, 상품명, 주문일자를 조회하시오. 
--주문번호는 중복 없이 상품명은 구분자 ,로 나열할것
SELECT O.ORDERNO, U.USERID, U.NAME, LISTAGG(P.PRODNAME, ', '), O.ORDERDATE
    FROM ORDERS O
    JOIN "User" U ON O.USERID = U.USERID
    JOIN ORDERSITEM OI ON O.ORDERNO = OI.ORDERNO
    JOIN PRODUCT P ON OI.PRODNO = P.PRODNO
    GROUP BY O.ORDERNO, U.USERID, U.NAME, O.ORDERDATE;




--문제6. 모든 상품의 상품번호, 상품명, 상품가격, 할인율, 할인된 가격을 조회하시오. 
SELECT PRODNO, PRODNAME, PRODPRICE, PRODDISCOUNT,(PRODPRICE - (PRODPRICE * PRODDISCOUNT / 100)) AS "가격"
    FROM PRODUCT
    ;



--문제7. 고소영이 판매하는 모든 상품의 
--상품번호, 상품명, 상품가격, 재고수량, 판매자이름을 조회하시오. 
SELECT P.PRODNO, P.PRODNAME, P.PRODPRICE, P.PRODSTOCK, S.MANAGER
    FROM SELLER S
    JOIN PRODUCT P ON S.SELLERNO = P.SELLERNO
    WHERE S.MANAGER = '고소영'
;
    



--문제8. 아직 상품을 판매하지 않은 판매자의 
--판매자번호, 판매자상호, 판매자 이름, 판매자 연락처를 조회하시오. 
SELECT S.SELLERNO, S.COMPANY, S.MANAGER, S.TEL
    FROM SELLER S
    LEFT JOIN PRODUCT P ON S.SELLERNO = P.SELLERNO
    WHERE P.SELLERNO IS NULL
    ;





--문제9. 모든 주문상세내역 중 
--개별 상품 가격과 개수 그리고 할인율이 적용된 가격을 구하고
--그 가격으로 주문별 총합을 구해서 
--주문별 총합이 10만원이상 그리고 큰 금액 순으로 
--`주문번호`, `최종총합`을 조회하시오. 
SELECT ORDERNO AS "주문번호", SUM((ITEMPRICE - (ITEMPRICE * ITEMDISCOUNT / 100))*ITEMCOUNT) AS "최종총합" 
    FROM ORDERSITEM
    GROUP BY ORDERNO
    HAVING SUM((ITEMPRICE - (ITEMPRICE * ITEMDISCOUNT / 100))*ITEMCOUNT) >= 100000
    ORDER BY "최종총합" DESC
;



--문제10. 장보고 고객이 주문했던 모든 상품명을 `고객명`, `상품명`으로 조회하시오.
--단 상품명은 중복 안됨, 상품명은 구분자 , 로 나열
SELECT U.NAME AS "고객명",
  LISTAGG(P.PRODNAME, ', ') WITHIN GROUP (ORDER BY P.PRODNAME) AS "상품명"
    FROM "User" U
    JOIN ORDERS O ON U.USERID = O.USERID
    JOIN ORDERSITEM OI ON O.ORDERNO = OI.ORDERNO
    JOIN PRODUCT P ON OI.PRODNO = P.PRODNO
    WHERE U.NAME = '장보고'
    GROUP BY U.NAME;
-- ■■■■■■■■■■■■■■■■■■■■■■■■■■■■
-- ■■■■■■■■■■■■■■■■■■■■■■■■■■■■

