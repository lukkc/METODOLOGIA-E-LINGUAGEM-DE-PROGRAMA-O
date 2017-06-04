package Vendas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AcoesVenda {
	
	private Scanner scan = new Scanner(System.in);
	private Venda venda = new Venda(); 
	
	
	
	public Venda getVenda() {
		return venda;
	}

	public Venda criarVenda(){
		

		Vendedor vendedor = null;
		Produto	produto = null;
		TratamentoInputs tratamentoErro = new TratamentoInputs();
		
		String	nomeVendedor,
				nomeProduto,
				porcentagemDesconto,
				quantidadeItens;
		
		float	desconto,
				valor,
				comissao;
		
		
		System.out.println("Informe o nome do vendedor.");
		nomeVendedor = scan.nextLine();
		vendedor = tratamentoErro.nomeVendedorVenda(nomeVendedor);
		this.venda.setVendedor(vendedor);
		
		
		System.out.println("Informe o nome do Produto.");
		nomeProduto = scan.nextLine();
		produto = tratamentoErro.nomeProdutoVenda(nomeProduto);
		System.out.println(produto);
		this.venda.setProduto(produto);
		
		
		while(true){
			System.out.println("Informe a porcentagem de desconto [ Digite só o número ].");
			porcentagemDesconto = scan.nextLine();
			
			if(tratamentoErro.porcentagemDesconto(porcentagemDesconto)){
				desconto = this.calcularDesconto(porcentagemDesconto);
				venda.setDesconto(desconto);
				break;
			}
		}
		
		
		while(true){
			System.out.println("Informe a quantidade de itens.");
			quantidadeItens = scan.nextLine();
			
			if(tratamentoErro.quantidadeItens(quantidadeItens)){
				venda.setQuantidadeItens(quantidadeItens);
				break;
			}
		}
		
		
		valor = this.calcularValor();
		venda.setValor(valor);
		
		
		comissao = this.calcularComissao();
		venda.setVendedorComissao(comissao);
		
		this.salvarVenda(venda);
		
		return venda;
	}
	
	public float calcularDesconto(String porcentagemDesconto){
		
		Produto produto = this.venda.getProduto(); 
		float valorVenda = Float.parseFloat(produto.getValorVenda());
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
	
		Produto produto = this.venda.getProduto();
		float valorCusto = Float.parseFloat(produto.getValorCusto());
		float valorVenda = Float.parseFloat(produto.getValorVenda());
		float valorFinal;
	 
		valorFinal = (valorVenda - desconto);
	 
		if(valorFinal < valorCusto){
		 
			System.out.println("ESSE DESCONTO ESTÁ ABAIXO DO ESTIMADO PARA ESTE PRODUTO.");
			return false;
		}
	 
		return true;
	}
	
	public float calcularValor(){
		 
		Produto produto = this.venda.getProduto();
		float valorVenda = Float.parseFloat(produto.getValorVenda());
		float quantidadeProduto = Float.parseFloat(this.venda.getQuantidadeItens());
		float desconto = Float.parseFloat(this.venda.getDesconto());
		float valorFinal;
	
		valorFinal = ((valorVenda - desconto) * quantidadeProduto);
	
		return valorFinal; 
	}
	
	public float calcularComissao(){
		
		Produto produto = this.venda.getProduto();
		Vendedor vendedor = this.venda.getVendedor();
		float comissao = Float.parseFloat(vendedor.getComissao());
		float valorFinal = Float.parseFloat(this.venda.getValor());
		String promocao = produto.getPromocao();
	 
		comissao = ((comissao / 100) * valorFinal); 
	 
		if(promocao.equalsIgnoreCase("sim")){
		 
			return (comissao / 2);
		}
	 
		return comissao;
	}
	
	private void salvarVenda(Venda venda){
		
		List<Venda> vendas = this.lerVenda();
		
		if(vendas == null){
			vendas = new ArrayList<Venda>();
		}
		
		vendas.add(venda);
		
		try {
			FileOutputStream arqVenda = new FileOutputStream("Vendas/vendas.ser");
			ObjectOutputStream objVenda = new ObjectOutputStream(arqVenda);
			
			objVenda.writeObject(vendas);
			objVenda.close();
			arqVenda.close();
			
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("NÃO FOI POSSIVEL SALVAR A VENDA.\n\n");
		}
	}
	
	@SuppressWarnings("unchecked")
	private List<Venda> lerVenda(){
		
		List<Venda> vendas = null;
		
		try {
			FileInputStream arqVenda = new FileInputStream("Vendas/vendas.ser");
			ObjectInputStream objVenda = new ObjectInputStream(arqVenda);
			
			vendas = (List<Venda>) objVenda.readObject();
			objVenda.close();
			arqVenda.close();
			
			return vendas;
			
		} catch (IOException | ClassNotFoundException e) {
//			e.printStackTrace();
			System.out.println("O ARQUIVO DE VENDAS NÃO FOI ENCONTRADA.\n\n");
		}
		
		
		return vendas;
	}
	
	public void Imprimir(Venda venda){
		 
		Vendedor vendedor = venda.getVendedor();
	 		String codigoVendedor = vendedor.getCodigo();
	 		String nomeVendedor = vendedor.getNome();
	 		String comissaoVendedor = vendedor.getComissao();
	 
	 	Produto produto = venda.getProduto();
	 		String codigoProduto = produto.getCodigo();
	 		String nomeProduto = produto.getNome();
	 		String descricaoProduto = produto.getDescricao();
	 		String valorVendaProduto = produto.getValorVenda();
	 		String promocaoProduto = produto.getPromocao();
	 	
	 	String quantidadeItens = venda.getQuantidadeItens();
	 	String desconto = venda.getDesconto();
	 	String valorFinal = venda.getValor();
	 

	 	System.out.println("------- INFORMAÇÕES SOBRE A VENDA ------\n\n");
	 	System.out.println("VENDEDOR");
	 	System.out.println("Código do vendedor: " + codigoVendedor);
	 	System.out.println("Nome do vendedor: " + nomeVendedor);
	 	System.out.println("Comissão do vendedor sobre a venda: R$ " + comissaoVendedor + " reais");
	 	System.out.println("\n");
	 
	 	System.out.println("PRODUTO");
	 	System.out.println("Código do produto: " + codigoProduto);
	 	System.out.println("Nome do produto: " + nomeProduto);
	 	System.out.println("Descrição do produto: " + descricaoProduto);
	 	System.out.println("Valor de venda do produto: R$ " + valorVendaProduto + " reais");
	 	System.out.println("Promoção: " + promocaoProduto);
	 	System.out.println("\n");
	 
	 	System.out.println("Quantidade de itens: " + quantidadeItens);
	 	System.out.println("Desconto na unidade: " + desconto + "%");
	 	System.out.println("Valor Total: R$ " + valorFinal + " reais");
	 	System.out.println("\n----------------------------------------\n\n");
	 	
	}
	
	public void imprimirVendas(){
		
		List<Venda> vendas = null;
		int i = 0;
		
		vendas = this.lerVenda();
		
		if(vendas == null){
			vendas = new ArrayList<Venda>();
		}
		
		
		for (i = 0; i < vendas.size(); i++) {
			
			this.Imprimir(vendas.get(i));
		}
		
	}
}
