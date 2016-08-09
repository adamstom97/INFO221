/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  adath325
 * Created: 9/08/2016
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