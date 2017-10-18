package apaw.ecp2.xavi.api.dtos;



import apaw.ecp2.xavi.api.entities.Account;

public class AccountDto {
	
	private int id;
	private boolean active;
	
	public AccountDto(Account account) {
        id = account.getId();
        active = account.getActive();
    }
	

	public Integer getId() {
		return this.id;
	}
	
	public boolean getActive() {
		return this.active;
	}


	public void setId(int id) {
		assert id > 0;
		this.id = id;
	}
	
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
    public String toString() {
        return "{\"id\":" + id + ",\"active\":\"" + active + "\"}";
    }
}