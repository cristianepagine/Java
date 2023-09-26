package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
	private List<Integer> numeros;

	public SomaNumeros() {

		this.numeros = new ArrayList<>();
	}

	public void adicionarNumero(int numero) {
		this.numeros.add(numero);

	}

	// Retorna uma lista contendo todos os números presentes na lista.
	public void exibirNumeros() {
		if (!numeros.isEmpty()) {
			System.out.println(this.numeros);

		} else {
			System.out.println("A lista está vazia");
		}
	}

	// Calcula a soma de todos os números na lista e retorna o resultado.
	public int calcularSoma() {
		int soma = 0;
		for (Integer numeros : numeros) {
			soma += numeros;

		}
		return soma;
	}
	
	
	//Encontra o maior número na lista e retorna o valor.
	public int encontrarMaiorNumero() {
		if (numeros.isEmpty()) {
            System.out.println("A lista está vazia, não é possível encontrar o maior número.");
            return 0;
        }

        int maior = numeros.get(0);
        for (Integer num : numeros) {
            if (num > maior) {
                maior = num;
            }
        }
        return maior;
		
	}
	//Encontra o menor número na lista e retorna o valor.
	public int encontrarMenorNumero() {
		if (numeros.isEmpty()) {
            System.out.println("A lista está vazia, não é possível encontrar o menor número.");
            return 0;
        }

        int menor = numeros.get(0);
        for (Integer num : numeros) {
            if (num < menor) {
                menor = num;
            }
        }
        return menor;
		
	}
	
	


	public static void main(String[] args) {
		// Criando uma instância da classe SomaNumeros
		SomaNumeros somaNumeros = new SomaNumeros();

		// Adicionando números à lista
		somaNumeros.adicionarNumero(5);
		somaNumeros.adicionarNumero(0);
		somaNumeros.adicionarNumero(0);
		somaNumeros.adicionarNumero(-1);
		somaNumeros.adicionarNumero(10);

		// Exibindo a lista de números adicionados
		 System.out.println("A lista de números é:");
		somaNumeros.exibirNumeros();
		
		//Exibindo a soma dos números
		System.out.println("A soma dos números é: " + somaNumeros.calcularSoma());
		
		//Exibindo o maior numero
		System.out.println("O maior numero é:" + somaNumeros.encontrarMaiorNumero());
		
		//Exibindo o menor numero
				System.out.println("O menor numero é:" + somaNumeros.encontrarMenorNumero());
	}

}
