package com.userDepartament.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id = 0L;
	private String name = "";
	private String email = "";
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	public User() {
		
	}
}
