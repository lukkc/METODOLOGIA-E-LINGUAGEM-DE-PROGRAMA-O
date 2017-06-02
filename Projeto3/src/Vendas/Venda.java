package Vendas;

import java.io.Serializable;

public class Venda implements Serializable{
	

// private static int contador =0;
	private static final long serialVersionUID = 1L;
	private Produto produto;
	private Vendedor vendedor;
	private String desconto;
	private String quantidadeItens;
	private String valor;
 
 
 
 
 
// public Venda() {
//	 if(this.contador==0){
//		 
//	 // Verifica se tem o objeto de configuração e se ele não esta vazio.
//	 
//	 
//		 if(objetoConfiguracao.getContador ==0){
//			 this.contador = 1;
//		 }
//	 }else {
//		 this.contador = objetoConfiguracao.getContador();
//		 this.contador += 1;
//	 }
// }

	public Produto getProduto() {
		return this.produto;
	}
 
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
 
	
	public Vendedor getVendedor() {
		return vendedor;
	}
 
	
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
 
	
	public String getQuantidadeItens() {
		return quantidadeItens;
	}
 
	
	public void setQuantidadeItens(String quantidadeItens) {
		this.quantidadeItens = quantidadeItens;
	}
 
	
	public float calcularDesconto(String porcentagemDesconto){
	 
		float valorVenda = Float.parseFloat(this.produto.getValorVenda());
		float desconto = Float.parseFloat(porcentagemDesconto);
		boolean validarDesconto;
	
		desconto = ( (desconto / 100) * valorVenda);
		
		validarDesconto = this.verificarDesconto(desconto);
	
		if(validarDesconto){
			return desconto;
		}
	
		return 0;
	
	}
 
	
	private boolean verificarDesconto(float desconto){
	
		float valorCusto = Float.parseFloat(this.produto.getValorCusto());
		float valorVenda = Float.parseFloat(this.produto.getValorVenda());
		float valorFinal;
	 
		valorFinal = (valorVenda - desconto);
	 
		if(valorFinal < valorCusto){
		 
			System.out.println("Esse desconto está abaixo do estimado para este produto");
			return false;
		}
	 
		return true;
	}
 
	
	public void setDesconto(float desconto){
	 
		this.desconto = Float.toString(desconto);
	}
 
	
	public float calcularValor(){
	 
		float valorVenda = Float.parseFloat(this.produto.getValorVenda());
		float quantidadeProduto = Float.parseFloat(this.quantidadeItens);
		float desconto = Float.parseFloat(this.desconto);
		float valorFinal;
	
		valorFinal = ((valorVenda - desconto) * quantidadeProduto);
	
		return valorFinal; 
	}
 
	
	public void setValor(float valor){
	 
		this.valor = Float.toString(valor);
	}
 
	
	public float calcularComissao(){
	 
		float comissao = Float.parseFloat(this.vendedor.getComissao());
		float valorFinal = Float.parseFloat(this.valor);
		String promocao = this.produto.getPromocao();
	 
		comissao = ((comissao / 100) * valorFinal); 
	 
		if(promocao.equalsIgnoreCase("sim")){
		 
			return (comissao / 2);
		}
	 
		return comissao;
	}

	
	public void setVendedorComissao(float comissao){
	 
		this.vendedor.setComissao(Float.toString(comissao));
	}
 
	
	public void Imprimir(){
	 
		Vendedor vendedor = this.vendedor;
	 		String codigoVendedor = vendedor.getCodigo();
	 		String nomeVendedor = vendedor.getNome();
	 		String comissaoVendedor = vendedor.getComissao();
	 
	 	Produto produto = this.produto;
	 		String codigoProduto = produto.getCodigo();
	 		String nomeProduto = produto.getNome();
	 		String descricaoProduto = produto.getDescricao();
	 		String valorVendaProduto = produto.getValorVenda();
	 		String promocaoProduto = produto.getPromocao();
	 	
	 	String quantidadeItens = this.quantidadeItens;
	 	String desconto = this.desconto;
	 	String valorFinal = this.valor;
	 
	 
	 
	 	System.out.println("Informações sobre a venda");
	 	System.out.println("\n\n");
	 
	 	System.out.println("VENDEDOR");
	 	System.out.println("Código do vendedor: " + codigoVendedor);
	 	System.out.println("Nome do vendedor: " + nomeVendedor);
	 	System.out.println("Comissão do vendedor sobre a venda: R$ " + comissaoVendedor + "reais");
	 	System.out.println("\n");
	 
	 	System.out.println("PRODUTO");
	 	System.out.println("Código do produto: " + codigoProduto);
	 	System.out.println("Nome do produto: " + nomeProduto);
	 	System.out.println("Descrição do produto: " + descricaoProduto);
	 	System.out.println("Valor de venda do produto: R$ " + valorVendaProduto + "reais");
	 	System.out.println("Promoção: " + promocaoProduto);
	 	System.out.println("\n");
	 
	 	System.out.println("Quantidade de itens: " + quantidadeItens);
	 	System.out.println("Desconto na unidade: " + desconto + "%");
	 	System.out.println("Valor Total: R$ " + valorFinal + "reais");
	}
}
