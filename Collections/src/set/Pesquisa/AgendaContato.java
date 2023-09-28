package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContato {

	private Set<Contato> contato;

	public AgendaContato() {
		super();
		this.contato = new HashSet<>();
	}

	// Adiciona um contato à agenda.
	public void adicionarContato(String nome, int numero) {
		this.contato.add(new Contato(nome, numero));
	}

	// Exibe todos os contatos da agenda.
	public void exibirContatos() {
		System.out.println(contato);
	}

	// Pesquisa contatos pelo nome e retorna uma conjunto com os contatos
	// encontrados.
	public Set<Contato> pesquisarPorNome(String nome) {
		 Set<Contato> contatosPorNome = new HashSet<>();
		    
		      for (Contato c : contato) {
		        if (c.getNome().startsWith(nome)) {
		          contatosPorNome.add(c);
		        }
		      }
		      return contatosPorNome;
		    
	}

	// Exibe todos os contatos da agenda.
	public Contato atualizarNumeroContato(String nome, int novoNumero) {
		Contato contatoAtualizado = null;
	    if (!contato.isEmpty()) {
	      for (Contato c : contato) {
	        if (c.getNome().equalsIgnoreCase(nome)) {
	          c.setNumero(novoNumero);
	          contatoAtualizado = c;
	          break;
	        }
	      }
	      return contatoAtualizado;
	      
	    } else {
	      throw new RuntimeException("O conjunto está vazio!");
	    }
		
	}

	public static void main(String[] args) {
		// Criando uma instância da classe AgendaContatos
		AgendaContato agendaContatos = new AgendaContato();

		// Adicionando contatos à agenda
		agendaContatos.adicionarContato("João", 123456789);
		agendaContatos.adicionarContato("Maria", 987654321);
		agendaContatos.adicionarContato("Maria Fernandes", 55555555);
		agendaContatos.adicionarContato("Ana", 88889999);
		agendaContatos.adicionarContato("Fernando", 77778888);
		agendaContatos.adicionarContato("Carolina", 55555555);
		agendaContatos.adicionarContato("Carolina ", 55555555);


		// Exibindo os contatos na agenda
		// Pesquisando contatos pelo nome
		System.out.println(agendaContatos.pesquisarPorNome("Maria"));

		// Atualizando o número de um contato
		 Contato contatoAtualizado = agendaContatos.atualizarNumeroContato("Carolina",
		 44443333);
		 System.out.println("Contato atualizado: " + contatoAtualizado);

		// Exibindo os contatos atualizados na agenda
		System.out.println("Contatos na agenda após atualização:");
		 agendaContatos.exibirContatos();
	}

}
