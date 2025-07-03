package Banco;

import Banco.ContaCorrente;
import Banco.ContaPoupanca;

public class BancoApp{
	
	public static void main (String[]args) {
		ContaCorrente conta = new ContaCorrente("Davi");
		conta.depositar(1000);
		conta.sacar(250);
		System.out.println("Titular "+conta.getTitular());
		System.out.println("Saldo atual "+conta.getSaldo());
		
		ContaPoupanca conta2 = new ContaPoupanca("Davi");
		conta2.depositar(200);
		conta2.sacar(200);
		System.out.println("Titular "+conta2.getTitular());
		System.out.println("Saldo atual "+conta2.getSaldo());
	}
}