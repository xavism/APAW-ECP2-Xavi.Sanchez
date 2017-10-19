package apaw.ecp2.xavi.api.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import apaw.ecp2.xavi.api.daos.DaoFactory;
import apaw.ecp2.xavi.api.daos.memory.DaoMemoryFactory;

public class CustomerControllerIT {

    private CustomerController customerController;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        customerController = new CustomerController();
        customerController.createCustomer("Xavier");
    }

    
    @Test
    public void testCreate() {
    		customerController.createCustomer("Xavi");
        assertEquals(2, customerController.CustomerList().size());
    }
    
    @Test
    public void testRead() {
		assertSame("Xavier", customerController.readCustomer(1).get().getName());
	}
	
	@Test
	public void testDelete() {
	    assertEquals(1, customerController.CustomerList().size());
		assertEquals("Xavier", customerController.deleteCustomer(1).get().getName());
	    assertEquals(0, customerController.CustomerList().size());
	}

}
