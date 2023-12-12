public class Teste {
	

	public static void main(String[] args) {
		boolean sairDoSistema = false;
		BDVeiculos bdVeiculos = new BDVeiculos();


		while (!sairDoSistema) {
			System.out.println("\nSistema de Gestão de Veículos - Menu Inicial");
			System.out.println("1. Cadastrar Veiculo de Passeio");
			System.out.println("2. Cadastrar Veiculo de Carga");
			System.out.println("3. Imprimir Todos os Veiculos de Passeio");
			System.out.println("4. Imprimir Todos os Veiculos de Carga");
			System.out.println("5. Imprimir Veiculo de Passeio pela Placa");
			System.out.println("6. Imprimir Veiculo de Carga pela Placa");
			System.out.println("7. Excluir Veículo de Passeio pela Placa");
			System.out.println("8. Excluir Veículo de Carga pela Placa");
			System.out.println("9. Sair do Sistema");

			
			System.out.print("\nEscolha uma opção: ");

			int opcao = Integer.parseInt(Leitura.entDados(""));

			switch (opcao) {
			case 1:
				bdVeiculos.cadastrarVeiculosPasseio();
				break;
			case 2:
				bdVeiculos.cadastrarVeiculosCarga();
				break;
			case 3:
				bdVeiculos.imprimirVeiculosPasseio();
				break;
			case 4:
				bdVeiculos.imprimirVeiculosCarga();
				break;
			case 5:
				bdVeiculos.placaParaBusca("Passeio");
				break;
			case 6:
				bdVeiculos.placaParaBusca("Carga");
				break;
			case 7:
				bdVeiculos.excluirVeiculoPasseio();
				break;
			case 8:
				bdVeiculos.excluirVeiculoCarga();
				break;
			case 9:
				System.out.println("Saindo do sistema...");
				sairDoSistema = true;
				System.exit(0);

				break;

			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}

	

	

}
