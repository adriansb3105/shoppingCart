use shopping_cart_b24075_b36630;

create table Category(	category_id int not null constraint PK_Category Primary Key,
						name varchar(255) not null);

create table Product(	product_id int not null constraint PK_Product Primary Key,
						name varchar(255) not null,
						description varchar(255) not null,
						price float not null,
						category_id int not null constraint FK_Product_Category Foreign Key(category_id) references Category(category_id));

create table Product_Image(	product_image_id int not null constraint PK_Product_Image Primary Key,
							url varchar(255) not null,
							product_id int not null constraint FK_Product_Image Foreign Key(product_image_id) references Product(product_id));

create table Inventory(	inventory_id int not null constraint PK_Inventory Primary Key,
						units int not null,
						product_id int not null constraint UK_Inventory Unique,
						constraint FK_Inventory_Product Foreign Key(product_id) references Product(product_id));

