import java.util.Scanner;

public class SalarioPrincipal {

	public static void main(String[] args) {
		
		Salario salario = new Salario();
		
		Scanner leitor1 = new Scanner(System.in);
		
		System.out.println("Insira o salario: ");
		salario.salario = leitor1.nextFloat();
		
		
		System.out.println("\nInsira o percentual de aumento: ");
		salario.percentualAumento = leitor1.nextFloat();
		
		leitor1.close();
		
		salario.exibe_aumento(salario.salario, salario.percentualAumento);
		System.out.println("O valor do aumento é de "+salario.aumento);
		
		salario.calcula_salario();
		System.out.println("O valor do seu salário, com o aumento, é: "+salario.salario);
		
	}

}
