package apaw.ecp2.xavi;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import apaw.ecp2.xavi.api.daos.DaoFactory;
import apaw.ecp2.xavi.api.daos.memory.DaoMemoryFactory;
import apaw.ecp2.xavi.api.resources.AccountResource;
import apaw.ecp2.xavi.api.resources.CustomerResource;
import apaw.ecp2.xavi.http.HttpClientService;
import apaw.ecp2.xavi.http.HttpMethod;
import apaw.ecp2.xavi.http.HttpRequest;
import apaw.ecp2.xavi.http.HttpRequestBuilder;

public class CustomerResourceFunctionalTesting {

	    @Before
	    public void before() {
	        DaoFactory.setFactory(new DaoMemoryFactory());
	    }
	    
	    private void createCustomer() {
	        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CustomerResource.CUSTOMER).build();
	        new HttpClientService().httpRequest(request);
	    }
	    
	    @Test
	    public void testCreateCustomer() {
	        this.createCustomer();
	    }

}
