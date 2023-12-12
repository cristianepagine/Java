package GerenciarBanco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteBanco {
	private static List<Cliente> clientes = new ArrayList<Cliente>();
	private static List<ContaPoupanca> poupancas = new ArrayList<ContaPoupanca>();
	private static List<ContaCorrente> correntes = new ArrayList<ContaCorrente>();
	private static List<Conta> contas = new ArrayList<>();

	static boolean sairDoSistema = false;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (!sairDoSistema) {
			System.out.println("\nSistema de Gestão de Contas - Menu Inicial");
			System.out.println("1. Cadastrar Cliente");
			System.out.println("2. Listar Cliente");
			System.out.println("3. Cadastrar Conta Poupança");
			System.out.println("4. Cadastrar Conta Corrente");
			System.out.println("5. Listar Contas");
			System.out.println("6. Excluir Contas");
			System.out.println("7. Depositar Conta Corrente");
			System.out.println("8. Depositar Conta Poupança");
			System.out.println("9. Atualizar Rendimentos Poupança");
			System.out.println("10. Transferir saldo entre contas");
			System.out.println("11. Sair do Sistema");
			System.out.print("\nEscolha uma opção: ");

			int opcao = scanner.nextInt();
			scanner.nextLine(); // Consuma a nova linha pendente

			switch (opcao) {
			case 1:
				cadastrarCliente();
				break;
			case 2:
				listarClientes();
				break;
			case 3:
				cadastrarContaPoupanca();
				break;
			case 4:
				cadastrarContaCorrente();
				break;

			case 5:
				listarContas();
				break;

			case 6:
				excluirContas();
				break;

			case 7:
				depositarContaCorrente();
				break;

			case 8:
				depositarContaPoupanca();

				break;

			case 9:
				atualizarRendimentosPoupanca();
				break;

			case 10:
				transferirSaldoEntreContas();
				break;

			case 11:
				sairDoSistema = true;
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		}
	}

	private static void transferirSaldoEntreContas() {
		//busca dos dados da origem da transferencia	
		System.out.print("\nCPF do Cliente Origem: ");
		String cpfOrigem = scanner.nextLine();

		Cliente cliOrigem = buscarClientePorCpf(cpfOrigem);
		if (cliOrigem == null) {
			System.out.println("\nCliente Origem não encontrado para este CPF.");
			return;
		}
		System.out.print("\nNumero da Conta de origem: ");
		int numeroOrigem = scanner.nextInt();

		Conta contaOrigem = buscarContaPorClienteENumero(cpfOrigem, numeroOrigem);
		if (contaOrigem == null) {
			System.out.println("\nConta Origem não encontrada para este CPF.");
			return;
		}
	    scanner.nextLine(); // Consumir a nova linha pendente

		
		//busca dos dados do destino da transferencia		
		System.out.print("\nCPF do Cliente Destino: ");
		String cpfDestino = scanner.nextLine();

		Cliente cliDestino = buscarClientePorCpf(cpfDestino);
		if (cliDestino == null) {
			System.out.println("\nCliente Destino não encontrado para este CPF.");
			return;
		}
		System.out.print("\nNumero da Conta de destino: ");
		int numeroDestino = scanner.nextInt();

		Conta contaDestino = buscarContaPorClienteENumero(cpfDestino, numeroDestino);
		if (contaDestino == null) {
			System.out.println("\nConta DEstino não encontrada para este CPF.");
			return;
		}
		
		//solicita valor da transferencia
		System.out.print("Valor a ser transferido: ");
	    double valorTransferencia = scanner.nextDouble();
	    
	    //transferencia
	    contaOrigem.transfere(contaDestino, valorTransferencia);
	    System.out.println("\nTransferencia realizada com sucesso da conta" + contaOrigem + "para a conta" + contaDestino + "no valor de" + valorTransferencia );

	}
	
	

	public static Conta buscarContaPorClienteENumero(String cpf, int numero) {
		for (Conta conta : contas) {
			if (conta != null && conta.getCliente().getCpf().equals(cpf) && conta.getNumero() == numero) {

				return conta;
			}
		}
		return null;
	}

	private static void atualizarRendimentosPoupanca() {
		System.out.print("\nCPF do Cliente: ");
		String cpf = scanner.nextLine();

		Cliente cli = buscarClientePorCpf(cpf);
		if (cli == null) {
			System.out.println("\nCliente não encontrado para este CPF.");
			return;
		}
		for (Conta conta : contas) {
			if (conta != null && conta.getCliente().getCpf().equals(cpf)) {
				if (conta instanceof ContaPoupanca) {
					ContaPoupanca poupanca = (ContaPoupanca) conta;

					System.out.println("Informe a taxa de juros");
					double taxaDeJuros = scanner.nextDouble();
					poupanca.atualizarRendimentos(taxaDeJuros);
				}
			}
		}

	}

	private static void depositarContaPoupanca() {
		System.out.print("\nCPF do Cliente: ");
		String cpf = scanner.nextLine();

		Cliente cli = buscarClientePorCpf(cpf);
		if (cli == null) {
			System.out.println("\nCliente não encontrado para este CPF.");
			return;
		}
		for (Conta conta : contas) {
			if (conta != null && conta.getCliente().getCpf().equals(cpf)) {
				if (conta instanceof ContaPoupanca) {
					ContaPoupanca poupanca = (ContaPoupanca) conta;
					System.out.println("Informe o valor que deseja depositar");
					double valor = scanner.nextDouble();
					// double saldoAtual = conta.getSaldo();
					// conta.setSaldo(saldoAtual + valor);
					poupanca.depositar(valor);
					break; // Encontrou a conta, podemos parar a iteração
				} else
					System.out.println("\nNão existe conta Poupança para esse cliente");
			}
		}
	}

	private static void depositarContaCorrente() {
		System.out.print("\nCPF do Cliente: ");
		String cpf = scanner.nextLine();

		Cliente cli = buscarClientePorCpf(cpf);
		if (cli == null) {
			System.out.println("\nCliente não encontrado para este CPF.");
			return;
		}
		for (Conta conta : contas) {
			if (conta != null && conta.getCliente().getCpf().equals(cpf)) {
				if (conta instanceof ContaCorrente) {
					System.out.println("Informe o valor que deseja depositar");
					double valor = scanner.nextDouble();
					double saldoAtual = conta.getSaldo();
					conta.setSaldo(saldoAtual + valor);
					break; // Encontrou a conta, podemos parar a iteração
				} else
					System.out.println("\nNão existe conta Corrente para esse cliente");
			}
		}

	}

	private static void excluirContas() {

		System.out.print("\nCPF do Cliente: ");
		String cpf = scanner.nextLine();

		Cliente cliente = buscarClientePorCpf(cpf);
		if (cliente == null) {
			System.out.println("\nCliente não encontrado para este CPF.");
			return;
		}

		Conta contaRemovida = null;
		for (Conta conta : contas) {
			if (conta != null && conta.getCliente().getCpf().equals(cpf)) {
				contaRemovida = conta;
				break; // Encontrou a conta, podemos parar a iteração
			}
		}

		if (contaRemovida != null) {
			contas.remove(contaRemovida);
			System.out.println("Conta do cliente " + cliente.getNome() + " removida com sucesso.");
		} else {
			System.out.println("Não foi encontrada conta para o cliente " + cliente.getNome());
		}

	}

	private static void listarContas() {
		System.out.println("\nLista de Contas Cadastradas");

		for (Conta conta : contas) {
			System.out.println("\nCliente Nome:" + conta.getCliente().getNome());
			System.out.println("\nCliente CPF:" + conta.getCliente().getCpf());
			System.out.println("\nTipo de Conta: " + conta.getTipoConta());
			System.out.println("\nAgencia:" + conta.getAgencia());
			System.out.println("\nNumero:" + conta.getNumero());
			System.out.println("\nSaldo: " + conta.getSaldo());
			System.out.println("\n");
		}
	}

	private static void cadastrarContaCorrente() {
		System.out.print("\nCPF do Cliente: ");
		String cpf = scanner.nextLine();

		Cliente cliente = buscarClientePorCpf(cpf);

		if (cliente == null) {
			System.out.println("\nCliente não encontrado para este CPF.");
			return;
		}

		if (contaJaCadastrada(cpf)) {
			System.out.println("\nJá existe uma conta com este CPF.");
			return;
		}

		System.out.println("Agencia: ");
		int agencia = scanner.nextInt();

		System.out.print("Numero: ");
		int numero = scanner.nextInt();
		scanner.nextLine(); // Consumir a nova linha pendente

		ContaCorrente novaCorrente = new ContaCorrente(cliente, agencia, numero);
		correntes.add(novaCorrente);
		contas.add(novaCorrente);
	}

	private static void cadastrarContaPoupanca() {
		System.out.print("\nCPF do Cliente: ");
		String cpf = scanner.nextLine();

		Cliente cliente = buscarClientePorCpf(cpf);

		if (cliente == null) {
			System.out.println("\nCliente não encontrado para este CPF.");
			return;
		}

		if (contaJaCadastrada(cpf)) {
			System.out.println("\nJá existe uma conta com este CPF.");
			return;
		}

		System.out.println("Agencia: ");
		int agencia = scanner.nextInt();

		System.out.print("Numero: ");
		int numero = scanner.nextInt();
		scanner.nextLine(); // Consumir a nova linha pendente

		ContaPoupanca novaPoupanca = new ContaPoupanca(cliente, agencia, numero);
		poupancas.add(novaPoupanca);
		contas.add(novaPoupanca);
	}

	public static Cliente buscarClientePorCpf(String cpf) {
		for (Cliente cliente : clientes) {
			if (cliente != null && cpf.equals(cliente.getCpf())) {
				return cliente;
			}
		}
		return null; // o cliente não está cadastrado
	}

	public static boolean contaJaCadastrada(String cpf) {
		for (Conta conta : contas) {
			if (conta != null && conta instanceof ContaPoupanca
					&& cpf.equals(((ContaPoupanca) conta).getCliente().getCpf())) {
				return true;
			}
		}
		return false; // o cliente não está cadastrado
	}

	public static void cadastrarCliente() {
		Cliente novoCliente = new Cliente();

		System.out.print("\nCPF do Cliente: ");
		String cpf = scanner.nextLine();

		if (clienteJaCadastrado(cpf)) {
			System.out.println("\nJá existe um cliente com este CPF.");
			return; // Retornar para o menu após mensagem de cliente já cadastrado
		}
		novoCliente.setCpf(cpf);

		System.out.print("Nome do Cliente: ");
		String nome = scanner.nextLine();
		novoCliente.setNome(nome);

		System.out.print("Email do Cliente: ");
		String email = scanner.nextLine();
		novoCliente.setEmail(email);

		clientes.add(novoCliente);
	}

	public static boolean clienteJaCadastrado(String cpf) {
		for (Cliente cliente : clientes) {
			if (cliente != null && cpf.equals(cliente.getCpf())) {
				return true;
			}
		}
		return false; // o cliente não está cadastrado
	}

	public static void listarClientes() {
		System.out.println("\nLista de Clientes:");

		for (Cliente cliente : clientes) {
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("Email: " + cliente.getEmail());
			System.out.println("CPF: " + cliente.getCpf());
			System.out.println();
		}
	}
}
