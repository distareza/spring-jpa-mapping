package com.distareza.jpa.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.distareza.jpa.dto.OrderCustomerProduct;
import com.distareza.jpa.entity.Customer;
import com.distareza.jpa.entity.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class TestCustomerRepository {

	@Autowired
	private CustomerRepository repo;
	
	@Test
	public void testInsertCustomer() throws Exception {
		SimpleDateFormat sdf  = new SimpleDateFormat("dd-MM-yyyy");
		
		Customer customer = new Customer();
		customer.setName("Jon Bon Jovi");
		customer.setEmail("bonjovi@email.com");
		customer.setBirth(sdf.parse("02-03-1962"));
		customer.setGender("male");
		
		
		repo.save(customer);
		
		assertTrue(true);
	}
	
	@Test
	public void testSelectOneCustomerById() throws Exception {
		Optional<Customer> customer = repo.findById(1);
		System.out.println(customer.get());
		
		assertTrue(true);
	}
	
	@Test
	public void testMultipleCustomer() throws Exception {
		SimpleDateFormat sdf  = new SimpleDateFormat("dd-MM-yyyy");
		
		@SuppressWarnings("unchecked")
		List<Customer> listOfCustomer = Stream.of(
				new Customer(0, "Diana, Princess of Wales", 
							"princediana@gmail.com", 
							"fenale", 
							sdf.parse("01-07-1961"),
						(List<Product>)(Object) Arrays.asList( new Product[]{
											new Product(1, "Purses", 5, 2000000.0) ,
											new Product(2, "Gawn", 3, 5600000.0) ,
											new Product(3, "Jewelry", 12, 12000000.0) 
						})),
				new Customer(0, "Thomas Jefferson", 
						"jefferson@gmail.com", 
						"male", 
						sdf.parse("13-04-1743"), 
						(List<Product>)(Object) Arrays.asList( new Product[]{
								new Product(4, "Rifls", 3, 2000.0) ,
								new Product(5, "Knife", 1, 20.0) ,
								new Product(6, "Flag", 51, 500.0) 
						})),
				new Customer(0, "Freedy Mercury", 
						"queen@gmail.com", 
						"male", sdf.parse("05-09-1946"), 
						(List<Product>)(Object) Arrays.asList( new Product[]{
								new Product(7, "Piano", 3, 1800000.0) ,
								new Product(8, "Drug", 13, 200000.0) ,
								new Product(9, "Cigaratte", 15, 200.0) 
						})),
				new Customer(0, "Marilyn Monroe", 
						"monroe@gmail.com", 
						"female", 
						sdf.parse("01-06-1926"), 						
						(List<Product>)(Object) Arrays.asList( new Product[]{
							new Product(10, "Cars", 2, 2000000.0) ,
							new Product(11, "Pent House", 3, 120000000.0) ,
							new Product(12, "Dpg", 1, 200000.0) 
						})),
				new Customer(0, "Kobe Bryant", 
						"bryant@gmail.com", 
						"male", 
						sdf.parse("23-08-1978"), 						
						(List<Product>)(Object) Arrays.asList( new Product[]{
							new Product(13, "Basket Ball", 10, 1000.0) ,
							new Product(14, "Helicopter", 1, 2000000.0) ,
							new Product(15, "Phone", 7, 7000.0) 
						}))
				
		).collect(Collectors.toList());
		
		repo.saveAll(listOfCustomer);
		assertTrue(true);
	}
	
	@Test
	public void testSelectCustomerByName() throws Exception {
		
		System.out.println(repo.findByName("Kobe Bryant"));
		System.out.println(repo.findByEmail("jefferson@gmail.com"));
		
		assertTrue(true);
	}
	
	@Test
	public void testUpdateCustomerDetail() {
		
	}
	
	@Test
	public void testRemoveCustomer() {
		
	}
	
	@Test
	public void testQueryJoin() throws Exception {
		
		List<OrderCustomerProduct> list = repo.getJoinInformation("queen@gmail.com");
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonText = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
				
		System.out.println(jsonText);
		
		assertTrue(true);
	}
}
