package list.OperacoesBasicas.ListaTarefas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
	private List<Tarefa> tarefaList;

	public ListaTarefa() {
		this.tarefaList = new ArrayList<>();
	}
	
	public void adicionarTarefa(String descricao) {
		tarefaList.add(new Tarefa(descricao));
	}
	
	public void removerTarefa(String descricao) {
		//cria uma lista para ler todas tarefas
		List<Tarefa> tarefasParaRemover = new ArrayList<>();
		//cria um for para ver se a descrição da tarefa é a que está sendo passada no parametro
		for (Tarefa t : tarefaList) {			
			if(t.getDescricao().equalsIgnoreCase(descricao)) {
				//adiciona o t do for no metodo de remover
				tarefasParaRemover.add(t);
			}
		}
		//agora chama o remove all e remove tudo que esta dentro de tarefas para remover
		tarefaList.removeAll(tarefasParaRemover);
		
	}
	
	public int obterNumeroTotalTarefas() {
		return tarefaList.size();
		
	}
	
	public void obterDescricoesTarefa() {
		System.out.println(tarefaList);
	}
	
	//testes dos metodos
	public static void main(String[] args) {
		
		ListaTarefa listaTarefa = new ListaTarefa();
		System.out.println("o numero total de tarfas é: " + listaTarefa.obterNumeroTotalTarefas());

		listaTarefa.adicionarTarefa("tarefa1");
		listaTarefa.adicionarTarefa("tarefa2");
		listaTarefa.adicionarTarefa("tarefa1");

		System.out.println("o numero total de tarfas é: " + listaTarefa.obterNumeroTotalTarefas());
		listaTarefa.obterDescricoesTarefa();

		
		listaTarefa.removerTarefa("tarefa1");
		System.out.println("o numero total de tarfas é: " + listaTarefa.obterNumeroTotalTarefas());
		listaTarefa.obterDescricoesTarefa();


	}

}
