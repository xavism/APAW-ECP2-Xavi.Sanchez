package apaw.ecp2.xavi.api.resources.exceptions;

public class AccountIdNotFoundException extends Exception{

	private static final long serialVersionUID = 339183095797906872L;

    public static final String DESCRIPTION = "El id de la cuenta no existe";

    public AccountIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public AccountIdNotFoundException() {
        this("");
    }

}
