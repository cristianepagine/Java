package set.OperaçoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
	private Set<String> palavras;

	public ConjuntoPalavrasUnicas() {
		super();
		this.palavras = new HashSet<>();
	}

	// Adiciona uma palavra ao conjunto.
	public void adicionarPalavra(String palavra) {
		palavras.add(new String (palavra));
	}

	// Remove uma palavra do conjunto.
	public void removerPalavra(String palavra) {
		if(this.palavras.contains(palavra)) {
			palavras.remove(palavra);
		}
	}

	// Verifica se uma palavra está presente no conjunto.
	public boolean verificarPalavra(String palavra) {
	    return palavras.contains(palavra);

	}

	// Exibe todas as palavras únicas do conjunto.
	public void exibirPalavrasUnicas() {
		System.out.println(palavras);

	}
	 public static void main(String[] args) {
		    // Criando uma instância da classe ConjuntoPalavrasUnicas
		    ConjuntoPalavrasUnicas conjuntoLinguagens = new ConjuntoPalavrasUnicas();

		    // Adicionando linguagens únicas ao conjunto
		    conjuntoLinguagens.adicionarPalavra("Java");
		    conjuntoLinguagens.adicionarPalavra("Python");
		    conjuntoLinguagens.adicionarPalavra("JavaScript");
		    conjuntoLinguagens.adicionarPalavra("Python");
		    conjuntoLinguagens.adicionarPalavra("C++");
		    conjuntoLinguagens.adicionarPalavra("Ruby");

		    // Exibindo as linguagens únicas no conjunto
		    conjuntoLinguagens.exibirPalavrasUnicas();

		    // Removendo uma linguagem do conjunto
		    conjuntoLinguagens.removerPalavra("Ruby");
		    conjuntoLinguagens.exibirPalavrasUnicas();

		   

		    // Verificando se uma linguagem está no conjunto
		    System.out.println("A linguagem 'Java' está no conjunto? " + conjuntoLinguagens.verificarPalavra("C"));
		    System.out.println("A linguagem 'Python' está no conjunto? " + conjuntoLinguagens.verificarPalavra("Python"));

		    // Exibindo as linguagens únicas atualizadas no conjunto
		    conjuntoLinguagens.exibirPalavrasUnicas();
		  }

}
