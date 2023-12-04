create table catalog
(
    catalogId   bigint auto_increment
        primary key,
    catalogName varchar(50)  null,
    description varchar(100) null,
    createAt    datetime     null,
    status      bit          null
);

create table product
(
    productId   bigint auto_increment
        primary key,
    productName varchar(50)  null,
    categoryId  bigint       not null,
    description varchar(100) null,
    unitPrice   double       null,
    stock       int          null,
    createAt    datetime     null,
    updateAt    datetime     null,
    status      bit          null,
    constraint product_ibfk_1
        foreign key (categoryId) references catalog (catalogId)
);

create index categoryId
    on product (categoryId);

create table user
(
    userId      bigint auto_increment
        primary key,
    userName    varchar(50)      null,
    email       varchar(50)      null,
    fullName    varchar(50)      null,
    password    text             null,
    roll        bit default b'0' null,
    address     varchar(100)     null,
    phoneNumber varchar(15)      null,
    status      bit default b'1' null,
    createAt    datetime         null,
    updateAt    datetime         null,
    constraint email
        unique (email),
    constraint phoneNumber
        unique (phoneNumber)
);

create table `order`
(
    orderId     bigint auto_increment
        primary key,
    userId      bigint                                                       null,
    userName    varchar(50)                                                  null,
    phoneNumber varchar(15)                                                  not null,
    address     varchar(100)                                                 null,
    total       double                                                       null,
    status      enum ('WAITING', 'CONFIRM', 'DELIVERY', 'SUCCESS', 'CANCEL') null,
    orderAt     datetime                                                     null,
    deliverAt   datetime                                                     null,
    constraint order_ibfk_1
        foreign key (userId) references user (userId)
);

create index userId
    on `order` (userId);

create table orderdetail
(
    productId   bigint      null,
    orderId     bigint      null,
    productName varchar(50) null,
    unitPrice   double      null,
    quantity    int         null,
    constraint orderdetail_ibfk_1
        foreign key (productId) references product (productId),
    constraint orderdetail_ibfk_2
        foreign key (orderId) references `order` (orderId)
);

create index orderId
    on orderdetail (orderId);

create index productId
    on orderdetail (productId);

