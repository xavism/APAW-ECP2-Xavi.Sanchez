package apaw.ecp2.xavi.api.daos.memory;

import java.util.HashMap;

import apaw.ecp2.xavi.api.daos.ThemeDao;
import apaw.ecp2.xavi.api.entities.Theme;

public class ThemeDaoMemory extends GenericDaoMemory<Theme> implements ThemeDao {

    public ThemeDaoMemory() {
        this.setMap(new HashMap<Integer, Theme>());
    }

    @Override
    protected Integer getId(Theme entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Theme entity, Integer id) {
        entity.setId(id);

    }

}
