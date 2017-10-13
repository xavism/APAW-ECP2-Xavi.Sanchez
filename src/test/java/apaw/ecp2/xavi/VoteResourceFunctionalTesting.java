package apaw.ecp2.xavi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import apaw.ecp2.xavi.api.daos.DaoFactory;
import apaw.ecp2.xavi.api.daos.memory.DaoMemoryFactory;
import apaw.ecp2.xavi.api.resources.ThemeResource;
import apaw.ecp2.xavi.api.resources.VoteResource;
import apaw.ecp2.xavi.http.HttpClientService;
import apaw.ecp2.xavi.http.HttpException;
import apaw.ecp2.xavi.http.HttpMethod;
import apaw.ecp2.xavi.http.HttpRequest;
import apaw.ecp2.xavi.http.HttpRequestBuilder;

public class VoteResourceFunctionalTesting {

    private HttpRequest request;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        request = new HttpRequest();
    }

    private void createTheme() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ThemeResource.THEMES).body("uno").build();
        new HttpClientService().httpRequest(request);
    }

    private void createVotes() {
        this.createTheme();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(VoteResource.VOTES).body("1:4").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(VoteResource.VOTES).body("1:5").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateVote() {
        this.createVotes();
    }

    @Test
    public void testCreateVoteVoteInvalidException() {
        exception.expect(HttpException.class);
        this.createTheme();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(VoteResource.VOTES).body("1:-1").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(VoteResource.VOTES).body("1:x").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateThemeIdNotFoundException() {
        exception.expect(HttpException.class);
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(VoteResource.VOTES).body("1:4").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testVoteList() {
        this.createVotes();
        request = new HttpRequestBuilder().method(HttpMethod.GET).path(VoteResource.VOTES).build();
        assertEquals("[{\"themeName\":\"uno,\"voteValue\":4}, {\"themeName\":\"uno,\"voteValue\":5}]",
                new HttpClientService().httpRequest(request).getBody());
    }

}
