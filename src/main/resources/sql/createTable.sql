-- 식별번호 테이블 생성 
CREATE TABLE USERPIN (
	pinNo CHAR(36) PRIMARY KEY,
	nickName VARCHAR(16)
);

-- 식별번호 테이블 nickName 컬럼에 NOT NULL 제약조건 추가.
ALTER TABLE UserPin
MODIFY COLUMN nickName VARCHAR(16) NOT NULL;

-- 회원 테이블 생성 
CREATE TABLE USERS(
	userNo CHAR(36) PRIMARY KEY,
	pinNo CHAR(36),
	id VARCHAR(16) NOT NULL,
	password varchar(16) NOT NULL,
	email varchar(40),
	joinDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (pinNo) REFERENCES UserPin(pinNo)
);

-- 게시물 테이블 생성 
CREATE TABLE POST(
	postNo SERIAL PRIMARY KEY,
	pinNo CHAR(36) NOT NULL,
	title varchar(40) NOT NULL,
	content varchar(400),
	dueDate DATETIME NOT NULL,
	postDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (pinNo) REFERENCES USERPIN(pinNo)
);