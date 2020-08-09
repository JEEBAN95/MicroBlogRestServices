package com.mv.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class having user information.
 * 
 * @author Jeeban
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "User_TBL")
public class User {

	@Id
	@Column(name = "user_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", allocationSize = 1)
	private Integer uid;
	@Column(name = "user_name")
	private String uname;
	@Column(name = "email_id")
	private String email;


	
	@Override
	public String toString() {
		return "User [id=" + uid + ", uname=" + uname + ", email=" + email + "]";
	}
}
