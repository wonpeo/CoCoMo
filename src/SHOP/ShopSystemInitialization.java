package SHOP;

public class ShopSystemInitialization {

      static String[]  sqls = {
               " drop database if exists shop;", 
               " create database shop;",
               " use shop;",
               
               /***********************************************
                TABLE NAME   : shop.Customer
                DATABASE     : shop
                **********************************************/
             "  drop table if exists shop.Customer; ",
             "  create table Customer( " + 
             "num int auto_increment, " +
             "  ID varchar(20) not null, " + 
              " name varchar(20) not null, " +
              " password varchar(100) not null, " +
              " address varchar(30) not null, " +
              " Email varchar(30) not null, " +
              " number varchar(20) not null, " +
             " primary key(num) " +
                " );",
                
                    /***********************************************
                           TABLE NAME   : shop.myOrder
                      DATABASE     : shop
                      **********************************************/
                
                
         /*       " drop table if exists shop.myOrder;" ,
                " create table myOrder( " + 
                "num int auto_increment, " +
                " productCode varchar(20) not null, " + 
                " orderNo int(10) not null, " + 
                " ID varchar(20) not null, " + 
                " EA int not null, " + 
                " price long not null, " + 
                " address varchar(30) not null, " + 
                " primary key(num,orderNo, productCode), " + 
                " FOREIGN KEY (ID) REFERENCES Customer(ID)" + 
                " );",   
                */
                
                   
                    /***********************************************
                            TABLE NAME   : shop.orderTable
                            DATABASE     : shop
                     **********************************************/
                /*
                    " drop table if exists shop.orderTable;" ,
                "create table orderTable( " +
                "num int auto_increment, " +
                "orderTableNo int not null, " +
                "EA int not null, " +
                "orderNo int not null, " +
                "primary key(num,orderTableNo), " +
                "FOREIGN KEY (orderNo) REFERENCES myOrder(orderNo) " +
                " );",
                */
                
                    /***********************************************
                    TABLE NAME   : shop.Product
                     DATABASE     : shop
                     **********************************************/
                
                "drop table if exists shop.Product; " ,
                "create table Product( " +
                "num int auto_increment, " +
                "ProductCode int not null, " +
                "size varchar(20) not null, " +
                "imgUrl_1 varchar(100) not null," +
                "productName varchar(20) not null, " +
                "price long not null, " +
                "type varchar(20) not null, " +
                "primary key(num) " +
                " );",
                " insert into Shop.Product values(1,1, 'M', '0.jpg', '��Ŭ ���� Ƽ����', 15000, '��'); ",
                " insert into Shop.Product values(null,2, '', '1.jpg', '�Լķζ� ������', 500000, '��Ÿ'); ",
                " insert into Shop.Product values(null,3, '', '2.jpg', '���� ī������', 1500000, '��Ÿ'); ",
                " insert into Shop.Product values(null,4, 'L', '3.jpg', '���� ������', 55900, '��'); ",
                " insert into Shop.Product values(null,5, 'XL', '4.jpg', '���� �ʼ��� ���ٹ���', 35400, '��'); ",
                " insert into Shop.Product values(null,6, 'L', '5.jpg', '���� ������ �׷�����', 38500, '��'); ",
                " insert into Shop.Product values(null,7, 'XL', '6.jpg', '������ ��������', 45900, '��'); ",
                " insert into Shop.Product values(null,8, 'FREE', '7.jpg', '������ �׷�����', 35500, '��'); ",
                " insert into Shop.Product values(null,9, 'XL', '8.jpg', '������ ��� �ĵ�Ƽ', 25500, '��'); ",
                " insert into Shop.Product values(null,10, 'XL', '9.jpg', '��� �ڽ�Ƽ', 23500, '��'); ",
                " insert into Shop.Product values(null,11, '265', '10.jpg', '����Ű ��ũ �ο� �ڽ�Ʈ', 354000, '�Ź�'); ",
                " insert into Shop.Product values(null,12, '290', '11.jpg', '����Ű ��ũ �ο� ��Ʈ�� ��', 178000, '�Ź�'); ",
                " insert into Shop.Product values(null,13, '', '12.jpg', 'ũ������ ��������', 200000, '��Ÿ'); ",
                " insert into Shop.Product values(null,14, '', '13.jpg', 'ȭ��Ʈ �޽�����', 38500, '��Ÿ'); ",
                " insert into Shop.Product values(null,15, '', '14.jpg', '����Ŭ�� ����', 48500, '��Ÿ'); ",
                    /***********************************************
                    TABLE NAME   : shop.Product
                     DATABASE     : shop
                     **********************************************/
                
                "drop table if exists shop.Cart; " ,
                "create table Cart( " +
                "num int auto_increment, " +
              //  "basketNo int not null, " +
                "userId int not null, " +
                "productId int not null, " +
             //   "totalPrice int not null, " +
              //  "EA int not null, " +
              "primary key(num) " +
            //    "FOREIGN KEY (ID) REFERENCES Customer(ID), " +
            //    "FOREIGN KEY (productCode) REFERENCES Product(productCode) " +
                " );",
                
                /***********************************************
					TABLE NAME   : shop.Favor
					DATABASE     : shop
					 **********************************************/
    
			"drop table if exists shop.Favor; " ,
				"create table Favor( " +
				"num int auto_increment, " +
					//  "basketNo int not null, " +
					"userId int not null, " +
					"productId int not null, " +
					//   "totalPrice int not null, " +
					//  "EA int not null, " +
					"primary key(num) " +
				//    "FOREIGN KEY (ID) REFERENCES Customer(ID), " +
				//    "FOREIGN KEY (productCode) REFERENCES Product(productCode) " +
					" );",}; 
                
      
      
      
                    /***********************************************
                    TABLE NAME   : shop.Delivery
                     DATABASE     : shop
                     **********************************************/
                
                
                /*
                "drop table if exists shop.Delivery; " ,
                "create table Delivery( " +
                "num int auto_increment, " +
                "deliveryNo int not null, " +
                "ID varchar(20) not null, " +
                "productName varchar(20) not null, " +
                "name varchar(20) not null, " +
                "arriveDate varchar(20) not null, " +
                "arriveLocation varchar(20) not null, " +
                "primary key(num,deliveryNo), " +
                "FOREIGN KEY (ID) REFERENCES Customer(ID) " +
                " );",};  
                */

      
      public static void main(String[] args) {
            createInitialShopDatabase();
              
         }
         static void createInitialShopDatabase() {
            SHOPDB.loadConnect("mysql");
            
            for (String sql : sqls) {
               SHOPDB.executeAnyQuery(sql);
               
                  System.out.println("  << for debug >> in createInitialShopDatabase(), sql = " + sql); 
            }
            
         }
         
         
      }