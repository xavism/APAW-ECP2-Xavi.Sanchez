package apaw.ecp2.xavi.api.daos.memory;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import apaw.ecp2.xavi.api.daos.DaoFactory;
import apaw.ecp2.xavi.api.entities.Account;

public class AccountDaoMemoryTest {

	private Account account;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        account = new Account(1);
        DaoFactory.getFactory().getAccountDao().create(account);
    }
    
    @Test
    public void testReadAccount() {
        assertSame(1, DaoFactory.getFactory().getAccountDao().read(1).getId());
    }
    
    @Test
    public void testReadNonExistId() {
        assertNull(DaoFactory.getFactory().getAccountDao().read(2));
    }
    
    @Test
    public void testDelete() {
    		DaoFactory.getFactory().getAccountDao().deleteById(1);
        assertNull(DaoFactory.getFactory().getAccountDao().read(1));
    }

}
