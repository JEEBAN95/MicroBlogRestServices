package com.mv.api.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Model class having properties to map the form data for the blog file
 * 
 * @author Jeeban
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Blog_TBL")
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bid_seq")
	@SequenceGenerator(name = "bid_seq", allocationSize = 1)
	private Integer bid;
	@Column(name = "blog_name")
	private String blogName;
	@Lob
	private byte[] blogContents;

	@Transient
	private String text;

	@OneToOne(fetch = FetchType.LAZY)
	private User user;
	
	@Override
	public String toString() {
		return "Blog [bid=" + bid + ", blogName=" + blogName + ", blog=" + Arrays.toString(blogContents) + ", text=" + text
				+ "]";
	}
}