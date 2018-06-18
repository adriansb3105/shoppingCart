use shopping_cart_b24075_b36630;

create table Category(	category_id int IDENTITY(1, 1) not null constraint PK_Category Primary Key,
						name varchar(255) not null,
						deleted bit not null default 0);

create table Product(	product_id int IDENTITY(1, 1) not null constraint PK_Product Primary Key,
						name varchar(255) not null,
						description varchar(255) not null,
						price float not null,
						deleted bit not null default 0,
						category_id int not null constraint FK_Product_Category Foreign Key(category_id) references Category(category_id)
						on delete cascade on update cascade);

create table Product_Image(	product_image_id int IDENTITY(1, 1) not null constraint PK_Product_Image Primary Key,
							url varchar(255) not null,
							deleted bit not null default 0,
							product_id int not null constraint FK_Product_Image Foreign Key(product_id) references Product(product_id)
							on delete cascade on update cascade);

create table Inventory(	inventory_id int IDENTITY(1, 1) not null constraint PK_Inventory Primary Key,
						units int not null,
						product_id int not null,-- constraint UK_Inventory Unique,
						deleted bit not null default 0,
						constraint FK_Inventory_Product Foreign Key(product_id) references Product(product_id)
						on delete cascade on update cascade);

create table Employee(	employee_id int IDENTITY(1, 1) not null constraint PK_Employee Primary Key,
						email varchar(255) not null,
						first_name varchar(255) not null,
						last_name varchar(255) not null,
						password varchar(255) not null,
						employee_code varchar(255) not null,-- constraint UK_Employee Unique,
						departament varchar(255) not null,
						deleted bit not null default 0);

create table Client(	client_id int IDENTITY(1, 1) not null constraint PK_Client Primary Key,
						email varchar(255) not null,
						first_name varchar(255) not null,
						last_name varchar(255) not null,
						password varchar(255) not null,
						city varchar(255) not null,
						postal_code varchar(255) not null,
						telephone varchar(255) not null,
						description varchar(255) not null,
						deleted bit not null default 0);

create table Shopping_Cart(	shopping_cart_id int IDENTITY(1, 1) not null constraint PK_Shopping_Cart Primary Key,
							quantity int not null,
							date_created date not null,
							client_id int not null,
							deleted bit not null default 0,
							constraint FK_Cart_Client Foreign Key(client_id) references Client(client_id)
							on delete cascade on update cascade);

create table Bill(	bill_id int IDENTITY(1, 1) not null constraint PK_Bill Primary Key,
					bill_date date not null,
					total_value float not null,
					client_id int not null,
					deleted bit not null default 0,
					constraint FK_Bill_Client Foreign Key(client_id) references Client(client_id)
					on delete cascade on update cascade);

create table Order_Detail(	order_detail_id int IDENTITY(1, 1) not null constraint PK_Order_Detail Primary Key,
							quantity int not null,
							price float not null,
							tax int not null,
							bill_id int not null,
							product_id int not null,
							deleted bit not null default 0,
							constraint FK_Detail_Bill Foreign Key(bill_id) references Bill(bill_id)
							on delete cascade on update cascade,
							constraint FK_Detail_Product Foreign Key(product_id) references Product(product_id)
							on delete cascade on update cascade);

create table Shopping_Cart_Product(	shopping_cart_id int not null,
									product_id int not null,
									deleted bit not null default 0,
									constraint PK_Cart_Product Primary Key(shopping_cart_id, product_id),
									constraint FK_Cart_Product_Client Foreign Key(shopping_cart_id) references Shopping_Cart(shopping_cart_id)
									on delete cascade on update cascade,
									constraint FK_Cart_Product_Product Foreign Key(product_id) references Product(product_id)
									on delete cascade on update cascade);



---------------------------------------------------------------------------------------
CREATE PROCEDURE sp_login_employee @employee_code varchar(255), @email varchar(255), @password varchar(255)
AS
BEGIN
	select employee_id, email, first_name, last_name, password, employee_code, departament from Employee where employee_code=@employee_code AND email=@email AND password=@password ;
END
GO;
---------------------------------------------------------------------------------------

Create PROCEDURE sp_login_client @email varchar(255)
AS
BEGIN
	select client_id, email, first_name, last_name, password, city, postal_code, telephone, description, deleted from Client where email=@email;
END

---------------------------------------------------------------------------------------


-- exec sp_login_employee '','','';
exec sp_login_client 'a@b.c';
-- drop procedure sp_login_employee;
