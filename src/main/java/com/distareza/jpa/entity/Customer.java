package com.distareza.jpa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, 
					generator = "customer_seq")
	@SequenceGenerator(
					name = "customer_seq", 
					sequenceName = "customer_seq", 
					initialValue = 1, 
					allocationSize = 1)
	private int id;
	private String name;
	private String email;
	private String gender;
	private Date birth;
	
	@OneToMany(
			targetEntity = Product.class, 
			cascade = CascadeType.ALL, 
			fetch= FetchType.EAGER)
	@JoinColumn(
			name = "cp_fk", 
			referencedColumnName = "id")
	private List<Product> products;
	
}
