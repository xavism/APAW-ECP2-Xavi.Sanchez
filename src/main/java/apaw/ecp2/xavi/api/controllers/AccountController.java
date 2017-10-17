package apaw.ecp2.xavi.api.controllers;

import apaw.ecp2.xavi.api.daos.DaoFactory;
import apaw.ecp2.xavi.api.entities.Account;

public class AccountController {
	
	private int ID = 0;
	
	public void createAccount() {
		DaoFactory.getFactory().getAccountDao().create(new Account(ID+1));
    }
}
