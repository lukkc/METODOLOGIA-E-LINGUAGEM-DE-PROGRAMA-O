package Vendas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class AcoesVendedor {
	
	Scanner scan = new Scanner(System.in);
	
	
	public Vendedor criarVendedor(){
		
		String	nome,
				codigo,
				endereco,
				comissao; 
		
		
		System.out.println("Informe o nome do vendedor");
		nome = scan.nextLine();
		
		System.out.println("Informe o código do vendedor");
		codigo = scan.nextLine();
		
		System.out.println("Informe o endereço");
		endereco = scan.nextLine();
		
		System.out.println("Informe a comissao [ Digite só o número ]");
		comissao = scan.nextLine();
		
		Vendedor vendedor = new Vendedor(nome, codigo, endereco, comissao);
		
		this.salvarVendedor(vendedor);
		
		return vendedor;
		
	}
	
	private void salvarVendedor(Vendedor vendedor){
		
		try {
			FileOutputStream arqVendedor = new FileOutputStream("Vendedores/" + vendedor.getNome() + ".ser");
			ObjectOutputStream objVendedor = new ObjectOutputStream(arqVendedor);
			
			objVendedor.writeObject(vendedor);
			objVendedor.close();
			arqVendedor.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Não foi possivel salvar o vendedor");
		}
	}
	
	public Vendedor lerVendedor(String nome){
		
		Vendedor vendedor = null;
		
		
		try {
			FileInputStream arqVendedor = new FileInputStream("Vendedores/" + nome + ".ser");
			ObjectInputStream objVendedor = new ObjectInputStream(arqVendedor);
			
			vendedor = (Vendedor) objVendedor.readObject();
			objVendedor.close();
			arqVendedor.close();
			
			return vendedor;
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Vendedor não encontrado");
		}
		
		
		return vendedor;
	}
	
	

}
