-- create database mybatis;

create table subscriber
(
    id         integer primary key,
    name       varchar(255) not null,
    ref_tariff varchar(10)  not null
);

create table tariff
(
    id    integer primary key,
    descr varchar(255) not null
);

create table payment
(
    id             integer primary key,
    ref_subscriber integer not null,
    summa          integer not null
);