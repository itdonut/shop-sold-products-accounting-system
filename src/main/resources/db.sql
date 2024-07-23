create table user(
    id int not null unique auto_increment,
    login varchar(20) not null unique,
    password varchar(20) not null,
    role enum("USER", "ADMIN") not null
);

create table product(
    id int not null unique auto_increment,
    title varchar(127) not null unique,
    price double not null
);

-- price can be computing while inserting by backend
create table orders(
    id int not null unique auto_increment,
    product_id int not null,
    price double not null,
    amount double not null,
    date_time datetime not null,
    foreign key (product_id) references product (id)
);