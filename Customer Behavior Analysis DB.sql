create database cba_;
use cba_;

create database cba;
use cba;


show tables;
drop database cba;

CREATE TABLE customer (
    cid INT PRIMARY KEY,
    cat VARCHAR(5) NOT NULL,
    cname VARCHAR(300) NOT NULL,
    location VARCHAR(50) NOT NULL
);

INSERT INTO customer VALUES(101,'cat1','Harsha','Banglore');
INSERT INTO customer VALUES(102,'cat2','Shwetha','Mysore');
INSERT INTO customer VALUES(103,'cat3','Sangamesh','Chennai');
INSERT INTO customer VALUES(104,'cat4','Swathi','Pune');
INSERT INTO customer VALUES(105,'cat1','Manasa','Banglore');
INSERT INTO customer VALUES(106,'cat2','Sampritha','Banglore');
INSERT INTO customer VALUES(107,'cat3','Raghu','Mysore');
INSERT INTO customer VALUES(108,'cat4','Reshma','Pune');
INSERT INTO customer VALUES(109,'cat1','Adya','Chennai');
INSERT INTO customer VALUES(110,'cat2','Adarsh','Banglore');
INSERT INTO customer VALUES(111,'cat3','Chaithra','Mysore');
INSERT INTO customer VALUES(112,'cat4','Induja','Mysore');
INSERT INTO customer VALUES(113,'cat1','Srikanth','Chennai');
INSERT INTO customer VALUES(114,'cat2','Samhitha','Pune');
INSERT INTO customer VALUES(115,'cat3','Pruthvi','Pune');

select * from customer;
drop table customer;

CREATE TABLE product (
    pid INT PRIMARY KEY,
    pname VARCHAR(500) NOT NULL,
    category VARCHAR(100) NOT NULL,
    brand VARCHAR(500) NOT NULL,
    descr VARCHAR(2000),
    price DOUBLE NOT NULL,
    stock INT NOT NULL
);

INSERT INTO product VALUES(1111,'Coffee powder','Food & Beverages','Nescafe','Good',74.69,50);
INSERT INTO product VALUES(1112,'Shirt','Home & LifeStyle','Mayur Fashions','Good',46.33,5);
INSERT INTO product VALUES(1113,'Tea Powder','Food & Beverages','TajMahal','Good',58.22,10);
INSERT INTO product VALUES(1114,'Fareness Cream','Health & Beauty','Lakme','Good',86.31,30);
INSERT INTO product VALUES(1115,'Shoes','Home & LifeStyle','Bata','Average',85.39,5);
INSERT INTO product VALUES(1116,'Watch','Accessories','Sonata','Good',68.84,50);
INSERT INTO product VALUES(1117,'Watch','Accessories','Titan','Average',73.56,10);
INSERT INTO product VALUES(1118,'pen','Home & LifeStyle','fusion','Good',36.26,5);
INSERT INTO product VALUES(1119,'Salt','Food & Beverages','Tata','Good',54.84,50);
INSERT INTO product VALUES(1120,'Necklace','Accessories','STL accessories','Good',25.51,5);
INSERT INTO product VALUES(1121,'Shoes','Home & LifeStyle','Paragan','Average',46.95,50);
INSERT INTO product VALUES(1122,'Coffee Powder','Food & Beverages','Bru','Good',71.38,20);
INSERT INTO product VALUES(1123,'Coffee Powder','Food & Beverages','Cothas','Average',93.72,5);
INSERT INTO product VALUES(1124,'oil','Food & Beverages','SunPure','Good',68.93,50);
INSERT INTO product VALUES(1125,'pen','Home & LifeStyle','Pavithra brite','Average',72.61,5);

select * from product;
drop table invoice;

CREATE TABLE invoice (
    iid INT PRIMARY KEY,
    idate DATETIME NOT NULL,
    cid INT REFERENCES customer (cid),
    tax DOUBLE NOT NULL,
    tprice DOUBLE NOT NULL,
    paymode VARCHAR(50) NOT NULL
);

