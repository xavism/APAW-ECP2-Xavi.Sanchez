package apaw.ecp2.xavi.api.entities;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {

	private Account account;
	
	@Before
	public void before() {
		account = new Account(1);
	}
	
	@Test
	public void testSettersandGetters() {
		account.setActive(true);
		assertEquals(true, account.getActive());
		account.setFactor(3.0);
		assertEquals(3.0, account.getFactor(),0.5);
		Calendar date = Calendar.getInstance();
		account.setOpened(date);
		assertEquals(date, account.getOpened());
		account.setId(2);
		assertSame(2, account.getId());
	}

}
