use shoppy;
select database();
show tables;
select * from member;
desc member;

-- pwd 사이즈 변경
alter table member modify column pwd varchar(100) not null;
select * from member;
desc member;

-- MySQL은 수정, 삭제 시 update mode를 변경
SET SQL_SAFE_UPDATES = 0;

delete from member
where mdate = '2015-10-17';

delete from emeber
where id = 'test222';

select pass as pwd from member where id='hong';
select count(*) as pwd from member where id='hong';

select * from member;

/***********************************
	상품 테이블 생성 : product
    
************************************/
create table product(
	pid 	int auto_increment primary key,
    name 	varchar(200) not null,
    price 	long,
    info 	varchar(200),
    rate 	double,
    image 	varchar(100),
    imgList json
);
desc product;
select * from product;
insert into product(name, price, info, rate, image, imgList) 
values
('후드티', 15000, '분홍색 후드티', 4.2, '1.webp', JSON_Array('1.webp', '1.webp', '1.webp')),
('후드티', 25000, '검정색 후드티', 2.2, '2.webp', JSON_Array('2.webp', '2.webp', '2.webp')),
('원피스', 34000, '파란색 원피스', 3.1, '3.webp', JSON_Array('3.webp', '3.webp', '3.webp')),
('반바지', 11000, '그레이색 반바지', 1.6, '4.webp', JSON_Array('4.webp', '4.webp', '4.webp')),
('가디건', 19000, '초록색 가디건', 5.0, '5.webp', JSON_Array('5.webp', '5.webp', '5.webp')),
('자켓', 19000, '자켓', 4.8, '6.webp', JSON_Array('6.webp', '6.webp', '6.webp'));

select * from product;