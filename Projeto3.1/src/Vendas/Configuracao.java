package Vendas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Configuracao {
	
	
	public List<String> getControleCodigoVendedor() {
		return this.lerConfiguracao("controleCodigoVendedor", false);
	}
	
	public List<String> getControleCodigoProdutos() {
		return this.lerConfiguracao("controleCodigoProduto", false);
	}
	
	public void addCodigoVendedor(String codigo){
		
		this.salvarConfiguracao("controleCodigoVendedor", codigo);
	}
	
	public void addCodigoProdutos(String codigo){
		
		this.salvarConfiguracao("controleCodigoProduto", codigo);
		
	}
	
	private void salvarConfiguracao(String nomeArquivo, String codigo){
		
			
		List<String> configuracao = this.lerConfiguracao(nomeArquivo, false);
			
		if(configuracao == null){
			configuracao = new ArrayList<String>();
		}
			
		configuracao.add(codigo);
			
		try {
			FileOutputStream arqConfiguracao = new FileOutputStream("Configuração/" + nomeArquivo + ".ser");
			ObjectOutputStream objConfiguracao = new ObjectOutputStream(arqConfiguracao);
				
			objConfiguracao.writeObject(configuracao);
			objConfiguracao.close();
			arqConfiguracao.close();
				
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("NÃO FOI POSSIVEL SALVAR O ARQUIVO DE CONFIGURAÇÃO.");
		}
	}
		
	@SuppressWarnings("unchecked")
	private List<String> lerConfiguracao(String nomeArquivo, boolean alert){
		
		List<String> configuracao = null;
		
		try {
			FileInputStream arqConfiguracao = new FileInputStream("Configuração/" + nomeArquivo + ".ser");
			ObjectInputStream objConfiguracao = new ObjectInputStream(arqConfiguracao);
			
			configuracao = (List<String>) objConfiguracao.readObject();
			objConfiguracao.close();
			arqConfiguracao.close();
			
			return configuracao;
			
		} catch (IOException | ClassNotFoundException e) {
			if(alert){
//				e.printStackTrace();
				System.out.println("ARQUIVO DE CONFIGURAÇÃO NÃO ENCONTRADO.");
			}
		}

		
		return configuracao;
		
	}

	
}
