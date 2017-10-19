package apaw.ecp2.xavi.api.dtos;

import apaw.ecp2.xavi.api.entities.Customer;

public class CustomerDto {
	
	private int id;
	private String name;
	
	public CustomerDto(Customer customer) {
        id = customer.getId();
        name = customer.getName();
    }
	

	public Integer getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}


	public void setId(int id) {
		assert id > 0;
		this.id = id;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
    public String toString() {
        return "{\"id\":" + id + ",\"name\":\"" + name + "\"}";
    }
}