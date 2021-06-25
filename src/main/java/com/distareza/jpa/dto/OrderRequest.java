package com.distareza.jpa.dto;

import com.distareza.jpa.entity.Customer;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequest {

	private Customer customer;
	
}
