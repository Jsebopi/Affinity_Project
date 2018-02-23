package model;

public class ErrorPersonNotExist extends Exception {
	private static final long serialVersionUID = 1L;
	private static final String ERROR_ID_NO_EXISTE = "No Existe la Persona Seleccionada";

	public ErrorPersonNotExist() {
		super(ERROR_ID_NO_EXISTE);
	}
}
