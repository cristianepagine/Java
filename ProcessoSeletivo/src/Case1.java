import java.util.Scanner;

public class Case1{
    public static void main(String[] args) {
        double salarioBase = 2000;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o salário pretendido");
        double salarioPretendido = scanner.nextDouble();

        if (salarioBase > salarioPretendido)
                System.out.println("LIGAR PARA O CANDIDATO");
            else if (salarioBase == salarioPretendido)
                System.out.println("LIGAR PARA O CANDIDATO, COM CONTRA PROPOSTA");
            else 
                System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS.");
    }
}