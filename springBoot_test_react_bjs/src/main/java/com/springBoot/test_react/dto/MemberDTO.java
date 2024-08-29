package com.springBoot.test_react.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member_tbl")
public class MemberDTO {
	private int id;
	private String name;
	private String mail;
	private int age;
	private String address;
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", name=" + name + ", mail=" + mail + ", age=" + age + ", address=" + address
				+ "]";
	}

}
//member
//
//id
//name
//mail
//age
//address
