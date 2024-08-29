package com.springBoot.test_react.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="member_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
	
	@Id
	private int id;
	private String name;
	private String mail;
	private int age;
	private String address;
	
}
//member
//
//id
//name
//mail
//age
//address
