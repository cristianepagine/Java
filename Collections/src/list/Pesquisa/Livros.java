package list.Pesquisa;

import java.util.List;

public class Livros<LivrosTarefa> {
	
	//atributos
	private String titulo;
	private String autor;
	private int anoPublicacao;
	public Livros(String titulo, String autor, int anoPublicacao) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.anoPublicacao = anoPublicacao;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	@Override
	public String toString() {
		return "Titulo=" + titulo + ", Autor=" + autor + ", AnoPublicacao=" + anoPublicacao ;
	}
	
	



}