INSERT INTO invoice VALUES(201,'2019-07-02 10:25:00',101,26.1415,548.9715,'Debitcard');
INSERT INTO invoice VALUES(202,'2019-03-03 13:23:00',115,16.2155,340.5255,'Cash');
INSERT INTO invoice VALUES(203,'2019-01-27 20:33:00',101,23.288,489.048,'Creditcard');
INSERT INTO invoice VALUES(204,'2019-02-08 10:37:00',101,30.2085,634.3785,'Debitcard');
INSERT INTO invoice VALUES(205,'2019-03-25 18:30:00',107,29.8865,627.6165,'Cash');
INSERT INTO invoice VALUES(206,'2019-02-25 14:36:00',112,20.652,433.692,'Debitcard');
INSERT INTO invoice VALUES(207,'2019-07-24 11:38:00',111,36.78,772.38,'Creditcard');
INSERT INTO invoice VALUES(208,'2019-01-10 17:15:00',109,3.626,76.146,'Debitcard');
INSERT INTO invoice VALUES(209,'2019-02-20 13:27:00',109,8.226,172.746,'Cash');
INSERT INTO invoice VALUES(210,'2019-03-09 17:03:00',112,5.102,107.142,'Debitcard');
INSERT INTO invoice VALUES(211,'2019-07-12 10:25:00',109,11.7375,246.4875,'Debitcard');
INSERT INTO invoice VALUES(212,'2019-07-02 16:48:00',103,21.595,453.495,'Creditcard');
INSERT INTO invoice VALUES(213,'2019-03-29 19:21:00',104,35.69,749.49,'Debitcard');
INSERT INTO invoice VALUES(214,'2019-01-15 16:19:00',105,28.116,590.436,'Creditcard');
INSERT INTO invoice VALUES(215,'2019-05-20 11:03:00',106,24.1255,506.6355,'Cash');
INSERT INTO invoice VALUES(216,'2019-07-02 11:25:00',101,26.1415,548.9715,'Debitcard');
INSERT INTO invoice VALUES(217,'2019-03-03 12:23:00',115,16.2155,340.5255,'Cash');
INSERT INTO invoice VALUES(218,'2019-01-27 21:33:00',101,23.288,489.048,'Creditcard');
INSERT INTO invoice VALUES(219,'2019-02-08 11:37:00',101,30.2085,634.3785,'Debitcard');
INSERT INTO invoice VALUES(220,'2019-03-25 16:30:00',107,29.8865,627.6165,'Cash');
INSERT INTO invoice VALUES(221,'2019-02-25 15:36:00',112,20.652,433.692,'Debitcard');
INSERT INTO invoice VALUES(222,'2019-07-24 12:38:00',111,36.78,772.38,'Creditcard');
INSERT INTO invoice VALUES(223,'2019-01-10 18:15:00',109,3.626,76.146,'Debitcard');
INSERT INTO invoice VALUES(224,'2019-02-20 14:27:00',109,8.226,172.746,'Cash');
INSERT INTO invoice VALUES(225,'2019-03-09 11:03:00',112,5.102,107.142,'Debitcard');
INSERT INTO invoice VALUES(226,'2019-07-12 10:02:00',109,11.7375,246.4875,'Debitcard');
INSERT INTO invoice VALUES(227,'2019-07-02 16:01:00',103,21.595,453.495,'Creditcard');
INSERT INTO invoice VALUES(228,'2019-03-29 19:04:00',104,35.69,749.49,'Debitcard');
INSERT INTO invoice VALUES(229,'2019-01-15 16:11:00',105,28.116,590.436,'Creditcard');
INSERT INTO invoice VALUES(230,'2019-05-20 12:13:00',106,24.1255,506.6355,'Cash');
INSERT INTO invoice VALUES(231,'2019-07-02 10:20:00',101,26.1415,548.9715,'Debitcard');
INSERT INTO invoice VALUES(232,'2019-03-03 13:25:00',115,16.2155,340.5255,'Cash');
INSERT INTO invoice VALUES(233,'2019-01-27 20:30:00',101,23.288,489.048,'Creditcard');
INSERT INTO invoice VALUES(234,'2019-02-08 10:33:00',101,30.2085,634.3785,'Debitcard');
INSERT INTO invoice VALUES(235,'2019-03-25 12:30:00',107,29.8865,627.6165,'Cash');
INSERT INTO invoice VALUES(236,'2019-02-25 14:35:00',112,20.652,433.692,'Debitcard');
INSERT INTO invoice VALUES(237,'2019-07-24 11:36:00',111,36.78,772.38,'Creditcard');
INSERT INTO invoice VALUES(238,'2019-01-10 17:10:00',109,3.626,76.146,'Debitcard');
INSERT INTO invoice VALUES(239,'2019-02-20 13:28:00',109,8.226,172.746,'Cash');
INSERT INTO invoice VALUES(240,'2019-03-09 17:13:00',112,5.102,107.142,'Debitcard');
INSERT INTO invoice VALUES(241,'2019-07-12 10:15:00',109,11.7375,246.4875,'Debitcard');
INSERT INTO invoice VALUES(242,'2019-07-03 16:18:00',103,21.595,453.495,'Creditcard');
INSERT INTO invoice VALUES(243,'2019-03-29 19:22:00',104,35.69,749.49,'Debitcard');
INSERT INTO invoice VALUES(244,'2019-01-25 16:15:00',105,28.116,590.436,'Creditcard');
INSERT INTO invoice VALUES(245,'2019-05-20 11:13:00',106,24.1255,506.6355,'Cash');
INSERT INTO invoice VALUES(246,'2019-07-02 10:21:00',101,26.1415,548.9715,'Debitcard');
INSERT INTO invoice VALUES(247,'2019-03-01 13:22:00',115,16.2155,340.5255,'Cash');
INSERT INTO invoice VALUES(248,'2019-01-28 20:35:00',101,23.288,489.048,'Creditcard');
INSERT INTO invoice VALUES(249,'2019-02-09 10:37:00',101,30.2085,634.3785,'Debitcard');
INSERT INTO invoice VALUES(250,'2019-03-26 18:30:00',107,29.8865,627.6165,'Cash');

select * from invoice;
drop table invoice;

