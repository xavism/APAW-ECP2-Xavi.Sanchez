package apaw.ecp2.xavi.api.controllers;

import apaw.ecp2.xavi.api.daos.CustomerDao;
import apaw.ecp2.xavi.api.daos.DaoFactory;
import apaw.ecp2.xavi.api.dtos.CustomerDto;
import apaw.ecp2.xavi.api.entities.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	public void createCustomer(String customerName) {
		DaoFactory.getFactory().getCustomerDao().create(new Customer(ID+1, customerName));
		ID++;
    }
	private boolean existCustomerId(int customerId) {
        return DaoFactory.getFactory().getCustomerDao().read(customerId) != null;
    }
	
	public Optional<CustomerDto> deleteCustomer(int customerId) {
       if (existCustomerId(customerId)) {
    	   		CustomerDao customerDao = DaoFactory.getFactory().getCustomerDao();
            Optional<CustomerDto> getter =  Optional.of(new CustomerDto(customerDao.read(customerId)));
            customerDao.deleteById(customerId);
            return getter;
       } else {
            return Optional.empty();
        }
    }
	
	public Optional<CustomerDto> readCustomer(int customerId) {
       if (existCustomerId(customerId)) {
            return Optional.of(new CustomerDto(DaoFactory.getFactory().getCustomerDao().read(customerId)));
        } else {
            return Optional.empty();
        }
    }
	
}
