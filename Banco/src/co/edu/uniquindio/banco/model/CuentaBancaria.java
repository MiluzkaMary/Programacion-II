package co.edu.uniquindio.banco.model;

import java.util.ArrayList;




public class CuentaBancaria {
	Titular titular1 = new Titular ("Mary","Saire","476399");

	private String accountNumber;
	private AccountType accountType;
	private double accountBalance=0;
	private Titular titular;
	private ArrayList<Titular> listaTitulares;
	private ArrayList<CuentaBancaria> listaCuentasBancarias;
	
	
	public CuentaBancaria() {
		
	}
	

	/**
	 * Este es el metodo constructor de la clase 
	 * @param 
	 * @param 
	 * @param 
	 */

	public CuentaBancaria(String accountNumber, AccountType accountType, double accountBalance, Titular titular) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.titular = titular;
		this.listaTitulares = new ArrayList<Titular>();
		this.listaCuentasBancarias = new ArrayList<CuentaBancaria>();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public ArrayList<Titular> getListaTitulares() {
		return listaTitulares;
	}


	public void setListaTitulares(ArrayList<Titular> listaTitulares) {
		this.listaTitulares = listaTitulares;
	}


	public ArrayList<CuentaBancaria> getListaCuentasBancarias() {
		return listaCuentasBancarias;
	}


	public void setListaCuentasBancarias(ArrayList<CuentaBancaria> listaCuentasBancarias) {
		this.listaCuentasBancarias = listaCuentasBancarias;
	}


	public AccountType getAccountType() {
		return accountType;
	}


	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}


	public double getAccountBalance() {
		return accountBalance;
	}


	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}


	public Titular getTitular() {
		return titular;
	}


	public void setTitular(Titular titular) {
		this.titular = titular;
	}




	/**
	 * Este metodo permite crear un Titular
	 * @param nombres
	 * @param apellidos
	 * @param cedula
	 * @throws Exception 
	 */
	public String crearTitular(String nombres, String apellidos, String cedula) throws Exception{
		
		String mensaje = "El titular ha sido registrado";
		boolean titularEncontrado = verificarTitular(cedula);
		if( titularEncontrado == true){
			throw new Exception("El titular ya existe");
		}else{
			Titular nuevoTitular = new Titular(nombres, apellidos, cedula);
			listaTitulares.add(nuevoTitular);
		}
		return mensaje;
	}
	
	/**
	 * 
	 * @param cedula
	 * @return
	 */
	private boolean verificarTitular(String cedula) {
		boolean verificado = false;	
		if(!listaTitulares.isEmpty()) {
			for (Titular titularaux : listaTitulares) {
				if(titularaux.getCedula().equals(cedula)){
					verificado = true;
					return verificado;
				}
			}
		}
		return verificado;
	}
	
	/**
	 * Este metodo permite crear un Titular
	 * @param nombres
	 * @param apellidos
	 * @param cedula
	 * @throws Exception 
	 */
	public String crearCuentaBancaria(String accountNumber, AccountType accountType, double accountBalance,
			String cedulaTitular) throws Exception{
		
		String mensaje = "La cuenta ha sido registrada";
		boolean cuentaEncontrada = verificarCuenta(accountNumber);
		boolean titularEncontrado = verificarTitular(cedulaTitular);
		if( cuentaEncontrada == true || titularEncontrado == false ){
			throw new Exception("La cuenta ya existe o el titular no fue encontrado");
		}else{
			for (Titular tituaux : listaTitulares) {
				if(tituaux.getCedula().equals(cedulaTitular)) {
					CuentaBancaria cuentaBancaria = new CuentaBancaria(accountNumber, accountType, accountBalance,tituaux);
					listaCuentasBancarias.add(cuentaBancaria);
				}
			}
			
		}
		return mensaje;
	}


	private boolean verificarCuenta(String accountNumber) {
		boolean verificado = false;		
		for (CuentaBancaria cuentaaux : listaCuentasBancarias) {
			if(cuentaaux.getAccountNumber().equals(accountNumber)){
				verificado = true;
				return verificado;
			}
		}
		return verificado;
	}
	
	
	/**
	 * Consultar cuenta bancaria
	 * 
	 * @param accountNumber
	 * @return
	 */
	public String consultarCuenta(String accountNumber) {
		String message="cuenta no encontrada";
		for (CuentaBancaria cuentaaux : listaCuentasBancarias) {
			if(cuentaaux.getAccountNumber().equals(accountNumber)){
				message=cuentaaux.toString();
				return message;
			}
		}
		return message;
	}	
	
	/**
	 * Consultar saldo cuenta bancaria
	 * 
	 * @param accountNumber
	 * @return
	 */
	public String consultarSaldoCuenta(String accountNumber) {
		String message="cuenta no encontrada";
		for (CuentaBancaria cuentaaux : listaCuentasBancarias) {
			if(cuentaaux.getAccountNumber().equals(accountNumber)){
				message="El saldo es --> "+String.valueOf(cuentaaux.getAccountBalance());
				return message;
			}
		}
		return message;
	}	
	
	/**
	 * Consultar consignar saldo a cuenta bancaria
	 * 
	 * @param accountNumber
	 * @return
	 */
	public String consignarSaldoCuenta(String accountNumber, String cedulaTitular, double consignacion) {
		String message="cuenta no encontrada";
		for (CuentaBancaria cuentaaux : listaCuentasBancarias) {
			if(cuentaaux.getAccountNumber().equals(accountNumber) && cedulaTitular.equals(cuentaaux.getTitular().getCedula())){
				double cuentaSaldo=cuentaaux.getAccountBalance();
				cuentaSaldo+=consignacion;
				cuentaaux.setAccountBalance(cuentaSaldo);
				message="Consignacion terminada. El saldo es --> "+String.valueOf(cuentaaux.getAccountBalance());
				return message;
			}
		}
		return message;
	}
	
	/**
	 * Consultar retirar dinero a cuenta bancaria
	 * 
	 * @param accountNumber
	 * @return
	 */
	public String retiroCuenta(String accountNumber, String cedulaTitular, double retiro) {
		String message="cuenta no encontrada";
		for (CuentaBancaria cuentaaux : listaCuentasBancarias) {
			if(cuentaaux.getAccountNumber().equals(accountNumber) && cedulaTitular.equals(cuentaaux.getTitular().getCedula())){
				if((cuentaaux.getAccountBalance()-retiro)>=0) {
				double cuentaSaldo=cuentaaux.getAccountBalance();
				cuentaSaldo-=retiro;
				cuentaaux.setAccountBalance(cuentaSaldo);
				message="Retiro terminado. El saldo es --> "+String.valueOf(cuentaaux.getAccountBalance());
				return message;
				}else {
				return "saldo insuficiente";
				}
			}
		}
		return message;
	}
	
	
	
	@Override
	public String toString() {
		return "CuentaBancaria [accountNumber=" + accountNumber + ", accountType=" + accountType + ", accountBalance="
				+ accountBalance + ", titular=" + titular + "]";
	}

}
