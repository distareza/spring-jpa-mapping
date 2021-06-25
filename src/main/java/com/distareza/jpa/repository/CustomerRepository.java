package com.distareza.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.distareza.jpa.dto.OrderCustomerProduct;
import com.distareza.jpa.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findByName(String user);
	Customer findByEmail(String email);

//	@Query("SELECT new com.distareza.jpa.dto.OrderCustomerProduct(c.name, p.productName) " +
//			"from Customer c JOIN c.products p " +
//			"WHERE c.email = ?1")
//	public List<OrderCustomerProduct> getJoinInformation(String email);


	@Query("SELECT new com.distareza.jpa.dto.OrderCustomerProduct(c.name, p.productName) " + 
			"from Customer c JOIN c.products p " +
			"WHERE c.email = :email ")
	public List<OrderCustomerProduct> getJoinInformation(@Param("email") String email);
	
}
