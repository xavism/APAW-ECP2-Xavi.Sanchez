package apaw.ecp2.xavi.api.entities;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ThemeTest {

    @Test
    public void testGetDate() {
        assertNotNull(new Theme("tema1").getDate());
    }

}
