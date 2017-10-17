package apaw.ecp2.xavi.api.resources;

import apaw.ecp2.xavi.api.controllers.AccountController;

public class AccountResource {
	public static final String ACCOUNT = "account";
	public static final String ID = "/{id}";
	
	public void createAccount() {
        new AccountController().createAccount();
    }
}
