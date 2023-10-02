package Map.OperaçõesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {

	private Map<String, String> dicionarioMap;

	public Dicionario() {
		super();
		this.dicionarioMap = new HashMap<>();

	}

	public void adicionarPalavras(String palavra, String definicao) {
		dicionarioMap.put(palavra, definicao);
	}

	public void removerPalavra(String palavra) {
		if (!dicionarioMap.isEmpty()) {
			dicionarioMap.remove(palavra);
		}

	}

	public void exibirPalavras() {
		System.out.println(dicionarioMap);
	}

	public String pesquisarPorPalavra(String palavra) {
		String descricaoPorNome = null;
		if (!dicionarioMap.isEmpty()) {
			descricaoPorNome = dicionarioMap.get(palavra);
		}
		return descricaoPorNome;
	}
	
	public static void main(String[] args) {
	    Dicionario dicionario = new Dicionario();

	    // Adicionar palavras (linguagens de programação)
	    dicionario.adicionarPalavras("java", "Linguagem de programação orientada a objetos.");
	    dicionario.adicionarPalavras("typescript", "Superset da linguagem JavaScript que adiciona tipagem estática.");
	    dicionario.adicionarPalavras("kotlin", "Linguagem moderna de programação para a JVM.");

	    // Exibir todas as palavras
	    dicionario.exibirPalavras();

	    // Pesquisar palavras
	    String definicaoJava = dicionario.pesquisarPorPalavra("java");
	    System.out.println("Definição da linguagem 'java': " + definicaoJava);

	    String definicaoCSharp = dicionario.pesquisarPorPalavra("csharp");
	    System.out.println(definicaoCSharp);

	    // Remover uma palavra
	    dicionario.removerPalavra("typescript");
	    dicionario.exibirPalavras();
	  }
}
