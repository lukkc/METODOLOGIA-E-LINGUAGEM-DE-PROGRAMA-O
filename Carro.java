package br.unipe.java.unidade1;

public class Carro {

	private String motor;
	private String cor;
	private float potencia;
	private int rodas;
	private int velocidade;
	
	
	public void avancar(){
	
		System.out.println("Avançando...");
		
	}
	
	public void retroceder(){
		
		System.out.println("Retrocedendo...");
		
	}
	
	public void parar(){
		
		System.out.println("Parando...");
		
	}
	
	public void abastecer(){
		
		System.out.println("Abastecendo...");
		
	}
	
		
	
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public float getPotencia() {
		return potencia;
	}
	public void setPotencia(float potencia) {
		this.potencia = potencia;
	}
	public int getRodas() {
		return rodas;
	}
	public void setRodas(int rodas) {
		this.rodas = rodas;
	}
	public int getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	
	
}
