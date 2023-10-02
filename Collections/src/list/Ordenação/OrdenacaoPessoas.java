package list.Ordenação;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
	
	private List<Pessoa> pessoasList;

	public OrdenacaoPessoas() {
		super();
		this.pessoasList = new ArrayList<>();
	}
	public void adicionarPessoa(String nome, int idade, double altura) {
		pessoasList.add(new Pessoa(nome, idade, altura));
	}
	//Ordena as pessoas da lista por idade usando a interface Comparable.
	public List<Pessoa> ordenarPorIdade() {
		List<Pessoa> pessoasPorIdade =  new ArrayList<>(pessoasList);
		Collections.sort(pessoasPorIdade);
		return pessoasPorIdade;
	} 
	//: Ordena as pessoas da lista por altura usando um Comparator personalizado.
	public List<Pessoa> ordenarPorAltura() {
		List<Pessoa> pessoasPorAltura =  new ArrayList<>(pessoasList);
		Collections.sort(pessoasPorAltura, new ordenarPorAltura());
		return pessoasPorAltura;

	}
	 public static void main(String[] args) {
		  // Criando uma instância da classe OrdenacaoPessoas
		    OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();

		    // Adicionando pessoas à lista
		    ordenacaoPessoas.adicionarPessoa("Alice", 20, 1.56);
		    ordenacaoPessoas.adicionarPessoa("Bob", 30, 1.80);
		    ordenacaoPessoas.adicionarPessoa("Charlie", 25, 1.70);
		    ordenacaoPessoas.adicionarPessoa("David", 17, 1.56);

		    // Exibindo a lista de pessoas adicionadas
		    System.out.println(ordenacaoPessoas.pessoasList);

		    // Ordenando e exibindo por idade
		    System.out.println(ordenacaoPessoas.ordenarPorIdade());

		    // Ordenando e exibindo por altura
		    System.out.println(ordenacaoPessoas.ordenarPorAltura());
		  }
}


