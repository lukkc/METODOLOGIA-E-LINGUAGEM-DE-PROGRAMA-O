package Vendas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class AcoesVendedor {
	
	private Scanner scan = new Scanner(System.in);
	private TratamentoInputs tratamentoErro = new TratamentoInputs();
	private Configuracao controleCodigoVendedor = new Configuracao();
	
	
	public Vendedor criarVendedor(String nome){
		
		String	codigo,
				endereco,
				comissao; 
		
			
		if(nome == null){
			while(true){
				System.out.println("Infome o nome do vendedor.");
				nome = scan.nextLine();
				
				if(tratamentoErro.nomeVendedor(nome)){
					break;
				}
			}
		}
		
		
		while(true){
			System.out.println("Informe o código do vendedor.");
			codigo = scan.nextLine();
			
			if(tratamentoErro.codigoVendedor(codigo)){
				break;
			}
		}	
		
		
		System.out.println("Informe o endereço");
		endereco = scan.nextLine();
		
		
		while(true){
			System.out.println("Informe a comissao [ Digite só o número ].");
			comissao = scan.nextLine();
			
			if(tratamentoErro.comissaoVendedor(comissao)){
				break;
			}
		}
		
		
		Vendedor vendedor = new Vendedor(nome, codigo, endereco, comissao);
		
		if(this.salvarVendedor(vendedor)){
			controleCodigoVendedor.addCodigoVendedor(codigo);
		};
		
		
		return vendedor;
		
	}
	
	private boolean salvarVendedor(Vendedor vendedor){
		
		try {
			FileOutputStream arqVendedor = new FileOutputStream("Vendedores/" + vendedor.getNome() + ".ser");
			ObjectOutputStream objVendedor = new ObjectOutputStream(arqVendedor);
			
			objVendedor.writeObject(vendedor);
			objVendedor.close();
			arqVendedor.close();
			return true;
			
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("NÃO FOI POSSIVEL SALVAR O VENDEDOR.\n\n");
			return false;
		}
	}
	
	public Vendedor lerVendedor(String nome, boolean alert){
		
		Vendedor vendedor = null;
		
		
		try {
			FileInputStream arqVendedor = new FileInputStream("Vendedores/" + nome + ".ser");
			ObjectInputStream objVendedor = new ObjectInputStream(arqVendedor);
			
			vendedor = (Vendedor) objVendedor.readObject();
			objVendedor.close();
			arqVendedor.close();
			
			return vendedor;
			
		} catch (IOException | ClassNotFoundException e) {
			if(alert){
//				e.printStackTrace();
				System.out.println("VENDEDOR NÃO ENCONTRADO.\n\n");
			}
		}
		
		
		return vendedor;
	}
	
	public void imprimirVendedor(){
		
		Vendedor vendedor = null;
		String nome =  null;
		
		System.out.println("Informe o nome do vendedor.");
		nome = scan.nextLine();
		
		vendedor = this.lerVendedor(nome, true);
		
		if(vendedor != null){
			System.out.println("-------------- INFORMAÇÕES SOBRE O VENDEDOR --------------\n");
			System.out.println("Código: " + vendedor.getCodigo());
			System.out.println("Nome: " + vendedor.getNome());
			System.out.println("Endereço: " + vendedor.getEndereco());
			System.out.println("Comissão: R$ " + vendedor.getComissao() + " reais");
		}
		
	}
	
	

}
