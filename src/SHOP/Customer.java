package SHOP;

import java.util.*;

public class Customer {
	int num;//��ȣ
    String id;// ���̵�
    String name; //�̸�
    String password; //��й�ȣ
    String address; //�ּ�
    String Email; //�̸���
    String number; //��ȭ��ȣ

    public Customer() {

    }

    public Customer(String id, String password, String name, String address, String number, String Email)
    {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
        this.number = number;
        this.Email = Email;
    }


    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    // ������ ���
    public void output() {
        System.out.print(" ���̵�: " + id +",  ");
        System.out.print("��й�ȣ: " + password +",  ");
        System.out.print("�̸�: " + name+",  ");
        System.out.print("�̸���: " + Email+",   ");
        System.out.print("��ȭ��ȣ: " + number +",");
        System.out.print("�ּ�: " + address +"");

    }

}