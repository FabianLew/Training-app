create table Exercise (
    id varchar(4) not null,
    name varchar(30) not null,
    muscle_part varchar(30) not null
);

create table Training(
    id identity,
    date timestamp not null,
    comment varchar(100)
);

create table Training_Exercises(
    training_id bigint not null,
    exercises_id varchar(4) not null
);

alter table Training_Exercises
    add foreign key (training_id) references Training(id);
alter table Training_Exercises
    add foreign key (exercises_id) references Exercise(id);

-- create table users(
--     username varchar_ignorecase(50) not null primary key,
--     password varchar_ignorecase(50) not null,
--     enabled boolean not null
-- );
--
-- create table authorities (
--     username varchar_ignorecase(50) not null,
--     authority varchar_ignorecase(50) not null,
--     constraint fk_authorities_users foreign key(username) references users(username)
-- );
-- create unique index ix_auth_username on authorities (username,authority);
