package Banco;

import Banco.Conta;

abstract class Conta {
	private String titular;
	private double saldo;
	// criando a conta com as informações iniciais
	public Conta (String titular) {
		this.titular= titular;
		this.saldo=0.0;
	}
	// Métodos para acessar atributos privados
	// Quando for chamdo vai retornar o titular e saldo
	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}
	
	//Construtor que vai fazer a alteraçãp do valor da conta
	protected void alterarSaldo(double valor) {
		this.saldo += valor;
		
		
	}
	
	// Modelos que dizem como depositar ou sacar
	public abstract void depositar(double valor);
	public abstract void sacar (double valor);
	
}	

// Classe de conta corrente que extende da classe conta
class ContaCorrente extends Conta{
	//Conta vai receber o nome do titular
	public ContaCorrente(String titular) {
		super(titular);
}
	//Será depositado omente se o valor for maior que 0
	public void depositar (double valor) {
		if (valor>0) {
			alterarSaldo(valor);
			System.out.println("deposito de R& "+ valor + " realizado.");
		}
	}
	
	//Condição para verificar se tem o valor na conta
	public void sacar (double valor) {
		if(valor>0 && getSaldo()>=valor) {
			alterarSaldo(-valor);
			System.out.println(" Saque de R$ "+ valor + " realizado.");
		}else {
			System.out.println(" Saldo insuficiente.");
		}
	}
}


class ContaPoupanca extends Conta{
	public ContaPoupanca (String titular) {
		super(titular);
	}
	public void depositar (double valor) {
		if (valor>0) {
			alterarSaldo(valor);
			System.out.println("deposito de R& "+ valor + " realizado.");
		}
	}
	public void sacar (double valor) {
		if(getSaldo()>500 && getSaldo()>=valor) {
			alterarSaldo(-valor);
			System.out.println("Saque de R$ "+ valor + " realizado.");
		}else {
			System.out.println("Saldo insuficiente para saque.");
		}
	
	}
}
