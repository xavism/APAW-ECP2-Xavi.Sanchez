package apaw.ecp2.xavi.api.daos.memory;

import java.util.HashMap;

import apaw.ecp2.xavi.api.daos.AccountDao;
import apaw.ecp2.xavi.api.entities.Account;



public class AccountDaoMemory extends GenericDaoMemory<Account> implements AccountDao {

    public AccountDaoMemory() {
        this.setMap(new HashMap<Integer, Account>());
    }

    @Override
    protected Integer getId(Account entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Account entity, Integer id) {
        entity.setId(id);

    }

}
