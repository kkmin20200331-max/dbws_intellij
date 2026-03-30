create table review_test(
    r_no number(3) primary key,
    r_title varchar2(50 char) not null,
    r_txt varchar2(300 char) not null,
    r_date date not null
);

create sequence review_test_seq;
insert into review_test values (review_test_seq.nextval,'title1','text1',to_date('2026/04/05'));
insert into review_test values (review_test_seq.nextval,'title2','text2',to_date('2026/04/02'));
insert into review_test values (review_test_seq.nextval,'title3','text3',to_date('2026/04/01'));

select * from review_test;