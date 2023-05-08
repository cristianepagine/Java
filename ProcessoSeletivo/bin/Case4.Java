public class Case4 {
    public static void main(String[] args) {
        String [] candidatosSelecionados = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};
        for(String candidato : candidatosSelecionados) {
            case4(candidato)
    }
    static void case4(String candidato){
        int tentativas = 1;
        boolean tentarMais = true;
        boolean atendeu = false;
        do {
			atendeu= atender();
			continuarTentando = !atendeu;
			if(continuarTentando)
				tentativasRealizadas++;
			else
				System.out.println("CONTATO REALIZADO COM SUCESSO");
			
		}while(continuarTentando && tentativasRealizadas<3);
		
		if(atendeu)
			System.out.println("CONSEGUIMOS CONTATO COM " + candidato +" NA " + tentativasRealizadas + " TENTATIVA");
		else
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato +", NÚMERO MAXIMO TENTATIVAS " + tentativasRealizadas + " REALIZADA");
    }
    static double tentativas() {
        return ThreadLocalRandom.current().nextDouble(30);
   }
}
