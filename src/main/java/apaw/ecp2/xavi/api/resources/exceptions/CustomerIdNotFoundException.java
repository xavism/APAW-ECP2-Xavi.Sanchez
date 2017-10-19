package apaw.ecp2.xavi.api.resources.exceptions;

public class CustomerIdNotFoundException extends Exception{


	private static final long serialVersionUID = 4111259470926925846L;
	
	public static final String DESCRIPTION = "El id del cliente no existe";

    public CustomerIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public CustomerIdNotFoundException() {
        this("");
    }

}
