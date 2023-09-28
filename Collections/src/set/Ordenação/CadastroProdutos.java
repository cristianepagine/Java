package set.Ordenação;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
	Set<Produto> produtos;

	public CadastroProdutos() {
		super();
		this.produtos = new HashSet<>();
	}

	public void adicionarProduto(long codigo, String nome, double preco, int quantidade) {
		this.produtos.add(new Produto(codigo, nome, preco, quantidade));
	}

	public void exibirProduto() {
		System.out.println(produtos);
	}
	
	public Set<Produto> exibirProdutoPorNome() {
		Set<Produto> exibirprodutopornome = new TreeSet<>(produtos);
		return exibirprodutopornome;
			
		}
	
	public Set<Produto> exibirProdutosPorPreco() {
	    Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
	    if (!produtos.isEmpty()) {
	        produtosPorPreco.addAll(produtos);
	        return produtosPorPreco;
	    } else {
	        throw new RuntimeException("O conjunto está vazio!");
	    }
	}


	public static void main(String[] args) {
		CadastroProdutos produtos = new CadastroProdutos();
		produtos.adicionarProduto(123, "Uva", 3.2, 1);
		produtos.adicionarProduto(1234, "Pera", 1.2, 1);
		produtos.adicionarProduto(1234, "Uva", 1.2, 3);
		produtos.adicionarProduto(12345, "Morango", 7.5, 2);
		produtos.adicionarProduto(123456, "Melão", 0.2, 1);


		produtos.exibirProdutoPorNome();
		// Criando uma instância do CadastroProdutos
	    CadastroProdutos cadastroProdutos = new CadastroProdutos();

	    // Adicionando produtos ao cadastro
	    cadastroProdutos.adicionarProduto(1L, "Smartphone", 1000d, 10);
	    cadastroProdutos.adicionarProduto(2L, "Notebook", 1500d, 5);
	    cadastroProdutos.adicionarProduto(5L, "Mouse", 30d, 20);
	    cadastroProdutos.adicionarProduto(4L, "Teclado", 50d, 15);

	    // Exibindo todos os produtos no cadastro
	    System.out.println(cadastroProdutos.produtos);

	    // Exibindo produtos ordenados por nome
	    System.out.println(cadastroProdutos.exibirProdutoPorNome());

	    // Exibindo produtos ordenados por preço
	    System.out.println(cadastroProdutos.exibirProdutosPorPreco());
	  }

	}

