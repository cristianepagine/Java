package GerenciarBanco;

public class ContaCorrente extends Conta {
	public ContaCorrente(Cliente cliente, int agencia, int numero) {
		super(cliente, agencia, numero);
		// TODO Auto-generated constructor stub
	}


		
	@Override
    public String getTipoConta() {
        return "Conta Corrente";
    }
	
	
}
