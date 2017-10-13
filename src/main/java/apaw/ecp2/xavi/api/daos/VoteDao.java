package apaw.ecp2.xavi.api.daos;

import java.util.List;

import apaw.ecp2.xavi.api.entities.Vote;

public interface VoteDao extends GenericDao<Vote, Integer> {

    List<Integer> findValueByThemeId(int themeId);
}
