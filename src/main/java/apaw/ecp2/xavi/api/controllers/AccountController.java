package apaw.ecp2.xavi.api.controllers;

import apaw.ecp2.xavi.api.daos.DaoFactory;
import apaw.ecp2.xavi.api.dtos.AccountDto;
import apaw.ecp2.xavi.api.entities.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountController {
	
	private int ID = 0;
	
	public List<AccountDto> AccountList() {
        List<Account> AccountList = DaoFactory.getFactory().getAccountDao().findAll();
        List<AccountDto> AccountDtoList = new ArrayList<>();
        for (Account account : AccountList) {
        	AccountDtoList.add(new AccountDto(account));
        }
        return AccountDtoList;
    }
	
	public void createAccount() {
		DaoFactory.getFactory().getAccountDao().create(new Account(ID+1));
		System.out.println(ID);
		ID++;
    }
	
	private boolean existAccountId(int accountId) {
        return DaoFactory.getFactory().getAccountDao().read(accountId) != null;
    }
	
	public Optional<AccountDto> readAccount(int accountId) {
	       if (existAccountId(accountId)) {
	            return Optional.of(new AccountDto(DaoFactory.getFactory().getAccountDao().read(accountId)));
	        } else {
	            return Optional.empty();
	        }
	    }
}
