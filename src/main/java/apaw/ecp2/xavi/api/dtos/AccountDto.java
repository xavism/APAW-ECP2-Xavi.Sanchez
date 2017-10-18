package apaw.ecp2.xavi.api.dtos;


import java.util.Calendar;

import apaw.ecp2.xavi.api.entities.Account;

public class AccountDto {
	
	private int id;
	private Calendar opened;
	private double factor;
	private boolean active;
	
	public AccountDto(Account account) {
        id = account.getId();
        opened = account.getOpened();
        factor = account.getFactor();
        active = account.getActive();
    }
	

	public Integer getId() {
		return this.id;
	}
	
	public Calendar getOpened() {
		return this.opened;
	}
	
	public double getFactor() {
		return this.factor;
	}
	
	public boolean getActive() {
		return this.active;
	}


	public void setId(int id) {
		assert id > 0;
		this.id = id;
	}
	
	public void setOpened(Calendar opened) {
		assert opened != null;
		this.opened = opened;
	}
	
	public void setFactor(double factor) {
		assert factor > 0;
		this.factor = factor;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
}