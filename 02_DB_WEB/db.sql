create table member_test(
    m_no number(3) primary key,
    m_name varchar2(20 char) not null,
    m_age number(3) not null
);

create sequence member_test_seq;

insert into member_test values (member_test_seq.nextval,'member1',10);
insert into member_test values (member_test_seq.nextval,'member2',20);
insert into member_test values (member_test_seq.nextval,'member3',30);

select * from member_test;