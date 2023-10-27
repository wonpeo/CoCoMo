package SHOP;

import java.sql.Connection;
import javax.sql.DataSource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.util.*;

public class Product {
	
	int num;
	   int productCode; //��ǰ�ڵ�
	   String size;   //������
	   String productName; //��ǰ�̸�
	   long price; //����
	   String imgUrl_1;


	   public Product() {

	   }
	   public Product(int productCode,  String size, String productName, int price, String imgUrl_1)
	   {
	       super();
	       this.productCode = productCode;
	       this.size = size;
	       this.productName = productName;
	       this.price = price;
	       this.imgUrl_1 = imgUrl_1;
	   }
	   public int getNum() {
		   	return num;
		   }


		   public void setNum(int num) {
		   	this.num = num;
		   }
	   
	   public int getProductCode() {
	   	return productCode;
	   }


	   public void setProductCode(int productCode) {
	   	this.productCode = productCode;
	   }


	   public String getSize() {
	   	return size;
	   }


	   public void setSize(String size) {
	   	this.size = size;
	   }


	   public String getProductName() {
	   	return productName;
	   }


	   public void setProductName(String productName) {
	   	this.productName = productName;
	   }


	   public long getPrice() {
	   	return price;
	   }


	   public void setPrice(long price) {
	   	this.price = price;
	   	
	   }

	   public String getImgUrl_1() {
	   	return imgUrl_1;
	   }

	   public void setImgUrl_1(String imgUrl_1) {
	   	this.imgUrl_1 = imgUrl_1;
	   }
	   //������ ���
	   public void output() {
	       System.out.print(" ��ǰ�ڵ�: " + productCode +",  ");
	       System.out.print(" ������: " + size+",  ");
	       System.out.print(" ��ǰ�̸�: " + productName +",  ");
	       System.out.print(" ����: " + price +"");

	    

	}


	}