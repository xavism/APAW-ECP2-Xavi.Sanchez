package apaw.ecp2.xavi.api.resources;


import apaw.ecp2.xavi.api.controllers.CustomerController;

public class CustomerResource {
	public static final String CUSTOMER = "customer";
	public static final String ID = "/{id}";
	
	public void createCustomer() {
        new CustomerController().createCustomer();
    }
	
}
