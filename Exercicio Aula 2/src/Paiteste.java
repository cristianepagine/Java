import java.lang.reflect.Field;
	import java.lang.reflect.Method;
	import java.lang.reflect.Modifier;

	

	public class Paiteste {
	    public static void main(String arg[]) {
	        // Código anterior para verificar os modificadores de acesso dos atributos

	        Class<Pai> classe = Pai.class;
	        Method[] metodos = classe.getDeclaredMethods();

	        for (Method metodo : metodos) {
	            System.out.println("Nome do método: " + metodo.getName());
	            int modifiers = metodo.getModifiers();
	            String modifiersStr = Modifier.toString(modifiers);
	            System.out.println("Modificadores de acesso: " + modifiersStr);
	            System.out.println();
	        }
	    }
	}

/**
PUBLIC String nome;
PUBLIC int idade;
PRIVATE double salario;
//MÉTODOS
PUBLIC void cadPai(String nm, int anos, int sal) {
nome = nm;
idade = anos;
salario = sal;
}
 PRIVATE void calcSalario() {
salario = salario * 1.10;
System.out.println("\nSalario......: "+ salario);
}
PUBLIC void impPai() {
System.out.println("\nNome.......: "+ nome);
System.out.println("\nIdade........: "+ idade);
System.out.println("\nSalario......: "+ salario);
}**/
