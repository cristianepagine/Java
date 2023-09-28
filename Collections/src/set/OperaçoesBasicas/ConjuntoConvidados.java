package set.OperaçoesBasicas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import list.OperacoesBasicas.CarrinhoDeCompras.Item;

public class ConjuntoConvidados {

	private Set<Convidado> convidado;

	public ConjuntoConvidados() {
		super();
		this.convidado = new HashSet<>();
	}

	// Adiciona um convidado ao conjunto.
	public void adicionarConvidado(String nome, int codigoConvite) {
		convidado.add(new Convidado(nome, codigoConvite));
	}

	// Remove um convidado do conjunto com base no código do convite.
	public void removerConvidadoPorCodigoConvite(int codigoConvite) {
		Convidado itemParaRemover = null;
		// cria um for para ver se a descrição da tarefa é a que está sendo passada no
		// parametro
		for (Convidado c : convidado) {
			if (c.getCodigoConvite() == codigoConvite) {
				// adiciona o t do for no metodo de remover
				itemParaRemover = c;
				break;
			}
		}
		// agora chama o remove all e remove tudo que esta dentro de tarefas para
		// remover
		convidado.remove(itemParaRemover);
	}

	

	// Conta o número total de convidados no Set.
	public int contarConvidados() {
		return convidado.size();
	}

	// Exibe todos os convidados do conjunto.

	public void exibirConvidados() {
		System.out.println(convidado);
	}

	public static void main(String[] args) {
		// Criando uma instância da classe ConjuntoConvidados
		ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

		// Adicionando convidados ao conjunto
		conjuntoConvidados.adicionarConvidado("Alice", 1234);
		conjuntoConvidados.adicionarConvidado("Bob", 1235);
		conjuntoConvidados.adicionarConvidado("Charlie", 1235);
		conjuntoConvidados.adicionarConvidado("David", 1236);
		
		//total de convidados
				System.out.println("Total de Convidados no conjunto:" + conjuntoConvidados.contarConvidados());


		// Exibindo os convidados no conjunto
		System.out.println("Convidados no conjunto:");
		conjuntoConvidados.exibirConvidados();

		// removendo um convidado do conjunto
		conjuntoConvidados.removerConvidadoPorCodigoConvite(1234);
		
		//total de convidados
		System.out.println("Total de Convidados no conjunto:" + conjuntoConvidados.contarConvidados());
		

		// Exibindo os convidados no conjunto
		System.out.println("Convidados no conjunto:");
		conjuntoConvidados.exibirConvidados();

	}
}
