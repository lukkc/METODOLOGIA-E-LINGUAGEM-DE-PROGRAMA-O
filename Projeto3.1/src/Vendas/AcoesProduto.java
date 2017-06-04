package Vendas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;	
import java.util.Scanner;

public class AcoesProduto {
		
		private Scanner scan = new Scanner(System.in);
		private TratamentoInputs tratamentoErro = new TratamentoInputs();
		private Configuracao controleCodigoProduto = new Configuracao();
		
		
		public Produto criarProduto(String nome){
			
			String	codigo,
					descricao,
					valorVenda,
					valorCusto,
					promocao;
			
			
			if(nome == null){
				while(true){
					System.out.println("Infome o nome do produto.");
					nome = scan.nextLine();
					
					if(tratamentoErro.nomeProduto(nome)){
						break;
					}
				}
			}

			
			while(true){
				System.out.println("Infome o código do produto.");
				codigo = scan.nextLine();
				
				if(tratamentoErro.codigoProduto(codigo)){
					break;
				}
			}
			
			
			System.out.println("Informe a descrição do produto.");
			descricao = scan.nextLine();
			
			
			while(true){
				System.out.println("Informe o valor de venda do produto.");
				valorVenda = scan.nextLine();
				
				if(tratamentoErro.valorVendaProduto(valorVenda)){
					break;
				}
			}
			
			
			while(true){
				System.out.println("Informe o valor de custo do produto.");
				valorCusto = scan.nextLine();
				
				if(tratamentoErro.valorVendaProduto(valorCusto)){
					break;
				}
			}
			
			
			while(true){
				System.out.println("Produto em promoção? [obs: digite 'SIM' ou 'NÃO'].");
				promocao = scan.nextLine();
				
				if(tratamentoErro.promocaoProduto(promocao)){
					break;
				}
			}
			
			
			Produto produto = new Produto(codigo, nome,  descricao, valorVenda, valorCusto, promocao);
			
			if(this.salvarProduto(produto)){
				controleCodigoProduto.addCodigoProdutos(codigo);
			};
			
			return produto;
		}
		
		
		private boolean salvarProduto(Produto produto){
			
			
			try {
				FileOutputStream arqProduto = new FileOutputStream("EstoqueProdutos/" + produto.getNome() + ".ser");
				ObjectOutputStream objProduto = new ObjectOutputStream(arqProduto);
				
				objProduto.writeObject(produto);
				objProduto.close();
				arqProduto.close();
				return true;
				
			} catch (IOException e) {
				
//				e.printStackTrace();
				System.out.println("NÃO FOI POSSIVEL SALVAR O PRODUTO.\n\n");
				return false;
			} 
		}
		
		
		public Produto lerProduto(String nome, boolean alert){
			 
			Produto produto = null;
			
			try {
				FileInputStream arqProduto = new FileInputStream("EstoqueProdutos/" + nome + ".ser");
				ObjectInputStream objProduto = new ObjectInputStream(arqProduto);
				
				produto = (Produto) objProduto.readObject();
			
				objProduto.close();
				arqProduto.close();
				return produto;
				
			} catch (IOException | ClassNotFoundException e) {
				if(alert){
//					e.printStackTrace();
					System.out.println("PRODUTO NÃO ENCONTRADO.\n\n");
				}
			}
			
			return produto;
			
		
		}
		
		public void imprimirProduto(){
			
			Produto produto = null;
			String nome =  null;
			
			System.out.println("Informe o nome do produto.");
			nome = scan.nextLine();
			
			produto = this.lerProduto(nome, true);
			
			if(produto != null){
				System.out.println("-------------- INFORMAÇÕES SOBRE O PRODUTO --------------\n");
				System.out.println("Código: " + produto.getCodigo());
				System.out.println("Nome: " + produto.getNome());
				System.out.println("Descrição: " + produto.getDescricao());
				System.out.println("Promoção?: " + produto.getPromocao());
				System.out.println("Valor de custo: R$ " + produto.getValorCusto() + " reais");
				System.out.println("Valor de venda: R$" + produto.getValorVenda() + " reais");
			}
			
		}


}
