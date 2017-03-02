
public class Emprestimo {
	
	public String nomeUsuario;
	public int idade;
	public float valorEmprestimo;
	public int percentualJurosMes;
	public int mesesParaPagar;
	
	public void Imprimir(){
		System.out.println("\n\n\n------------------Dados do Empréstimo------------------");
		System.out.println("\nNome: "+nomeUsuario);
		System.out.println("\nIdade: "+idade);
		System.out.println("\nValor do Empréstimo: "+valorEmprestimo);
		System.out.println("\nJuros: "+percentualJurosMes);
		System.out.println("\nMeses para pagamento:  "+mesesParaPagar);
		System.out.println("\n-------------------------------------------------------");
		
	}
	
	public void calcularEmprestimo(float valorEmprestimo, int idade, int mesesParaPagar, int percentualJurosMes){
		
		if(idade >= 18 && idade < 23){
			valorEmprestimo += (valorEmprestimo / mesesParaPagar) * (percentualJurosMes / 100);
			
			
		}
		if(idade > 23 && idade <= 33){
			valorEmprestimo += (valorEmprestimo * 10) / 100;
		}
		
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public float getValorEmprestimo() {
		return valorEmprestimo;
	}

	public void setValorEmprestimo(float valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}

	public int getPercentualJurosMes() {
		return percentualJurosMes;
	}

	public void setPercentualJurosMes(int percentualJurosMes) {
		this.percentualJurosMes = percentualJurosMes;
	}

	public int getMesesParaPagar() {
		return mesesParaPagar;
	}

	public void setMesesParaPagar(int mesesParaPagar) {
		this.mesesParaPagar = mesesParaPagar;
	}
	
	
}
