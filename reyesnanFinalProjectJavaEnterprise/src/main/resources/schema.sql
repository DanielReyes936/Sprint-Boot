CREATE TABLE product(

productId LONG PRIMARY KEY AUTO_INCREMENT,
nameProduct VARCHAR (200),
description VARCHAR (200),
price int (40)
);

insert into product (productId,nameProduct,description,price)
values(1,'ONION','ORGANIC',1);
insert into product (productId,nameProduct,description,price)
values(2,'BANANA','ORGANIC',1);
insert into product (productId,nameProduct,description,price)
values(3,'RASPBERRY','ORGANIC',3);
insert into product (productId,nameProduct,description,price)
values(4,'TOMATO','ORGANIC',2);
insert into product (productId,nameProduct,description,price)
values(5,'CHICKEN','1 KG',20);
insert into product (productId,nameProduct,description,price)
values(6,'BURGER','10 UN',11);
insert into product (productId,nameProduct,description,price)
values(7,'POTATO','1 KG',5);
insert into product (productId,nameProduct,description,price)
values(8,'MILK','CHOCOLATE',8);
insert into product (productId,nameProduct,description,price)
values(9,'LETUCE','SPAIN',3);
insert into product (productId,nameProduct,description,price)
values(10,'TOMATO',' 5 UN',3);


CREATE TABLE cart(

productId LONG PRIMARY KEY AUTO_INCREMENT,
nameProduct VARCHAR (200),
description VARCHAR (200),
price int (40)
);