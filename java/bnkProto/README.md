# GNK 그린은행 - 정적 웹사이트

Java + Spring을 활용한 금융 서비스 웹사이트의 정적 HTML 버전입니다.

## 🌿 프로젝트 개요

GNK 그린은행은 "여러분의 그린 뱅크"를 슬로건으로 하는 금융 서비스 웹사이트입니다.
부산은행 웹사이트를 참조하여 디자인된 정적 HTML 웹사이트입니다.

## 📁 프로젝트 구조

```
src/main/resources/static/
├── index.html                    # 메인 페이지
├── css/                           # 스타일시트
│   ├── common.css                # 공통 스타일
│   ├── header.css                # 헤더 스타일
│   ├── footer.css                # 푸터 스타일
│   └── main.css                  # 메인 페이지 스타일
├── js/                           # JavaScript
│   ├── include.js                # HTML include 유틸리티
│   └── common.js                 # 공통 JavaScript 함수
├── include/                      # 재사용 가능한 HTML
│   ├── header.html               # 헤더
│   └── footer.html               # 푸터
├── personal/                     # 개인뱅킹
│   ├── index.html                # 개인뱅킹 메인
│   ├── account.html              # 계좌조회
│   ├── transfer.html             # 이체
│   ├── deposit.html              # 예금/적금
│   └── loan.html                 # 대출
├── business/                     # 기업뱅킹
│   ├── index.html                # 기업뱅킹 메인
│   ├── account.html              # 계좌조회
│   ├── transfer.html             # 이체
│   ├── deposit.html              # 예금
│   └── loan.html                 # 대출
├── auth/                         # 인증
│   ├── login.html                # 로그인
│   └── register.html             # 회원가입
├── board/                        # 게시판
│   ├── notice.html               # 공지사항
│   ├── qna.html                # QnA
│   ├── event.html                # 이벤트
│   └── faq.html                  # FAQ
└── customer/                     # 고객 서비스
    ├── appointment.html          # 방문상담 예약
    └── center.html               # 고객센터
```

## 🎨 디자인 특징

- **주요 색상**: 파스텔톤 다홍색 (#FF6B9D) + 흰색
- **보조 색상**: 그린색 포인트 (#90D7B5)
- **디자인 컨셉**: 심플하고 조금 귀여운 이미지
- **참조 사이트**: 부산은행 (https://www.busanbank.co.kr/)

## 🛠️ 기술 스택

### Frontend
- HTML5
- CSS3
- JavaScript (Vanilla JS)
- 재사용 가능한 컴포넌트 구조 (include.js 활용)

### Backend
- Java 17
- Spring Boot 3.2.1
- Spring Web
- Spring Data JPA
- H2 Database (개발용)
- Lombok

## 📝 주요 기능

### 개인뱅킹
- 계좌조회
- 계좌이체
- 예금/적금 상품 안내
- 대출 상품 안내
- 방문상담 예약

### 기업뱅킹
- 기업 계좌조회
- 기업 이체 (급여이체, 대량이체)
- 기업 예금 상품
- 기업 대출 상품
- 방문상담 예약

### 게시판
- 공지사항
- QnA
- 이벤트
- FAQ

### 인증
- 로그인
- 회원가입
- 아이디/비밀번호 찾기

## 🚀 Spring Boot 애플리케이션 실행 방법

### 방법 1: Maven Wrapper 사용 (권장)

#### Windows
```bash
mvnw.cmd spring-boot:run
```

#### Mac/Linux
```bash
./mvnw spring-boot:run
```

### 방법 2: IDE에서 실행
1. IntelliJ IDEA 또는 Eclipse에서 프로젝트 열기
2. `src/main/java/com/gnk/bnkproto/BnkProtoApplication.java` 파일 열기
3. `main` 메서드 실행 (Run 버튼 클릭 또는 Shift+F10)

### 방법 3: 빌드 후 JAR 실행
```bash
# 1. Maven 빌드
mvnw.cmd clean package

# 2. JAR 파일 실행
java -jar target/bnkProto-0.0.1-SNAPSHOT.jar
```

### 접속 정보
실행 후 브라우저에서 접속:
- **메인 페이지**: http://localhost:8080
- **H2 데이터베이스 콘솔**: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:gnkdb`
  - Username: `sa`
  - Password: (비워두기)

## 🎯 향후 개발 계획

이 정적 HTML 파일을 기반으로 Spring Boot 백엔드를 연동하여:
- [ ] 실제 로그인/회원가입 기능
- [ ] 계좌 데이터베이스 연동
- [ ] 거래 내역 조회
- [ ] 게시판 CRUD 기능
- [ ] 이체 서비스 등

을 구현할 예정입니다.

## 📄 라이선스

이 프로젝트는 교육 목적으로 제작되었습니다.

