package list.OperacoesBasicas.CarrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;


public class CarrinhoDeCompras {
	private List<Item> itemList;
	
	public CarrinhoDeCompras() {
		this.itemList = new ArrayList<>();
	}
	
	//Adiciona um item ao carrinho com o nome, preço e quantidade especificados.
	public void adicionarItem(String nome, double preco, int quantidade) {
		itemList.add(new Item(nome, preco, quantidade));
	}
	
	// Remove um item do carrinho com base no seu nome.
	public void removerItem(String nome) {
		//cria uma lista para ler todas tarefas
				List<Item> itemParaRemover = new ArrayList<>();
				//cria um for para ver se a descrição da tarefa é a que está sendo passada no parametro
				for (Item i : itemList) {			
					if(i.getNome().equalsIgnoreCase(nome)) {
						//adiciona o t do for no metodo de remover
						itemParaRemover.add(i);
					}
				}
				//agora chama o remove all e remove tudo que esta dentro de tarefas para remover
				itemList.removeAll(itemParaRemover);	
				}
	
	
	//Calcula e retorna o valor total do carrinho, levando em consideração o preço e a quantidade de cada ite
	public double calcularValorTotal() {
		
		double valorTotal = 0d;
		for (Item item : itemList) {
			double valorItem = item.getPreco() * item.getQuantidade();
			valorTotal += valorItem;
		}
		return valorTotal;
	}
	
	//Exibe todos os itens presentes no carrinho, mostrando seus nomes, preços e quantidades.	
	public void exibirItens() {
		System.out.println(itemList);

	} 

	public static void main(String[] args) {
		
		//instanciando a classe carrinho de compras
		CarrinhoDeCompras carrinhodecompras = new CarrinhoDeCompras();
		carrinhodecompras.exibirItens();
		
		//gerando a lista de items
		carrinhodecompras.adicionarItem("Banana", 2.0, 1);
		carrinhodecompras.adicionarItem("Maça", 1.0, 1);
		carrinhodecompras.adicionarItem("Uva", 17.58, 5);
		carrinhodecompras.adicionarItem("Pera", 1, 2);
		carrinhodecompras.exibirItens();

		
		carrinhodecompras.removerItem("Pera");
		carrinhodecompras.exibirItens();
		

		System.out.println("O valor total da compra é: " + carrinhodecompras.calcularValorTotal());



	}

}

