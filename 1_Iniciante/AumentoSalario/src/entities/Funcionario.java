package entities;

public class Funcionario {
	
	private Integer id;
	private String nome;
	private Double salario;
	
	public Funcionario(int id,String nome, double salario) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public double aumentarSalario(double x) {
		return this.salario += this.salario * (x /100);
	}
	
	public String toString() {
		return "ID: " + this.id + "\n" +
				"Name: " + this.nome + "\n" +
				"Salary: " + this.salario;
	}

}
