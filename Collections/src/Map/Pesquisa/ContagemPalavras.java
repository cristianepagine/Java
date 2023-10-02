package Map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {

	private Map<String, Integer> palavrasMap;

	public ContagemPalavras() {
		super();
		this.palavrasMap = new HashMap<>();
	}

	public void adicionarPalavra(String palavra, Integer contagem) {
		palavrasMap.put(palavra, contagem);
	}

	public void exibirPalavra() {
		System.out.println(palavrasMap);
	}

	public void removerPalavra(String palavra) {
		palavrasMap.remove(palavra);
	}

	public int exibirContagemPalavras() {
		int contagemTotal = 0;
		for (int contagem : palavrasMap.values()) {
			contagemTotal += contagem;
		}
		return contagemTotal;
	}

	public String encontrarPalavrasMaisFrequente() {
		String linguagemMaisFrequente = null;
		int maiorContagem = 0;
		for (Map.Entry<String, Integer> entry : palavrasMap.entrySet()) {
			if (entry.getValue() > maiorContagem) {
				maiorContagem = entry.getValue();
				linguagemMaisFrequente = entry.getKey();
			}
		}
		return linguagemMaisFrequente;
	}

	public static void main(String[] args) {
		ContagemPalavras contagemLinguagens = new ContagemPalavras();

		// Adiciona linguagens e suas contagens
		contagemLinguagens.adicionarPalavra("Java", 2);
		contagemLinguagens.adicionarPalavra("Python", 8);
		contagemLinguagens.adicionarPalavra("JavaScript", 1);
		contagemLinguagens.adicionarPalavra("C#", 6);
		contagemLinguagens.exibirPalavra();
		contagemLinguagens.removerPalavra("Java");
		contagemLinguagens.exibirPalavra();
		System.out.println("contagem " + contagemLinguagens.exibirContagemPalavras());
		System.out.println("Mais Frequente " + contagemLinguagens.encontrarPalavrasMaisFrequente());

	}
}
