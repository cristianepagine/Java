package list.Ordenação;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class OrdenacaoNumeros {
	
	private List<Integer> numerosList;
	
	
	public OrdenacaoNumeros() {
		super();
		this.numerosList = new ArrayList<>();
	}

	//Adiciona um número à lista.
	public void adicionarNumero(int numero){
		this.numerosList.add(numero) ;
	}
	
//Ordena os números da lista em ordem ascendente usando a interface Comparable e a class Collections.
		public List<Integer> ordenarAscendente(){
			List<Integer> numerosAscendente =  new ArrayList<>(numerosList);
			Collections.sort(numerosAscendente);
			return numerosAscendente;
		} 
		
		//Ordena os números da lista em ordem descendente usando um Comparable e a class Collections.
		public List<Integer> ordenarDescendente(){
			List<Integer> numerosAscendente =  new ArrayList<>(this.numerosList);
		      numerosAscendente.sort(Collections.reverseOrder());
			return numerosAscendente;
		}
		
		public static void main(String[] args) {
			OrdenacaoNumeros ordenacaonumeros = new OrdenacaoNumeros();
			// Adicionando pessoas à lista
			ordenacaonumeros.adicionarNumero(5);
			ordenacaonumeros.adicionarNumero(7);
			ordenacaonumeros.adicionarNumero(11);
			ordenacaonumeros.adicionarNumero(-1);
			ordenacaonumeros.adicionarNumero(2);
			ordenacaonumeros.adicionarNumero(9);
			
			
			System.out.println(ordenacaonumeros);
			System.out.println(ordenacaonumeros.ordenarAscendente());
			System.out.println(ordenacaonumeros.ordenarDescendente());

		    
			
		}
		
		
}
