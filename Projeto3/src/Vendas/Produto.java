package Vendas;

import java.io.Serializable;

public class Produto implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nome;
	private String descricao;
	private String valorVenda;
	private String valorCusto;
	private String promocao;
	
	
 
 
 	public Produto(String codigo, String nome, String descricao, String valorVenda, String valorCusto, String promocao) {
 		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.valorVenda = valorVenda;
		this.valorCusto = valorCusto;
		this.promocao = promocao;
 	}


 	public String getCodigo() {
 		return codigo;
 	}


 	public void setCodigo(String codigo) {
 		this.codigo = codigo;
 	}


 	public String getNome() {
 		return nome;
 	}


 	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
 	}


 	public void setDescricao(String descricao) {
 		this.descricao = descricao;
 	}


 	public String getValorVenda() {
	 return valorVenda;
 	}


 	public void setValorVenda(String valorVenda) {
	 this.valorVenda = valorVenda;
 	}


 	public String getValorCusto() {
	 return valorCusto;
 	}


 	public void setValorCusto(String valorCusto) {
	 this.valorCusto = valorCusto;
 	}


 	public String getPromocao() {
	 return promocao;
 	}


 	public void setPromocao(String promocao) {
 		this.promocao = promocao;
 	}
 
}
