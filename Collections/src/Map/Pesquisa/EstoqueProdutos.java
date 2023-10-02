package Map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
	private Map<Long, Produto> estoqueprodutosMap;

	public EstoqueProdutos() {
		super();
		this.estoqueprodutosMap = new HashMap<>();
	}

	public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
		estoqueprodutosMap.put(cod, new Produto(nome, preco, quantidade));
	}

	public void exibirProdutos() {
		System.out.println(estoqueprodutosMap);
	}

	public double calcularValorTotalEstoque() {
		double valortotal = 0;
		if (!estoqueprodutosMap.isEmpty()) {
			for (Produto p : estoqueprodutosMap.values()) {
				valortotal = p.getQuantidade() * p.getPreco();
			}
		}
		return valortotal;
	}

	public Produto obterProdutoMaisCaro() {
		Produto produtoMaisCaro = null;
		double maiorPreco = Double.MIN_VALUE;
		for (Produto p : estoqueprodutosMap.values()) {
			if (p.getPreco() > maiorPreco) {
				produtoMaisCaro = p;
				maiorPreco = p.getPreco();
			}
		}
		return produtoMaisCaro;
	}

	public Produto obterProdutoMaisBarato() {
		Produto produtoMaisBarato = null;
		double menorPreco = Double.MAX_VALUE;
		for (Produto p : estoqueprodutosMap.values()) {
			if (p.getPreco() < menorPreco) {
				produtoMaisBarato = p;
				menorPreco = p.getPreco();
			}
		}
		return produtoMaisBarato;
	}

	public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
		Produto produtoMaiorQuantidadeValorTotalNoEstoque = null;
		double maiorvalorestoque = 0;
		if (!estoqueprodutosMap.isEmpty()) {
			for (Map.Entry<Long, Produto> entry : estoqueprodutosMap.entrySet()) {
				double valorProdutoEmEstoque = entry.getValue().getPreco() * entry.getValue().getQuantidade();
				if (valorProdutoEmEstoque > maiorvalorestoque) {
					maiorvalorestoque = valorProdutoEmEstoque;
					produtoMaiorQuantidadeValorTotalNoEstoque = entry.getValue();
				}
			}

		}
		return produtoMaiorQuantidadeValorTotalNoEstoque;
	}

	public static void main(String[] args) {
		EstoqueProdutos estoque = new EstoqueProdutos();

		// Exibe o estoque vazio
		estoque.exibirProdutos();

		// Adiciona produtos ao estoque
		estoque.adicionarProduto(1L, "Notebook", 1500.0, 1);
		estoque.adicionarProduto(2L, "Mouse", 25.0, 5);
		estoque.adicionarProduto(3L, "Monitor", 400.0, 10);
		estoque.adicionarProduto(4L, "Teclado", 40.0, 2);

		// Calcula e exibe o valor total do estoque
		System.out.println("Valor total do estoque: R$" + estoque.calcularValorTotalEstoque());

		// Obtém e exibe o produto mais caro
		System.out.println("Produto mais caro: " + estoque.obterProdutoMaisCaro());

		// Obtém e exibe o produto mais barato
		System.out.println("Produto mais barato: " + estoque.obterProdutoMaisBarato());

		// Obtém e exibe o produto com a maior quantidade em valor no estoque
		System.out.println("Produto com maior quantidade em valor no estoque: "
				+ estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
	}

}
