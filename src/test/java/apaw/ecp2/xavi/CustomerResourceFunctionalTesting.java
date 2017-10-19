package apaw.ecp2.xavi;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import apaw.ecp2.xavi.api.daos.DaoFactory;
import apaw.ecp2.xavi.api.daos.memory.DaoMemoryFactory;
import apaw.ecp2.xavi.api.resources.CustomerResource;
import apaw.ecp2.xavi.http.HttpClientService;
import apaw.ecp2.xavi.http.HttpException;
import apaw.ecp2.xavi.http.HttpMethod;
import apaw.ecp2.xavi.http.HttpRequest;
import apaw.ecp2.xavi.http.HttpRequestBuilder;

public class CustomerResourceFunctionalTesting {

	    @Before
	    public void before() {
	        DaoFactory.setFactory(new DaoMemoryFactory());
	    }
	    
	    private void createCustomer(String customerName) {
	        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CustomerResource.CUSTOMER).body(customerName).build();
	        new HttpClientService().httpRequest(request);
	    }
	    
	    @Test
	    public void testCreateCustomer() {
	        this.createCustomer("Xavi");
	    }
	    
	    @Test(expected = HttpException.class)
	    public void testCreateCustomerNameEmpty() {
	    	HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CustomerResource.CUSTOMER).body("").build();
	        new HttpClientService().httpRequest(request);
	    }

	    @Test(expected = HttpException.class)
	    public void testCreateWithoutCustomerName() {
	    	HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CustomerResource.CUSTOMER).build();
	        new HttpClientService().httpRequest(request);
	    }
	    
	    @Test
	    public void testReadCustomer() {
	        this.createCustomer("Xavi");
	        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(CustomerResource.CUSTOMER).path(CustomerResource.ID)
	                .expandPath("1").build();
	        assertEquals("{\"id\":0,\"name\":\"Xavi\"}", new HttpClientService().httpRequest(request).getBody());

	    }
	    
	    @Test
	    public void testDeleteCustomer() {
	    		this.createCustomer("Xavi");
	        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.DELETE).path(CustomerResource.CUSTOMER).path(CustomerResource.ID)
	                .expandPath("1").build();
	        assertEquals("{\"id\":0,\"name\":\"Xavi\"}", new HttpClientService().httpRequest(request).getBody());
	    }

}
