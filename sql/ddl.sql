drop table if exists member CASCADE;
create table member
( id bigint generated by default as identity,  --null 값이 들어오면 자동으로 해당하는 id 값을 생성해준다.
    name varchar(255),
  primary key (id)
);