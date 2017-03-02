package br.unipe.java.unidade1;

import java.util.Scanner;

public class ParImpar {
	public static void main(String[] args) {
		int i, numero;
		Scanner teclado = new Scanner(System.in);
		
		for(i=0;i<=10;i++){
			System.out.println("Digite um numero: ");
			numero = teclado.nextInt();
			if (numero % 2 == 0){
				System.out.println("O numero " + numero + " é par.");
			}else{
				System.out.println("O numero " + numero + " é impar.");
			}
		}
		teclado.close();
	}
}
