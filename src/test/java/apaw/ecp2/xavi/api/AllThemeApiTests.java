package apaw.ecp2.xavi.api;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import apaw.ecp2.xavi.api.controllers.AllThemeApiControllersTests;
import apaw.ecp2.xavi.api.daos.memory.AllThemeApiDaosMemoryTests;
import apaw.ecp2.xavi.api.entities.AllThemeApiEntitiesTests;

@RunWith(Suite.class)
@SuiteClasses ({
    AllThemeApiControllersTests.class,
    AllThemeApiEntitiesTests.class,
    AllThemeApiDaosMemoryTests.class
})
public class AllThemeApiTests {

}
