package GerenciarBanco;

import java.util.Date;

public class ContaPoupanca extends Conta {

	/**
	 * @param cliente
	 * @param agencia
	 * @param numero
	 */
	public ContaPoupanca(Cliente cliente, int agencia, int numero) {
		super(cliente, agencia, numero);
		// TODO Auto-generated constructor stub
	}

	// Método para atualizar os rendimentos da conta poupança
	public void atualizarRendimentos(double taxaDeJuros) {
		// Verifica se a taxa de juros é válida (positiva)
		if (taxaDeJuros <= 0) {
			System.out.println("A taxa de juros deve ser um valor positivo.");
			return;
		}

		// Calcula os rendimentos com base na taxa de juros
		double rendimento = getSaldo() * (taxaDeJuros / 100);
		depositar(rendimento); // Adiciona os rendimentos ao saldo da poupança
		System.out.println("Rendimentos atualizados com sucesso. Rendimento: " + rendimento);
	}

	@Override
	public String getTipoConta() {
		return "Conta Poupança";
	}

	// Implementação do método depositar para a ContaPoupanca
	@Override
	public void depositar(double valor) {
		super.depositar(valor);
	}
}
