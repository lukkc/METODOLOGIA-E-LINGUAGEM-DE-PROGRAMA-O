package br.unipe.java.unidade1;

import java.util.Scanner;

public class Condiçoes {

	private static Scanner scanf;

	public static void main(String[] args) {

		scanf = new Scanner(System.in);

		int z;
		
		System.out.println("informe um numero inteiro");
		z = scanf.nextInt();

		if (z == 10) {
			
			System.out.println("x é igual a 10 :)");
			
		} else {
			
			System.out.println("z não é igual a 10 :(");
			
		}

		System.out.println("e isso é enrolação");

	}
}
