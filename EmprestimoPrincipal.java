import java.util.Scanner;

public class EmprestimoPrincipal {

	public static void main(String[] args) {
		
		Emprestimo emprestimo = new Emprestimo();
		Scanner leitor2 = new Scanner(System.in);
	
		
		System.out.println("\n-------------Cadastrar novo empréstimo-------------\n");
		System.out.println("\nNome: ");
		emprestimo.nomeUsuario = leitor2.nextLine();
		System.out.println("\nIdade: ");
		emprestimo.idade = leitor2.nextInt();
		System.out.println("\nValor do Empréstimo: ");
		emprestimo.valorEmprestimo = leitor2.nextFloat();
		System.out.println("\nMeses para pagamento:  ");
		emprestimo.mesesParaPagar = leitor2.nextInt();
		System.out.println("\nJuros:  ");
		emprestimo.percentualJurosMes = leitor2.nextInt();
			
		emprestimo.calcularEmprestimo(emprestimo.valorEmprestimo, emprestimo.idade, emprestimo.mesesParaPagar, emprestimo.percentualJurosMes);
		leitor2.close();
		
		emprestimo.Imprimir();
	}

}
