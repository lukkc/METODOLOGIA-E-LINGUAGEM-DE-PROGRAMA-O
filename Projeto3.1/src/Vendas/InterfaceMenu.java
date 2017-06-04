package Vendas;

import java.util.Scanner;

public class InterfaceMenu {
	
	
	
	public void visual(){
		System.out.println("--------------- MENU PRINCIPAL ---------------\n\n");
		System.out.println("[ 1 ] - CRIAR PRODUTO");
		System.out.println("[ 2 ] - CRIAR VENDEDOR");
		System.out.println("[ 3 ] - CRIAR VENDA");
		System.out.println("[ 4 ] - PROCURAR POR PRODUTO");
		System.out.println("[ 5 ] - PROCURAR POR VENDEDOR");
		System.out.println("[ 6 ] - MOSTRAR TODOS AS VENDAS REALIZADAS");
		System.out.println("[ 7 ] - SAIR");
		System.out.println("\n");
	};
	
	
	
	public String input(){
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.println("==== ESCOLHA UMA DAS OPÇÕES ACIMA ====\n");
		return scan.nextLine();
	}

}
