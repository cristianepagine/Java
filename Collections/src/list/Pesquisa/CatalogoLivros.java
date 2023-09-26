package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
	private List<Livros> livrosList;

	public CatalogoLivros() {
		super();
		livrosList = new ArrayList<>();
	}

	public void adicionarLivros(String titulo, String autor, int anoPublicação) {
		livrosList.add(new Livros(titulo, autor, anoPublicação));
	}

	public List<Livros> pesquisarPorAutor(String autor) {
		List<Livros> livrosPorAutor = new ArrayList<>();
		if (!livrosList.isEmpty()) {
			for (Livros l : livrosList) {
				if (l.getAutor().equalsIgnoreCase(autor)) {
					livrosPorAutor.add(l);
				}
			}

		}
		return livrosPorAutor;

	}

	private List<Livros> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
		List<Livros> livrosPorIntervaloAnos = new ArrayList<>();
		if (!livrosList.isEmpty()) {
			for (Livros l : livrosList) {
				if (l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal) {
					livrosPorIntervaloAnos.add(l);

				}
			}
		}
		return livrosPorIntervaloAnos;
	}

	private Livros pesquisarPorTitulo(String titulo) {
		Livros livrosPorTitulo = null;
		if (!livrosList.isEmpty()) {
			for (Livros l : livrosList) {
				if (l.getTitulo().equalsIgnoreCase(titulo)) {
					livrosPorTitulo = l;
					break;
				}
			}

		}
		return livrosPorTitulo;
	}
	
	public static void main(String[] args) {
		
		// Criando uma instância do catálogo de livros
	    CatalogoLivros catalogoLivros = new CatalogoLivros();
		// Adicionando livros ao catálogo
	    catalogoLivros.adicionarLivros("Microsserviços Prontos Para a Produção", "Susan J. Fowler", 2017);
	    catalogoLivros.adicionarLivros("Java Guia do Programador", "Peter Jandl Junior", 2021);
	    catalogoLivros.adicionarLivros("Código Limpo", "Robert C. Martin", 2009);
	    catalogoLivros.adicionarLivros("O Codificador Limpo", "Robert C. Martin", 2012);
	    
	    // Exibindo livros pelo mesmo autor
	    System.out.println(catalogoLivros.pesquisarPorAutor("Robert C. Martin"));

	    // Exibindo livros pelo mesmo autor (caso em que não há livros de um autor específico)
	    System.out.println(catalogoLivros.pesquisarPorAutor("Autor Inexistente"));

	    // Exibindo livros dentro de um intervalo de anos
	    System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2010, 2022));

	    // Exibindo livros dentro de um intervalo de anos (caso em que não há livros no intervalo)
	    System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2025, 2030));

	    // Exibindo livros por título
	    System.out.println(catalogoLivros.pesquisarPorTitulo("Java Guia do Programador"));

	    // Exibindo livros por título (caso em que não há livros com o título especificado)
	    System.out.println(catalogoLivros.pesquisarPorTitulo("Título Inexistente"));


	}

}
