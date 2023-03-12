package co.edu.uniquindio.banco.model;

public enum AccountType {
	
	CUENTA_AHORRO(0),CUENTA_CORRIENTE(1);

	
	/**
	 * Este atributo representa la opcion del switch
	 */
	private int accountType;
	
	/**
	 * Metodo constructor del AccountType
	 * @param accountType
	 */
	private AccountType(int accountType) {
		this.accountType = accountType;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	
	
	public String toString() {	
		String cadena=" ";
		
		switch(accountType){
		case 0:
			cadena="Cuenta de Ahorro";
		break;
		
		case 1:
			cadena="Cuenta corriente";
		break;
		}
		return cadena;
	}

	

}
