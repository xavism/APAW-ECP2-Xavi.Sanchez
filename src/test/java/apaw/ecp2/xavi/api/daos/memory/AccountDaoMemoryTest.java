package apaw.ecp2.xavi.api.daos.memory;


import org.junit.Before;
import org.junit.Test;

import apaw.ecp2.xavi.api.daos.DaoFactory;
import apaw.ecp2.xavi.api.entities.Account;

public class AccountDaoMemoryTest {

	private Account account;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        account = new Account();
        DaoFactory.getFactory().getAccountDao().create(account);
    }
    
	@Test
	public void test() {
		
	}

}
