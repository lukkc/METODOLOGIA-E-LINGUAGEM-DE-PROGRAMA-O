package br.unipe.java.unidade1;

import java.util.Scanner;

public class Cerveja {

	public static void main(String[] args) {
		

		Scanner scanf = new Scanner(System.in);
		
		System.out.println( "informe a quantidade de cervejas" );
		int x = scanf.nextInt();
		
		while (x >= 0) {
			System.out.println( "pego uma cerveja, passo pra frente" );
			System.out.println( "agora são " + x + " cervejas na freezer." );
			x--;
		}
		
		scanf.close();
	}

}
