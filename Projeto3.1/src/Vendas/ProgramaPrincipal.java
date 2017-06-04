package Vendas;

public class ProgramaPrincipal {
	public static void main(String[] args) {
		
		AcoesProduto produto = new AcoesProduto();
		AcoesVendedor vendedor = new AcoesVendedor();
		AcoesVenda venda = new AcoesVenda();
		InterfaceMenu menu = new InterfaceMenu();
		TratamentoInputs  tratamentoErro= new TratamentoInputs();
		String opcao = null;
		boolean loop = true;
		
		
		
		do{
			/*INTERFACE DO MENU*/
			menu.visual();
			
			/*INPUT DO MENU, RETURN UMA OPCAO */
			opcao = menu.input();
			
			switch (opcao) {
			
			/*CRIAR PRODUTO*/
			case "1":
				
				produto.criarProduto(null);
				break;
			
			/*CRIAR VENDEDOR*/
			case "2":
				
				vendedor.criarVendedor(null);
				break;
			
			/*CRIAR VENDA*/
			case "3":
				
				venda.criarVenda();
				break;
			
			/*PROCURAR POR PRODUTO*/
			case "4":
				
				produto.imprimirProduto();
				break;
				
			/*PROCURAR POR VENDEDOR*/
			case "5":
				
				vendedor.imprimirVendedor();
				break;
				
			/*MOSTRAR TODAS AS VENDAS REALIZADAS*/
			case "6":
				
				venda.imprimirVendas();
				break;
				
			case "7":
				
				loop = false;
				break;
				
			default:
				
				tratamentoErro.opcaoInvalida();
				break;
			}
			
		}while(loop);
		
	}
}
