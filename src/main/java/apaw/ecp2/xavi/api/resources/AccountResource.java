package apaw.ecp2.xavi.api.resources;

import java.util.Optional;

import apaw.ecp2.xavi.api.controllers.AccountController;
import apaw.ecp2.xavi.api.dtos.AccountDto;
import apaw.ecp2.xavi.api.resources.exceptions.AccountIdNotFoundException;

public class AccountResource {
	public static final String ACCOUNT = "account";
	public static final String ID = "/{id}";
	
	public void createAccount() {
        new AccountController().createAccount();
    }
	
	public AccountDto deleteAccount(int accountId) throws AccountIdNotFoundException {
        Optional<AccountDto> optional = new AccountController().deleteAccount(accountId);
        return optional.orElseThrow(() -> new AccountIdNotFoundException(Integer.toString(accountId)));
    }
	
	public AccountDto readAccount(int accountId) throws AccountIdNotFoundException {
        Optional<AccountDto> optional = new AccountController().readAccount(accountId);
        return optional.orElseThrow(() -> new AccountIdNotFoundException(Integer.toString(accountId)));
    }
}
