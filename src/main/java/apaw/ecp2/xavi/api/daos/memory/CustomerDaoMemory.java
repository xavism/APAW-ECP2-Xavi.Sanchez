package apaw.ecp2.xavi.api.daos.memory;

import java.util.HashMap;

import apaw.ecp2.xavi.api.daos.CustomerDao;
import apaw.ecp2.xavi.api.entities.Customer;



public class CustomerDaoMemory extends GenericDaoMemory<Customer> implements CustomerDao {

    public CustomerDaoMemory() {
        this.setMap(new HashMap<Integer, Customer>());
    }

    @Override
    protected Integer getId(Customer entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Customer entity, Integer id) {
        entity.setId(id);

    }

}
