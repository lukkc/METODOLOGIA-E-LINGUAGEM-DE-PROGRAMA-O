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
	
	Scanner scan = new Scanner(System.in);
	Venda venda = new Venda();
	
	
	
	public Venda getVenda() {
		return venda;
	}

	public Venda criarVenda(){
		

		Vendedor vendedor = null;
		Produto	produto = null;
		AcoesVendedor acoesVendedor = new AcoesVendedor();
		AcoesProduto acoesProduto = new AcoesProduto();
		
		String	porcentagemDesconto,
				quantidadeItens;
		
		float	desconto,
				valor,
				comissao;
		
		
		
		vendedor =  acoesVendedor.criarVendedor();
		venda.setVendedor(vendedor);
		
		produto = acoesProduto.CriarProduto();
		venda.setProduto(produto);
		
		System.out.println("Informe a porcentagem de desconto [ Digite só o número ]");
		porcentagemDesconto = scan.nextLine();
		desconto = venda.calcularDesconto(porcentagemDesconto);
		venda.setDesconto(desconto);
		
		System.out.println("Informe a quantidade de itens");
		quantidadeItens = scan.nextLine();
		venda.setQuantidadeItens(quantidadeItens);
		
		valor = venda.calcularValor();
		venda.setValor(valor);
		
		comissao = venda.calcularComissao();
		venda.setVendedorComissao(comissao);
		
		this.salvarVenda(venda);
		
		return venda;
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
			e.printStackTrace();
			System.out.println("Não foi possivel salvar a venda");
		}
	}
	
	
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
			e.printStackTrace();
			System.out.println("Venda não encontrado");
		}
		
		
		return vendas;
	}
	
	public void imprimirVendas(){
		
		List<Venda> vendas = null;
		int i = 0;
		
		vendas = this.lerVenda();
		
		for (i = 0; i < vendas.size(); i++) {
			
			vendas.get(i).Imprimir();
			
		}
		
	}
}
