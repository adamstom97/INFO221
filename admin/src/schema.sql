/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The schema for setting up a new database for the project with sql
 * 
 * @author adath325
 * @version 3.0
 */
create table products (
    productID integer not null,
    name varchar not null,
    description varchar not null,
    category varchar not null,
    price decimal(4, 2) not null,
    quantity integer not null,
    constraint pk_products primary key (productID)
);

create table customers (
    userName varchar not null,
    name varchar not null,
    email varchar not null,
    address varchar not null,
    creditCardDetails varchar not null,
    password varchar not null,
    constraint pk_customers primary key (userName)
);