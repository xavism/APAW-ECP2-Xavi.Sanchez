package apaw.ecp2.xavi.api.resources;


import java.util.Optional;

import apaw.ecp2.xavi.api.controllers.CustomerController;
import apaw.ecp2.xavi.api.dtos.CustomerDto;
import apaw.ecp2.xavi.api.resources.exceptions.CustomerIdNotFoundException;
import apaw.ecp2.xavi.api.resources.exceptions.ThemeFieldInvalidException;

public class CustomerResource {
	public static final String CUSTOMER = "customer";
	public static final String ID = "/{id}";
	
	
	public void createCustomer(String customerName) throws ThemeFieldInvalidException {
		this.validateField(customerName);
		new CustomerController().createCustomer(customerName);
    }
	public CustomerDto deleteCustomer(int customerId) throws CustomerIdNotFoundException {
        Optional<CustomerDto> optional = new CustomerController().deleteCustomer(customerId);
        return optional.orElseThrow(() -> new CustomerIdNotFoundException(Integer.toString(customerId)));
    }
	
	public CustomerDto readCustomer(int customerId) throws CustomerIdNotFoundException {
        Optional<CustomerDto> optional = new CustomerController().readCustomer(customerId);
        return optional.orElseThrow(() -> new CustomerIdNotFoundException(Integer.toString(customerId)));
    }
	
	private void validateField(String field) throws ThemeFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new ThemeFieldInvalidException(field);
        }
    }
}
