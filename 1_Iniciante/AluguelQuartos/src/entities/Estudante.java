package entities;

public class Estudante {
	
	private String nome;
	private String email;
	private int numeroQuarto;
	
	public Estudante(String nome, String email, int numeroQuarto) {
		this.email = email;
		this.nome = nome;
		this.numeroQuarto = numeroQuarto;
	}
	
	public Estudante() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public String toString() {
		return "Quartos Alugados: \n" + this.numeroQuarto + ": " + this.nome
				+ " , " + this.email;
	}

}
