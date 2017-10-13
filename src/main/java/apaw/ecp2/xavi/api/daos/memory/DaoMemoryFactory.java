package apaw.ecp2.xavi.api.daos.memory;

import apaw.ecp2.xavi.api.daos.DaoFactory;
import apaw.ecp2.xavi.api.daos.ThemeDao;
import apaw.ecp2.xavi.api.daos.VoteDao;

public class DaoMemoryFactory extends DaoFactory {

    private ThemeDao themeDao;

    private VoteDao voteDao;

    @Override
    public ThemeDao getThemeDao() {
        if (themeDao == null) {
            themeDao = new ThemeDaoMemory();
        }
        return themeDao;
    }

    @Override
    public VoteDao getVoteDao() {
        if (voteDao == null) {
            voteDao = new VoteDaoMemory();
        }
        return voteDao;
    }

}
