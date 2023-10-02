package Map.OperaçõesBasicas;

import java.util.HashMap;
import java.util.Map;

import set.Pesquisa.AgendaContato;

public class AgendaContatos {

	  private Map<String, Integer> agendaContatoMap;

	public AgendaContatos() {
		super();
		this.agendaContatoMap = new HashMap<>();
	}
	public void adicionarContato(String nome, Integer telefone) {
		agendaContatoMap.put(nome, telefone);
	}
	public void removerContato(String nome) {
		if(!agendaContatoMap.isEmpty()) {
			agendaContatoMap.remove(nome);
		}
	}
	
	public void exibirContatos() {
		System.out.println(agendaContatoMap);
	}
	public Integer pesquisarPorNome(String nome) {
		Integer numeroPorNome = null;
		if(!agendaContatoMap.isEmpty()) {
			numeroPorNome= agendaContatoMap.get(nome);
		}
		return numeroPorNome;
		
	}
	
	public static void main(String[] args) {
		AgendaContatos agendaContatos = new AgendaContatos();

	    // Adicionar contatos
	    agendaContatos.adicionarContato("Camila", 123456);
	    agendaContatos.adicionarContato("João", 5665);
	    agendaContatos.adicionarContato("Carlos", 1111111);
	    agendaContatos.adicionarContato("Ana", 654987);
	    agendaContatos.adicionarContato("Maria", 1111111);
	    agendaContatos.adicionarContato("Camila", 44444);
	    
	    agendaContatos.exibirContatos();
	    
	    agendaContatos.adicionarContato("Cristiane", 323232323);
	    
	    agendaContatos.exibirContatos();

	    agendaContatos.removerContato("Camila");
	    
	    agendaContatos.exibirContatos();
	    
	 // Pesquisar número por nome
	   // String nomePesquisa = "João";
	    //Integer numeroPesquisa = agendaContatos.pesquisarPorNome("João");
	    System.out.println("Número de telefone de " + agendaContatos.pesquisarPorNome("Cristiane"));

	    String nomePesquisaNaoExistente = "Paula";
	    Integer numeroPesquisaNaoExistente = agendaContatos.pesquisarPorNome(nomePesquisaNaoExistente);
	    System.out.println("Número de telefone de " + nomePesquisaNaoExistente + ": " + numeroPesquisaNaoExistente);
	    
	    
	}
}
