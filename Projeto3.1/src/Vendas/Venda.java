package Vendas;

import java.io.Serializable;

public class Venda implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private Produto produto;
	private Vendedor vendedor;
	private String desconto;
	private String quantidadeItens;
	private String valor;
 
 
 


	public Produto getProduto() {
		return this.produto;
	}
 
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
 
	
	public Vendedor getVendedor() {
		return this.vendedor;
	}
 
	
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	
	public String getDesconto() {
		
		return this.desconto;
	}
	
	public String getValor() {
		
		return this.valor;
	}
 
	
	public String getQuantidadeItens() {
		return this.quantidadeItens;
	}
 
	
	public void setQuantidadeItens(String quantidadeItens) {
		this.quantidadeItens = quantidadeItens;
	}
 
	
	public void setDesconto(float desconto){
	 
		this.desconto = Float.toString(desconto);
	}
 
	
	public void setValor(float valor){
	 
		this.valor = Float.toString(valor);
	}

	
	public void setVendedorComissao(float comissao){
	 
		this.vendedor.setComissao(Float.toString(comissao));
	}
 
}
