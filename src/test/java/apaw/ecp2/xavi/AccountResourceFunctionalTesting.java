package apaw.ecp2.xavi;


import org.junit.Before;
import org.junit.Test;

import apaw.ecp2.xavi.api.daos.DaoFactory;
import apaw.ecp2.xavi.api.daos.memory.DaoMemoryFactory;
import apaw.ecp2.xavi.api.resources.AccountResource;
import apaw.ecp2.xavi.http.HttpClientService;
import apaw.ecp2.xavi.http.HttpMethod;
import apaw.ecp2.xavi.http.HttpRequest;
import apaw.ecp2.xavi.http.HttpRequestBuilder;

public class AccountResourceFunctionalTesting {

	    @Before
	    public void before() {
	        DaoFactory.setFactory(new DaoMemoryFactory());
	    }
	    
	    private void createAccount() {
	        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(AccountResource.ACCOUNT).build();
	        new HttpClientService().httpRequest(request);
	    }
	    
	    @Test
	    public void testCreateAccount() {
	        this.createAccount();
	    }

}
