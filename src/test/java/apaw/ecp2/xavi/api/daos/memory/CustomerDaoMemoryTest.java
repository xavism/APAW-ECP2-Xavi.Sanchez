package apaw.ecp2.xavi.api.daos.memory;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import apaw.ecp2.xavi.api.daos.DaoFactory;
import apaw.ecp2.xavi.api.entities.Customer;

public class CustomerDaoMemoryTest {

	private Customer customer;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        customer = new Customer(1, "Xavi");
        DaoFactory.getFactory().getCustomerDao().create(customer);
    }

    @Test
    public void testReadCustomer() {
        assertEquals("Xavi", DaoFactory.getFactory().getCustomerDao().read(1).getName());
    }
    
    @Test
    public void testReadNonExistId() {
        assertNull(DaoFactory.getFactory().getCustomerDao().read(2));
    }
    
    @Test
    public void testDelete() {
    		DaoFactory.getFactory().getCustomerDao().deleteById(1);
        assertNull(DaoFactory.getFactory().getCustomerDao().read(1));
    }
}
