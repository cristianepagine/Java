package GerenciarBanco;

public abstract class Conta {
	private Cliente cliente;
	private int agencia;
	private int numero;
	private double saldo = 0d;

	/**
	 * @param agencia
	 * @param numero
	 * @param cliente
	 */
	public Conta(Cliente cliente, int agencia, int numero) {
		this.cliente = cliente;
		this.agencia = agencia;
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public abstract String getTipoConta();

	// Método para depositar um valor na conta
	public void depositar(double valor) {
		if (valor > 0) {
			saldo += valor;
			System.out.println("Depósito de " + valor + " realizado com sucesso.");
		} else {
			System.out.println("O valor do depósito deve ser positivo.");
		}
	}

	public void transfere(Conta destino, double valor) {
		this.saldo	=	this.saldo	-	valor;
		destino.saldo	=	destino.saldo	+	valor;

	}
}
