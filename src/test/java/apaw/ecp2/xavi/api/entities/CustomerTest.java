package apaw.ecp2.xavi.api.entities;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	private Customer customer;
	private Account account;
	
	@Before
	public void before() {
		account = new Account(1);
		customer = new Customer(1, "Xavi");
	}
	
	@Test
	public void testSettersandGetters() {
		customer.setAccount(account);
		assertEquals(account.getId(), customer.getAccount().getId());
		customer.setAddress("Donoso");
		assertEquals("Donoso", customer.getAddress());
		Calendar date = Calendar.getInstance();
		customer.setDate(date);
		assertEquals(date, customer.getDate());
		customer.setName("Xavier");
		assertSame("Xavier", customer.getName());
	}

}
