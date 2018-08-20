package com.webage.dao;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.webage.domain.Customer;
import org.springframework.web.client.RestTemplate;

@Repository
public class APIClientCustomersDAO implements CustomersDAO {

	String customersAPIbase="http://localhost:8080/customers";

	@Override
	public Collection<Customer> getAllCustomers() {
		// Construct a GET request to the CustomersAPI base url
		// Insert code here..
        RestTemplate template=new RestTemplate();
        Customer[] customers=template.getForObject(customersAPIbase, Customer[].class);
		return new Arrays.asList(customers);
	}

}
