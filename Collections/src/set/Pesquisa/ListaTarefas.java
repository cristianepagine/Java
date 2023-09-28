package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
	Set<Tarefa> tarefas;

	public ListaTarefas() {
		super();
		this.tarefas = new HashSet<>();
	}

	public void adicionarTarefa(String descricao) {
		tarefas.add(new Tarefa(descricao));
	}

	public void exibirTarefas() {
		System.out.println(tarefas);
	}

	public void removerTarefas(String descricao) {
		Tarefa tarefaParaRemover = null;
		for (Tarefa t : tarefas) {
			if (t.getDescricao() == descricao) {
				tarefaParaRemover = t;
				break;
			}
		}
		tarefas.remove(tarefaParaRemover);
	}

	public int contarTarefas() {
		return tarefas.size();
	}

	public void limparListaTarefas() {
		tarefas.removeAll(tarefas);
	}

	public void marcarTarefaConcluida(String descricao) {
		for (Tarefa t : tarefas) {
			if (t.getDescricao().equalsIgnoreCase(descricao)) {
				t.setConcluida(true);
			}
		}
	}

	public void marcarTarefaPendente(String descricao) {
		Tarefa marcartarefapendente = null;
		for (Tarefa t : tarefas) {
			if (t.getDescricao().equalsIgnoreCase(descricao)) {
				marcartarefapendente = t;
				break;
			}
		}
		if (marcartarefapendente != null) {
			if (marcartarefapendente.isConcluida()) {
				marcartarefapendente.setConcluida(false);
			}
		} else {
			System.out.println("Tarefa não encontrada na lista.");
		}
	}

	public Set<Tarefa> obterTarefasConcluidas() {
		Set<Tarefa> tarefasconcluidas = new HashSet<>();
		for (Tarefa t : tarefas) {
			if (t.isConcluida() == true) {
				tarefasconcluidas.add(t);
			}
		}
		return tarefasconcluidas;
	}

	public Set<Tarefa> obterTarefasPendentes() {
		Set<Tarefa> tarefaspendentes = new HashSet<>();
		for (Tarefa t : tarefas) {
			if (t.isConcluida() == false) {
				tarefaspendentes.add(t);
			}
		}
		return tarefaspendentes;

	}

	public static void main(String[] args) {
		ListaTarefas listatarefas = new ListaTarefas();

		listatarefas.adicionarTarefa("Estudar Java");
		listatarefas.adicionarTarefa("Fazer exercícios físicos");
		listatarefas.adicionarTarefa("Organizar a mesa de trabalho");
		listatarefas.adicionarTarefa("Ler livro");
		listatarefas.adicionarTarefa("Preparar apresentação");

		// Exibindo as tarefas na lista
		listatarefas.exibirTarefas();

		// Removendo uma tarefa
		listatarefas.removerTarefas("Fazer exercícios físicos");
		listatarefas.exibirTarefas();

		// Contando o número de tarefas na lista
		System.out.println("Total de tarefas na lista: " + listatarefas.contarTarefas());

		// Obtendo tarefas pendentes
		System.out.println("Tarefas Pendentes: " + listatarefas.obterTarefasPendentes());

		// Marcando tarefas como concluídas
		listatarefas.marcarTarefaConcluida("Ler livro");
		listatarefas.marcarTarefaConcluida("Estudar Java");
		listatarefas.marcarTarefaConcluida("Fazer exercícios físicos");
		listatarefas.marcarTarefaConcluida("Organizar a mesa de trabalho");

		// Obtendo tarefas concluídas
		System.out.println("Tarefas concluidas: " + listatarefas.obterTarefasConcluidas());

		// Marcando tarefas como pendentes
		listatarefas.marcarTarefaPendente("Estudar Java");

		// Obtendo tarefas pendentes
		System.out.println("Tarefas Pendentes: " + listatarefas.obterTarefasPendentes());

		// Limpando a lista de tarefas
		listatarefas.limparListaTarefas();
		listatarefas.exibirTarefas();

		// Limpando a lista de tarefas
		listatarefas.limparListaTarefas();
		listatarefas.exibirTarefas();

	}

}
