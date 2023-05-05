import java.util.Scanner;
import java.util.Locale;

public class ContaTerminal{

public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        
     
        double saldo = 1200;

            System.out.println("Digite o número da conta: ");
            int numeroConta = scanner.nextInt();

            System.out.println("Digite o número da Agencia: ");
            String agencia = scanner.next();

            System.out.println("Digite o seu nome");
            String nomeCliente = scanner.next();

            
            System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ",  conta " + numeroConta + " e seu saldo " + saldo + "já está disponivel para saque" );



    }

}