package apaw.ecp2.xavi.api.controllers;

import apaw.ecp2.xavi.api.daos.DaoFactory;
import apaw.ecp2.xavi.api.dtos.CustomerDto;
import apaw.ecp2.xavi.api.entities.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
	
	private int ID = 0;
	
	public List<CustomerDto> CustomerList() {
        List<Customer> CustomerList = DaoFactory.getFactory().getCustomerDao().findAll();
        List<CustomerDto> CustomerDtoList = new ArrayList<>();
        for (Customer customer : CustomerList) {
        	CustomerDtoList.add(new CustomerDto(customer));
        }
        return CustomerDtoList;
    }
	
	public void createCustomer() {
		DaoFactory.getFactory().getCustomerDao().create(new Customer(ID+1));
		ID++;
    }
	
	
}
