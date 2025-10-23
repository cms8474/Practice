-- 0-1. (옵션)root system 로그인 연결 & 사용자 추가
/*CREATE USER 'team2'@'%' IDENTIFIED BY 'abc1234!';
GRANT ALL PRIVILEGES ON team2.* TO 'team2'@'%';
FLUSH PRIVILEGES;
*/

-- 0-2. (필수)DB스키마 생성
CREATE DATABASE team2 CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE team2;


-- =================================================================
-- 1. 통합 사용자 (USERS)
-- 학생, 교수의 공통 정보를 관리
-- =================================================================
CREATE TABLE USERS (
    id VARCHAR(20) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(50) NOT NULL,
    ename VARCHAR(100),
    ssn VARCHAR(14) NOT NULL UNIQUE,
    gender VARCHAR(10) CHECK (gender IN ('male', 'female')),
    country VARCHAR(50),
    phone VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    address VARCHAR(255),
    role VARCHAR(10) NOT NULL CHECK (role IN ('student', 'professor'))
);

-- =================================================================
-- 2. 단과대학 (COLLEGES)
-- 학과들의 상위 그룹 정보
-- =================================================================
CREATE TABLE COLLEGES (
    cid INT PRIMARY KEY,
    c_name VARCHAR(100) NOT NULL UNIQUE,
    c_ename VARCHAR(100),
    college_title VARCHAR(255),
    college_content LONGTEXT,
    image_url VARCHAR(255)
);

-- =================================================================
-- 3. 학과 (DEPARTMENTS)
-- 단과대학(COLLEGES)에 소속되며, 학과장(USERS) 정보를 참조
-- =================================================================
CREATE TABLE DEPARTMENTS (
    did INT PRIMARY KEY,
    cid INT NOT NULL,
    dname VARCHAR(100) NOT NULL,
    d_ename VARCHAR(100),
    estb_date DATE,
    head_pid VARCHAR(20),
    office_phone VARCHAR(20),
    office_location VARCHAR(100),
    CONSTRAINT fk_departments_colleges FOREIGN KEY (cid) REFERENCES COLLEGES(cid),
    CONSTRAINT fk_departments_users FOREIGN KEY (head_pid) REFERENCES USERS(id)
);

-- =================================================================
-- 4. 학생 상세정보 (STUDENTS)
-- USERS 테이블과 1:1 관계, 학생의 상세 학적 정보
-- =================================================================
CREATE TABLE STUDENTS (
    s_id VARCHAR(20) PRIMARY KEY,
    department_id INT NOT NULL,
    advisor_id VARCHAR(20),
    entry_year INT(4),
    entry_type VARCHAR(10) CHECK (entry_type IN ('수시', '정시')),
    current_year INT(1),
    current_semester INT(1),
    status VARCHAR(10) CHECK (status IN ('재학', '휴학', '졸업')),
    graduate_year INT(4),
    CONSTRAINT fk_students_users FOREIGN KEY (s_id) REFERENCES USERS(id),
    CONSTRAINT fk_students_departments FOREIGN KEY (department_id) REFERENCES DEPARTMENTS(did),
    CONSTRAINT fk_students_advisor FOREIGN KEY (advisor_id) REFERENCES USERS(id)
);

-- =================================================================
-- 5. 교수 상세정보 (PROFESSORS)
-- USERS 테이블과 1:1 관계, 교수의 상세 정보
-- =================================================================
CREATE TABLE PROFESSORS (
    p_id VARCHAR(20) PRIMARY KEY,
    department_id INT NOT NULL,
    lab_location VARCHAR(100),
    degree VARCHAR(50),
    major VARCHAR(100),
    hire_date DATE,
    status VARCHAR(10) CHECK (status IN ('재직', '휴직', '퇴직')),
    CONSTRAINT fk_professors_users FOREIGN KEY (p_id) REFERENCES USERS(id),
    CONSTRAINT fk_professors_departments FOREIGN KEY (department_id) REFERENCES DEPARTMENTS(did)
);

-- =================================================================
-- 6. 강의 (COURSES)
-- 개설학과(DEPARTMENTS)와 담당교수(USERS) 정보를 참조
-- =================================================================
CREATE TABLE COURSES (
    course_id INT(7) PRIMARY KEY,
    did INT NOT NULL,
    pid VARCHAR(20) NOT NULL,
    course_name VARCHAR(100) NOT NULL,
    course_description VARCHAR(2000),
    year INT(4) NOT NULL,
    semester INT(1) NOT NULL,
    course_start_date DATE,
    course_end_date DATE,
    course_start_time VARCHAR(5),
    course_end_time VARCHAR(5),
    course_day VARCHAR(10),
    location VARCHAR(100),
    type VARCHAR(20) NOT NULL CHECK (type IN ('전공선택', '자유선택', '전공필수', '필수교양')),
    credit DECIMAL(2,1) NOT NULL,
    max_capacity INT(3) NOT NULL,
    CONSTRAINT fk_courses_departments FOREIGN KEY (did) REFERENCES DEPARTMENTS(did),
    CONSTRAINT fk_courses_users FOREIGN KEY (pid) REFERENCES USERS(id),
    CONSTRAINT chk_course_id CHECK (course_id BETWEEN 1000000 AND 9999999)
);

-- =================================================================
-- 7. 수강 내역 (ENROLLMENTS)
-- 학생(USERS)과 강의(COURSES)의 N:M 관계를 연결
-- =================================================================
CREATE TABLE ENROLLMENTS (
    eid INT PRIMARY KEY,
    sid VARCHAR(20) NOT NULL,
    course_id INT(7) NOT NULL,
    enroll_date DATE DEFAULT (CURRENT_DATE),
    grade VARCHAR(2),
    CONSTRAINT fk_enrollments_users FOREIGN KEY (sid) REFERENCES USERS(id),
    CONSTRAINT fk_enrollments_courses FOREIGN KEY (course_id) REFERENCES COURSES(course_id),
    CONSTRAINT uq_student_course UNIQUE (sid, course_id)
);

-- 수강 내역(ENROLLMENTS) PK용 시퀀스 생성
CREATE TABLE enrollments (
    enrollment_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    course_id INT
);

-- =================================================================
-- 8. 게시판 종류 (BOARDS)
-- 게시판의 종류와 권한 등 메타 정보를 관리
-- =================================================================
CREATE TABLE BOARDS (
    board_id VARCHAR(50) PRIMARY KEY,
    board_name VARCHAR(100) NOT NULL,
    description VARCHAR(500),
    read_permission VARCHAR(20) DEFAULT 'all',
    write_permission VARCHAR(20) DEFAULT 'student'
);

-- =================================================================
-- 9. 게시글 (POSTS)
-- 실제 게시글 데이터를 저장, 게시판(BOARDS)과 작성자(USERS) 정보를 참조
-- =================================================================
CREATE TABLE POSTS (
    post_id INT PRIMARY KEY,
    board_id VARCHAR(50) NOT NULL,
    author_id VARCHAR(20) NOT NULL,
    title VARCHAR(255) NOT NULL,
    content LONGTEXT,
    created_date DATE DEFAULT (CURRENT_DATE),
    updated_date DATE,
    view_count INT DEFAULT 0 NOT NULL,
    status VARCHAR(20),
    CONSTRAINT fk_posts_boards FOREIGN KEY (board_id) REFERENCES BOARDS(board_id),
    CONSTRAINT fk_posts_users FOREIGN KEY (author_id) REFERENCES USERS(id)
);

-- 게시글(POSTS) PK용 시퀀스 생성
CREATE TABLE posts (
    post_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    content TEXT
);