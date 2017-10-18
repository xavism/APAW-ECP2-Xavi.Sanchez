package apaw.ecp2.xavi.api.daos.memory;

import apaw.ecp2.xavi.api.daos.AccountDao;
import apaw.ecp2.xavi.api.daos.DaoFactory;
import apaw.ecp2.xavi.api.daos.ThemeDao;
import apaw.ecp2.xavi.api.daos.VoteDao;

public class DaoMemoryFactory extends DaoFactory {

    private ThemeDao themeDao;

    private VoteDao voteDao;
    
    private AccountDao accountDao;

    @Override
    public ThemeDao getThemeDao() {
        if (themeDao == null) {
            themeDao = new ThemeDaoMemory();
        }
        return themeDao;
    }
    
    @Override
    public AccountDao getAccountDao() {
        if (accountDao == null) {
        	accountDao = new AccountDaoMemory();
        }
        return accountDao;
    }

    @Override
    public VoteDao getVoteDao() {
        if (voteDao == null) {
            voteDao = new VoteDaoMemory();
        }
        return voteDao;
    }

}
