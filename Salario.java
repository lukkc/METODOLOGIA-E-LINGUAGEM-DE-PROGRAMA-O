
public class Salario {
	
	float salario, percentualAumento, aumento;
	
	public void exibe_aumento(float salario, float percentualAumento){
		
		aumento = salario * (percentualAumento / 100);
		
	}
	
	public void calcula_salario(){
		
		salario = aumento + salario;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public float getPercentualAumento() {
		return percentualAumento;
	}

	public void setPercentualAumento(float percentualAumento) {
		this.percentualAumento = percentualAumento;
	}

	public float getAumento() {
		return aumento;
	}

	public void setAumento(float aumento) {
		this.aumento = aumento;
	}
	
	

}
