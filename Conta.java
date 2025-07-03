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
	// encapsulamnto: metodos para acessar atributos privados QUEM ACESSA É A CONTA
	// quando for chamdo vai retornar o titular e saldo, GET é usado para acessas algum dado
	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}
	//metodo protegido acessado smente pea subclasse
	//construtor que vai fazer a alteraçãp do valor da conta
	protected void alterarSaldo(double valor) {
		this.saldo += valor;
		
		
	}
	//metodos abstratos: exigem iplementação nas subclasses
	// modelos que dizem como depositar ou sacar
	public abstract void depositar(double valor);
	public abstract void sacar (double valor);
	
}	
//classe cncreta que implementa os metodos abstratos
// classe de conta corrente que extende da classe conta, ou seja, possue todos os dados que a classe conta tem
class ContaCorrente extends Conta{
	//conta vai receber o nome do titular
	public ContaCorrente(String titular) {
		super(titular);
}
	//aqui, se o valor que o titular quiser depositar for maior que 0, será depositado
	public void depositar (double valor) {
		if (valor>0) {
			alterarSaldo(valor);
			System.out.println("deposito de R& "+ valor + " realizado.");
		}
	}
	//para sacar o valor que está sendo solicitado precisa já está na conta, sendo assim, 
	//condição para verificar se tem o valor na conta
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
