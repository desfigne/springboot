/** 데이터베이스 생성 */
create database shoppy;
/* > 컨트롤 엔터

/** 데이터베이스 열기 */
use shoppy;
select database();

/** member 테이블 생성 */
create table member(
	id	varchar(50) primary key,
	pwd	varchar(50) not null,
	name	varchar(50) not null,
	phone	char(13),
	email	varchar(50) not null,
	mdate	date
);
show tables;
desc member;

SELECT * FROM member;
SELECT count(id) from member where id='test';
SELECT count(*) from member where id='test' and pwd='1234';