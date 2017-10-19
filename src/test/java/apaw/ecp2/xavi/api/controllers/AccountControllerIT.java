package apaw.ecp2.xavi.api.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import apaw.ecp2.xavi.api.daos.DaoFactory;
import apaw.ecp2.xavi.api.daos.memory.DaoMemoryFactory;

public class AccountControllerIT {

    private AccountController accountController;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        accountController = new AccountController();
        accountController.createAccount();
    }

    
    @Test
    public void testCreate() {
    		accountController.createAccount();
        assertEquals(2, accountController.AccountList().size());
    }
    
    @Test
    public void testDelete() {
        assertEquals(1, accountController.AccountList().size());
        assertSame(1, accountController.deleteAccount(1).get().getId());
        assertEquals(0, accountController.AccountList().size());
    }

}
