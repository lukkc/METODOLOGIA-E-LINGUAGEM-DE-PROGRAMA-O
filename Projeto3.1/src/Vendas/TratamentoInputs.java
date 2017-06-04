package Vendas;

import java.util.List;

public class TratamentoInputs {
	
	
	
 /* TRATAMENTO DE ERRO DOS INPUTS DE PRODUTO */
	
	public boolean nomeProduto(String nome){
		
		AcoesProduto produto = new AcoesProduto();
		Produto pesquisa = null;
		
		pesquisa = produto.lerProduto(nome, false);
		
		if(pesquisa == null){
			return true;
		}
		
		System.out.println("ESSE PRODUTO JÁ EXISTE, TENTE OUTRO.\n");
		return false;
	}
	
	public boolean codigoProduto(String codigo){
		
		if(this.stringIsDigit(codigo)){
		
			Configuracao controle = new Configuracao();
			List<String> listaCodigos = controle.getControleCodigoProdutos();
			
			if(listaCodigos == null){
				return true;
			}
			
			for (int i = 0; i < listaCodigos.size(); i++) {
				
				if(codigo.equals(listaCodigos.get(i))){
					
					System.out.println("ESSE CÓDIGO JÁ EXISTE, TENTE ALGUM ACIMA DE " + listaCodigos.size() + ".\n");
					return false;
				}
			}
			return true;
		}
		return false;		
	}

	public boolean valorVendaProduto(String valor){
		
		return this.stringIsDigit(valor);
	}

	public boolean valorCustoProduto(String valor){
		
		return this.stringIsDigit(valor);
	}

	public boolean promocaoProduto(String promocao){
		
		if(promocao.equalsIgnoreCase("sim") || promocao.equalsIgnoreCase("não")){
			return true;
		}
			
			System.out.println("VOCÊ DIGITOU UMA OPÇÃO INVALIDA, LEIA COM ATENÇÃO!.\n");
			return false;
	}
	
	
	
	
	
	
	
 /* TRATAMENTO DE ERRO DOS INPUTS DE VENDEDOR */
	
	public boolean nomeVendedor(String nome){
		
		AcoesVendedor vendedor = new AcoesVendedor();
		Vendedor pesquisa = null;
		
		pesquisa = vendedor.lerVendedor(nome, false);
		
		if(pesquisa == null){
			return true;
		}
		
		System.out.println("ESSE VENDEDOR JÁ EXISTE, TENTE OUTRO NOME.\n");
		return false;
	}
	
	public boolean codigoVendedor(String codigo){
		
		if(this.stringIsDigit(codigo)){
			Configuracao controle = new Configuracao();
			List<String> listaCodigos = controle.getControleCodigoVendedor();
			
			if(listaCodigos == null){
				return true;
			}
			
			for (int i = 0; i < listaCodigos.size(); i++) {
				
				if(codigo.equals(listaCodigos.get(i))){
					
					System.out.println("ESSE CÓDIGO JÁ EXISTE, TENTE ALGUM ACIMA DE " + listaCodigos.size() + ".\n");
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public boolean comissaoVendedor(String comissao){
			
		return this.stringIsDigit(comissao);
	}

	
	
	
	
	

	
/* TRATAMENTO DE ERRO DOS INPUTS DE VENDA */
	
	public Vendedor nomeVendedorVenda(String nome){
		
		AcoesVendedor vendedor = new AcoesVendedor();
		Vendedor pesquisa = null;
		
		pesquisa = vendedor.lerVendedor(nome, false);
		
		if(pesquisa == null){
			return vendedor.criarVendedor(nome);
		}
		
		return pesquisa;
	}
	
	public Produto nomeProdutoVenda(String nome){
		
		AcoesProduto produto = new AcoesProduto();
		Produto pesquisa = null;
		
		pesquisa = produto.lerProduto(nome, false);
		
		if(pesquisa == null){
			return produto.criarProduto(nome);
		}
		
		return pesquisa;
	}
	
	public boolean porcentagemDesconto(String porcentagemDesconto){
		
		return this.stringIsDigit(porcentagemDesconto);
	}
	
	public boolean quantidadeItens(String quantidadeItens){
		
		return this.stringIsDigit(quantidadeItens);
	}

	
	
	
	
	
 /* TRATAMENTO DE ERRO COMUM */
	
	public boolean stringIsDigit(String string){
		
		int i = 0;
		
		for(i = 0; i < string.length(); i++){
			
			if(!Character.isDigit(string.charAt(i))){
				
				System.out.println("POR FAVOR, DIGITE APENAS NUMEROS.\n");
				return false;
			}
		}
		
		
		return true;
	}
	
	public void opcaoInvalida(){
		
		System.out.println("POR FAVOR, ESCOLHA ALGUMA OPÇÃO VALIDA NO MENU.\n\n");
	}
	
	
}
