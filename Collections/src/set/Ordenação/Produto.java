package set.Ordenação;

import java.util.Comparator;
import java.util.Objects;

public class Produto implements Comparable<Produto> {
	private long codigo;
	private String nome;
	private double preco;
	private int quantidade;

	public Produto(long codigo, String nome, double preco, int quantidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public long getCod() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	@Override
	public String toString() {
		return "cod=" + codigo + ", nome=" + nome + ", preco=" + preco + ", quantidade=" + quantidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return codigo == other.codigo;
	}

	@Override
	public int compareTo(Produto p) {
		// TODO Auto-generated method stub
	    return nome.compareToIgnoreCase(p.getNome());
	}
}
	class ComparatorPorPreco implements Comparator<Produto> {
		  @Override
		  public int compare(Produto p1, Produto p2) {
		    return Double.compare(p1.getPreco(), p2.getPreco());
		  }
	
	
}
