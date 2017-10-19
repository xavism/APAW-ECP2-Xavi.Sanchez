package apaw.ecp2.xavi.api;

import apaw.ecp2.xavi.api.dtos.AccountDto;
import apaw.ecp2.xavi.api.dtos.CustomerDto;
import apaw.ecp2.xavi.api.resources.AccountResource;
import apaw.ecp2.xavi.api.resources.CustomerResource;
import apaw.ecp2.xavi.api.resources.ThemeResource;
import apaw.ecp2.xavi.api.resources.VoteResource;
import apaw.ecp2.xavi.api.resources.exceptions.RequestInvalidException;
import apaw.ecp2.xavi.http.HttpRequest;
import apaw.ecp2.xavi.http.HttpResponse;
import apaw.ecp2.xavi.http.HttpStatus;

public class Dispatcher {

    private ThemeResource themeResource = new ThemeResource();

    private VoteResource voteResource = new VoteResource();
    
    private AccountResource accountResource = new AccountResource();
    
    private CustomerResource customerResource = new CustomerResource();

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(ThemeResource.THEMES)) {
                response.setBody(themeResource.themeList().toString());
            } else if (request.isEqualsPath(ThemeResource.THEMES + ThemeResource.ID)) {
                response.setBody(themeResource.readTheme(Integer.valueOf(request.paths()[1])).toString());
            } else if (request.isEqualsPath(ThemeResource.THEMES + ThemeResource.ID_OVERAGE)) {
                response.setBody(themeResource.themeOverage(Integer.valueOf(request.paths()[1])).toString());
            } else if (request.isEqualsPath(ThemeResource.THEMES + ThemeResource.ID_VOTES)) {
                response.setBody(themeResource.themeVoteList(Integer.valueOf(request.paths()[1])).toString());
            } else if (request.isEqualsPath(VoteResource.VOTES)) {
                response.setBody(voteResource.voteList().toString());
            } else if (request.isEqualsPath(AccountResource.ACCOUNT + AccountResource.ID)) {
                response.setBody(accountResource.readAccount(Integer.valueOf(request.paths()[1])).toString());
            } else if (request.isEqualsPath(CustomerResource.CUSTOMER + CustomerResource.ID)) {
                response.setBody(customerResource.readCustomer(Integer.valueOf(request.paths()[1])).toString());
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(ThemeResource.THEMES)) {
                themeResource.createTheme(request.getBody());
                response.setStatus(HttpStatus.CREATED);
            } else if (request.isEqualsPath(VoteResource.VOTES)) {
                String themeId = request.getBody().split(":")[0]; // body="themeId:vote"
                String vote = request.getBody().split(":")[1];
                voteResource.createVote(Integer.valueOf(themeId), Integer.valueOf(vote));
                response.setStatus(HttpStatus.CREATED);
            } else if (request.isEqualsPath(AccountResource.ACCOUNT)) {
            		accountResource.createAccount();
                response.setStatus(HttpStatus.CREATED);
            } else if (request.isEqualsPath(CustomerResource.CUSTOMER)) {
            		String customerName = request.getBody().split(":")[0];
            		customerResource.createCustomer(customerName);
                response.setStatus(HttpStatus.CREATED);
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPut(HttpRequest request, HttpResponse response) {
        responseError(response, new RequestInvalidException(request.getPath()));
    }

    public void doPatch(HttpRequest request, HttpResponse response) {
        responseError(response, new RequestInvalidException(request.getPath()));
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
    		try {
    			if (request.isEqualsPath(AccountResource.ACCOUNT + AccountResource.ID)) {
    				String accountId = request.paths()[1];
    				AccountDto dto = accountResource.deleteAccount(Integer.valueOf(accountId));
    				response.setBody(dto.toString());
            } else if (request.isEqualsPath(CustomerResource.CUSTOMER + CustomerResource.ID)) {
				String customerId = request.paths()[1];
				CustomerDto dto = customerResource.deleteCustomer(Integer.valueOf(customerId));
				response.setBody(dto.toString());
            } else {
    		        responseError(response, new RequestInvalidException(request.getPath()));
    			}
    		} catch(Exception e) {
    			responseError(response, e);
    		}
    }

}
