package apaw.ecp2.xavi.api.controllers;

import apaw.ecp2.xavi.api.daos.AccountDao;
import apaw.ecp2.xavi.api.daos.DaoFactory;
import apaw.ecp2.xavi.api.dtos.AccountDto;
import apaw.ecp2.xavi.api.dtos.CustomerDto;
import apaw.ecp2.xavi.api.entities.Account;
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
	
	public void createAccount() {
		DaoFactory.getFactory().getAccountDao().create(new Account(ID+1));
		System.out.println(ID);
		ID++;
    }
	
	private boolean existAccountId(int customerId) {
        return DaoFactory.getFactory().getCustomerDao().read(customerId) != null;
    }
}
