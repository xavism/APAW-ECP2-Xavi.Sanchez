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
        customerController.createCustomer();
    }

    
    @Test
    public void testCreate() {
    		customerController.createCustomer();
        assertEquals(2, customerController.CustomerList().size());
    }

}
