package Vendas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;	
import java.util.Scanner;

public class AcoesProduto {
		
		Scanner scan = new Scanner(System.in);
		
		
		public Produto CriarProduto(){
			
			String	codigo,
					nome,
					descricao,
					valorVenda,
					valorCusto,
					promocao;
			
			
			System.out.println("Infome o código do produto");
			codigo = scan.nextLine();
			
			System.out.println("Infome o nome do produto");
			nome = scan.nextLine();
			
			System.out.println("Informe a descrição do produto");
			descricao = scan.nextLine();
			
			System.out.println("Informe o valor de venda do produto");
			valorVenda = scan.nextLine();
			
			System.out.println("Informe o valor de custo do produto");
			valorCusto = scan.nextLine();
			
			System.out.println("Produto em promoção? [obs: digite 'sim' ou 'não']");
			promocao = scan.nextLine();
			
			Produto produto = new Produto(codigo, nome,  descricao, valorVenda, valorCusto, promocao);
			
			this.salvarProduto(produto);
			
			return produto;
		}
		
		
		private void salvarProduto(Produto produto){
			
			
			try {
				FileOutputStream arqProduto = new FileOutputStream("EstoqueProdutos/" + produto.getNome() + ".ser");
				ObjectOutputStream objProduto = new ObjectOutputStream(arqProduto);
				
				objProduto.writeObject(produto);
				objProduto.close();
				arqProduto.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
				System.out.println("Não foi possivel salvar o produto");
			} 
		}
		
		
		public Produto lerProduto(String nome){
			 
			Produto produto = null;
			
			try {
				FileInputStream arqProduto = new FileInputStream("EstoqueProdutos/" + nome + ".ser");
				ObjectInputStream objProduto = new ObjectInputStream(arqProduto);
				
				produto = (Produto) objProduto.readObject();
			
				objProduto.close();
				arqProduto.close();
				return produto;
				
			} catch (IOException | ClassNotFoundException e) {

				e.printStackTrace();
				System.out.println("Produto não encontrado");
			}
			
			return produto;
			
		
		}


}
