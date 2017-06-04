package Vendas;

import java.io.Serializable;

public class Vendedor implements Serializable{


	private static final long serialVersionUID = 1L;
	private String nome;
	private String codigo;
	private String endereco;
	private String comissao = "0";
	
	

	
	public Vendedor(String nome, String codigo, String endereco, String comissao) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.endereco = endereco;
		this.comissao = comissao;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getComissao() {
		return comissao;
	}
	
	public void setComissao(String comissao) {
		this.comissao = comissao;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
}
