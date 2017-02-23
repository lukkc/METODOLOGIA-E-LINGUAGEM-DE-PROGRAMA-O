import java.util.Scanner;

public class ParImparPrincipal {

	public static void main(String[] args) {
		
		ParImpar numero = new ParImpar();
		
		Scanner leitor1 = new Scanner(System.in);
		
		System.out.println("\nDigite o número a ser verificado: ");
		numero.numero1 = leitor1.nextInt();
		numero.checar(numero.numero1);
		numero.numero2 = leitor1.nextInt();
		numero.checar(numero.numero2);
		numero.numero3 = leitor1.nextInt();
		numero.checar(numero.numero3);
		numero.numero4 = leitor1.nextInt();
		numero.checar(numero.numero4);
		numero.numero5 = leitor1.nextInt();
		numero.checar(numero.numero5);
		numero.numero6 = leitor1.nextInt();
		numero.checar(numero.numero6);
		numero.numero7 = leitor1.nextInt();
		numero.checar(numero.numero7);
		numero.numero8 = leitor1.nextInt();
		numero.checar(numero.numero8);
		numero.numero9 = leitor1.nextInt();
		numero.checar(numero.numero9);
		numero.numero10 = leitor1.nextInt();
		numero.checar(numero.numero10);
		
				
		leitor1.close();
	}

}
