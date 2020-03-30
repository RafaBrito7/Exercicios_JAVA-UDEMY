package entities;

public class Product {
	
	private String nomeP;
	private Double precoP;
	
	public Product() {
	}
	public Product(String nomeP, Double precoP) {
		this.nomeP = nomeP;
		this.precoP = precoP;
	}
	public String getNomeP() {
		return nomeP;
	}
	public void setNomeP(String nomeP) {
		this.nomeP = nomeP;
	}
	public Double getPrecoP() {
		return precoP;
	}
	public void setPrecoP(Double precoP) {
		this.precoP = precoP;
	}
	
	
	

}
