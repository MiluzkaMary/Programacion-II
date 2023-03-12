package co.edu.uniquindio.banco.aplication;

import java.util.Scanner;

import co.edu.uniquindio.banco.model.AccountType;
import co.edu.uniquindio.banco.model.CuentaBancaria;
import co.edu.uniquindio.banco.model.Titular;

public class Aplicacion {
	static Scanner read = new Scanner(System.in);
	//static Titular titular1 = new Titular ("Mary","Saire","476399");
	//static CuentaBancaria cuenta = new CuentaBancaria("12345678", AccountType.CUENTA_AHORRO, 100000, titular1); 
	static CuentaBancaria cuenta = new CuentaBancaria();
	
	public static void main(String[] args) throws Exception {
		Titular titular1 = new Titular ("Mary","Saire","476399");
		Titular titular2 = new Titular ("Jose","Reyes","554434");
		cuenta.getListaTitulares().add(titular1);
		cuenta.getListaTitulares().add(titular2);
		
		
		System.out.println("Bienvenidos a la aplicacion de cuenta bancaria");
		menu();
	}

	public static void menu() throws Exception {
		AccountType accountType = null;
		System.out.println("Ingrese una de las siguientes opciones: \n1.consultar mi cuenta bancaria.\n2.consultar el saldo de mi cuenta."
				+ "\n3.consignar valor a mi cuenta.\n4.retirar dinero de mi cuenta.\5.crear titular.\n6.crear cuenta");
		int opcion = Integer.parseInt( read.nextLine());
		
		String mensaje = "";
		String cedula = "";
		
			String accountNumber="";
			switch (opcion) {
			case 1:
				// consultar cuenta
				System.out.println("Ingrese el numero de cuenta bancaria para imprimir la informacion de su cuenta");
				accountNumber  = read.nextLine();
				mensaje = cuenta.consultarCuenta(accountNumber);
				System.out.println(mensaje);
				break;
			case 2:
				// consultar mi saldo
				System.out.println("Ingrese el numero de cuenta bancaria para consultar el saldo de su cuenta");
				accountNumber  = read.nextLine();
				mensaje = cuenta.consultarSaldoCuenta(accountNumber);
				System.out.println(mensaje);
				break;
			case 3:
				// consignar
				System.out.println("Ingrese el numero de cuenta bancaria para consignar");
				accountNumber  = read.nextLine();
				System.out.println("Ingrese la cedula del titular de la cuenta bancaria");
				cedula  = read.nextLine();
				System.out.println("Ingrese el valor de la consignacion bancaria");
				double valorConsignacion  = Double.parseDouble(read.nextLine());
				mensaje = cuenta.consignarSaldoCuenta(accountNumber,cedula,valorConsignacion);
				System.out.println(mensaje);
				break;
			case 4:
				//retirar
				System.out.println("Ingrese el numero de cuenta bancaria para realizar el retiro");
				accountNumber  = read.nextLine();
				System.out.println("Ingrese la cedula del titular de la cuenta bancaria");
				cedula  = read.nextLine();
				System.out.println("Ingrese el valor del retiro bancaria");
				double valorRetiro  = Double.parseDouble(read.nextLine());
				mensaje = cuenta.retiroCuenta(accountNumber,cedula, valorRetiro);
				System.out.println(mensaje);
				break;
			case 5:
				//crear titular
				System.out.println("Ingrese el nombre del titular");
				String name  = read.nextLine();
				System.out.println("Ingrese el apellido del titular");
				String surname  = read.nextLine();
				System.out.println("Ingrese la cedula del titular");
				String codigo  = read.nextLine();
				mensaje = cuenta.crearTitular(name, surname, codigo);
				System.out.println(mensaje);
				break;
			case 6:
				//crear cuenta
				//crearCuentaBancaria(String accountNumber, AccountType accountType, double accountBalance,
				//Titular titular) 
				System.out.println("Ingrese el numero de cuenta");
				String numCuenta  = read.nextLine();
				System.out.println("Ingrese el tipo de cuenta 1.AHORROS, 2.CORRIENTE");
				int tipo  =Integer.parseInt(read.nextLine());
				switch(tipo) {
				case 0:
					accountType=AccountType.CUENTA_AHORRO;
					break;
				case 1:
					accountType=AccountType.CUENTA_CORRIENTE;
					break;
				default:
					System.out.println("Error, Opcion incorrecta");
					break;
				}
				System.out.println("Ingrese el saldo de la cuenta");
				double saldo = Double.parseDouble(read.nextLine());
				System.out.println("Ingrese el codigo del titular");
				String codigoaux  = read.nextLine();
				mensaje = cuenta.crearCuentaBancaria(numCuenta, accountType, saldo, codigoaux);
				System.out.println(mensaje);
				break;
			default:
				menu();
				break;
			}
		
	}
}