CREATE TABLE invoice_product (
    iid INT NOT NULL REFERENCES invoice (iid),
    pid INT NOT NULL REFERENCES product (pid),
    PRIMARY KEY (iid , pid),
    qty INT NOT NULL
);

INSERT INTO invoice_product VALUES(201,1111,7);
INSERT INTO invoice_product VALUES(202,1112,7);
INSERT INTO invoice_product VALUES(203,1113,8);
INSERT INTO invoice_product VALUES(204,1114,7);
INSERT INTO invoice_product VALUES(205,1115,7);
INSERT INTO invoice_product VALUES(206,1116,6);
INSERT INTO invoice_product VALUES(207,1117,10);
INSERT INTO invoice_product VALUES(208,1118,2);
INSERT INTO invoice_product VALUES(209,1119,3);
INSERT INTO invoice_product VALUES(210,1120,4);
INSERT INTO invoice_product VALUES(211,1121,5);
INSERT INTO invoice_product VALUES(212,1122,10);
INSERT INTO invoice_product VALUES(213,1123,10);
INSERT INTO invoice_product VALUES(214,1124,6);
INSERT INTO invoice_product VALUES(215,1125,7);
INSERT INTO invoice_product VALUES(216,1111,7);
INSERT INTO invoice_product VALUES(217,1112,7);
INSERT INTO invoice_product VALUES(218,1113,8);
INSERT INTO invoice_product VALUES(219,1114,7);
INSERT INTO invoice_product VALUES(220,1115,7);
INSERT INTO invoice_product VALUES(221,1116,6);
INSERT INTO invoice_product VALUES(222,1117,10);
INSERT INTO invoice_product VALUES(223,1118,2);
INSERT INTO invoice_product VALUES(224,1119,3);
INSERT INTO invoice_product VALUES(225,1120,4);
INSERT INTO invoice_product VALUES(226,1121,5);
INSERT INTO invoice_product VALUES(227,1122,10);
INSERT INTO invoice_product VALUES(228,1123,10);
INSERT INTO invoice_product VALUES(229,1124,6);
INSERT INTO invoice_product VALUES(230,1125,7);
INSERT INTO invoice_product VALUES(231,1111,7);
INSERT INTO invoice_product VALUES(232,1112,7);
INSERT INTO invoice_product VALUES(233,1113,8);
INSERT INTO invoice_product VALUES(234,1114,7);
INSERT INTO invoice_product VALUES(235,1115,7);
INSERT INTO invoice_product VALUES(236,1116,6);
INSERT INTO invoice_product VALUES(237,1117,10);
INSERT INTO invoice_product VALUES(238,1118,2);
INSERT INTO invoice_product VALUES(239,1119,3);
INSERT INTO invoice_product VALUES(240,1120,4);
INSERT INTO invoice_product VALUES(241,1121,5);
INSERT INTO invoice_product VALUES(242,1122,10);
INSERT INTO invoice_product VALUES(243,1123,10);
INSERT INTO invoice_product VALUES(244,1124,6);
INSERT INTO invoice_product VALUES(245,1125,7);
INSERT INTO invoice_product VALUES(246,1111,7);
INSERT INTO invoice_product VALUES(247,1112,7);
INSERT INTO invoice_product VALUES(248,1113,8);
INSERT INTO invoice_product VALUES(249,1114,7);
INSERT INTO invoice_product VALUES(250,1115,7);

select * from invoice_product;

CREATE TABLE discount (
    did INT PRIMARY KEY,
    dname VARCHAR(50) NOT NULL,
    descr VARCHAR(2000),
    dprice DOUBLE NOT NULL
);

INSERT INTO discount VALUES(1,'No Discount','Zero perc discount',0);
INSERT INTO discount VALUES(2,'Super 20perc','20 perc discount',0.20);
INSERT INTO discount VALUES(3,'Super 30perc','30 perc discount',0.30);
INSERT INTO discount VALUES(4,'Super 40perc','50 perc discount',0.50);

select * from discount;

CREATE TABLE product_discount (
    pid INT NOT NULL REFERENCES product (pid),
    did INT NOT NULL REFERENCES discount (did),
    PRIMARY KEY (pid , did)
);


INSERT INTO product_discount VALUES(1111,1);
INSERT INTO product_discount VALUES(1112,4);
INSERT INTO product_discount VALUES(1112,2);
INSERT INTO product_discount VALUES(1112,3);
INSERT INTO product_discount VALUES(1113,3);
INSERT INTO product_discount VALUES(1114,4);
INSERT INTO product_discount VALUES(1115,1);
INSERT INTO product_discount VALUES(1116,2);
INSERT INTO product_discount VALUES(1117,3);
INSERT INTO product_discount VALUES(1118,4);
INSERT INTO product_discount VALUES(1119,1);
INSERT INTO product_discount VALUES(1120,2);
INSERT INTO product_discount VALUES(1121,3);
INSERT INTO product_discount VALUES(1122,4);
INSERT INTO product_discount VALUES(1123,1);
INSERT INTO product_discount VALUES(1124,2);
INSERT INTO product_discount VALUES(1125,3);

select * from product_discount;