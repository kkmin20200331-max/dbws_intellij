create table movie_test(
    m_no number(3) primary key,
    m_title varchar2(30 char) not null,
    m_actor varchar2(30 char) not null,
    m_img varchar2(200 char) not null,
    m_story varchar2(500 char) not null


);

create sequence  movie_test_seq;

insert into movie_test values (movie_test_seq.nextval,'전우치','강동원','jwc.jpg','도사와 요괴이야기! 십이지신을 모티브로한 요괴들 등장!');
insert into movie_test values (movie_test_seq.nextval,'매트릭스','키아누','metrix.jpg','가상세계이야기!');
insert into movie_test values (movie_test_seq.nextval, '기생충', '송강호', 'parasite.jpg', '두 가족의 만남이 걷잡을 수 없는 사건으로 번지는 이야기');
insert into movie_test values (movie_test_seq.nextval, '인셉션', '디카프리오', 'inception.jpg', '타인의 꿈에 들어가 생각을 심는 거대한 작전');
insert into movie_test values (movie_test_seq.nextval, '범죄도시', '마동석', 'outlaws.jpg', '괴물형사의 통쾌한 범죄 소탕 작전!');
insert into movie_test values (movie_test_seq.nextval, '인터스텔라', '매튜맥커너히', 'interstellar.jpg', '우주로 떠난 아버지와 가족을 기다리는 딸의 시공간 초월 이야기');
insert into movie_test values (movie_test_seq.nextval, '올드보이', '최민식', 'oldboy.jpg', '15년 동안 갇혀있던 남자의 복수와 충격적인 진실');
insert into movie_test values (movie_test_seq.nextval, '어벤져스', '로버트다우니', 'avengers.jpg', '지구를 지키기 위해 모인 슈퍼히어로들의 연합군');
insert into movie_test values (movie_test_seq.nextval, '타짜', '조승우', 'tazza.jpg', '도박판에 인생을 건 타짜들의 치밀한 심리전');
insert into movie_test values (movie_test_seq.nextval, '조커', '호아킨피닉스', 'joker.jpg', '고독한 광대가 악당 조커로 변해가는 과정을 그린 영화');
insert into movie_test values (movie_test_seq.nextval, '신과함께', '하정우', 'alongwithgod.jpg', '죽음 이후 49일 동안 벌어지는 7번의 재판 이야기');
insert into movie_test values (movie_test_seq.nextval, '라라랜드', '라이언고슬링', 'lalaland.jpg', '꿈을 쫓는 두 남녀의 마법 같은 사랑과 현실 이야기');

select * from movie_test;