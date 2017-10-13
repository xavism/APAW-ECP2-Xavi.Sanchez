package apaw.ecp2.xavi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import apaw.ecp2.xavi.api.daos.DaoFactory;
import apaw.ecp2.xavi.api.daos.memory.DaoMemoryFactory;
import apaw.ecp2.xavi.api.resources.ThemeResource;
import apaw.ecp2.xavi.api.resources.VoteResource;
import apaw.ecp2.xavi.http.HttpClientService;
import apaw.ecp2.xavi.http.HttpException;
import apaw.ecp2.xavi.http.HttpMethod;
import apaw.ecp2.xavi.http.HttpRequest;
import apaw.ecp2.xavi.http.HttpRequestBuilder;

public class ThemeResourceFunctionalTesting {

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private void createTheme() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ThemeResource.THEMES).body("uno").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateTheme() {
        this.createTheme();
    }

    @Test(expected = HttpException.class)
    public void testCreateThemeNameEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ThemeResource.THEMES).body("").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateWithoutThemeName() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ThemeResource.THEMES).build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testReadTheme() {
        this.createTheme();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ThemeResource.THEMES).path(ThemeResource.ID)
                .expandPath("1").build();
        assertEquals("{\"id\":1,\"name\":\"uno\"}", new HttpClientService().httpRequest(request).getBody());

    }

    @Test
    public void testThemeList() {
        this.createTheme();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ThemeResource.THEMES).build();
        assertEquals("[{\"id\":1,\"name\":\"uno\"}]", new HttpClientService().httpRequest(request).getBody());
    }

    @Test
    public void testThemeListEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ThemeResource.THEMES).build();
        assertEquals("[]", new HttpClientService().httpRequest(request).getBody());
    }

    @Test
    public void testThemeOverage() {
        this.createTheme();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(VoteResource.VOTES).body("1:4").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(VoteResource.VOTES).body("1:5").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.GET).path(ThemeResource.THEMES).path(ThemeResource.ID_OVERAGE).expandPath("1")
                .build();
        assertEquals("4.5", new HttpClientService().httpRequest(request).getBody());
    }

    @Test
    public void testThemeOverageWithoutVote() {
        this.createTheme();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ThemeResource.THEMES).path(ThemeResource.ID_OVERAGE)
                .expandPath("1").build();
        assertEquals("NaN", new HttpClientService().httpRequest(request).getBody());
    }

    @Test(expected = HttpException.class)
    public void testThemeOverageThemeIdNotFound() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ThemeResource.THEMES).path(ThemeResource.ID_OVERAGE)
                .expandPath("1").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testThemeVotes() {
        this.createTheme();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(VoteResource.VOTES).body("1:4").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(VoteResource.VOTES).body("1:5").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.GET).path(ThemeResource.THEMES).path(ThemeResource.ID_VOTES).expandPath("1")
                .build();
        assertEquals("{{\"id\":1,\"name\":\"uno\"},[4, 5]}", new HttpClientService().httpRequest(request).getBody());
    }

    @Test(expected = HttpException.class)
    public void testThemeVoteThemeIdNotFound() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ThemeResource.THEMES).path(ThemeResource.ID_OVERAGE)
                .expandPath("1").build();
        new HttpClientService().httpRequest(request);
    }

}
