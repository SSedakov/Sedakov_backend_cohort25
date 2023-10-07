create table event
(
    id         bigserial primary key,
    event_name varchar(30),
    title  varchar(70)

);

insert into event(event_name, title)
values ('happy birthday','comming soon');
insert into event(event_name, title)
values ('finish education','November');
insert into event(event_name, title)
values ('new year','first of January');


create table area
(
    id       bigserial primary key,
    name_of_area    varchar(20),
    title    varchar(70),
    event_id bigint,
    foreign key (event_id) references event (id)
);

insert into area (name_of_area, title, event_id)
values ('forest','cold weather',1);
insert into area (name_of_area, title, event_id)
values ('home','Prepare gifts for everyone',3);