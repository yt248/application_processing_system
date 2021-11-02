drop table if exists applications;
drop table if exists users;

create table users
(
    id       bigint not null auto_increment,
    active   bit,
    name     varchar(255),
    password varchar(255),
    role     varchar(255),
    surname  varchar(255),
    username varchar(255),
    primary key (id)
) engine = InnoDB;


create table applications
(
    id                     bigint not null auto_increment,
    bid                    double precision,
    due_date               date,
    request                varchar(255),
    status                 integer,
    creator_application_id bigint,
    primary key (id)
#     foreign key (creator_application_id) references users (id)
) engine = InnoDB;

alter table applications
    add constraint foreign key (creator_application_id) references users (id)