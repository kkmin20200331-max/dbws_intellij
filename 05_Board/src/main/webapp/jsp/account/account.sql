create table login_test(
    l_id varchar2(30 char) primary key,
    l_pw varchar2(30 char) not null ,
    l_name varchar2(20 char) not null
);
insert into login_test values ('dm1004','dm1004','sdm');
insert into login_test values ('benr1004','benr1004','benr');
insert into login_test values ('dh1004','dh1004','jdh');
insert into login_test values ('mz1004','mz1004','lmz');

select * from login_test;