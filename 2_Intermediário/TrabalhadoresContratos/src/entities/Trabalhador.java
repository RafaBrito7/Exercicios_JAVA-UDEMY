package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities_enum.NivelTrabalhador;

public class Trabalhador {
	private String nome;
	private NivelTrabalhador nivel;
	private Double salarioBase;
	
	private Departamento departamento;
	private List<HoraContrato> contrato = new ArrayList<>();
	
	public Trabalhador() {
		
	}

	public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HoraContrato> getContrato() {
		return contrato;
	}

	// Ninguém pode trocar a lista de contrato por outra qualquer.
	/*public void setContrato(List<HoraContrato> contrato) {
		this.contrato = contrato;
	}*/
	
	public void addContrato(HoraContrato contrato) {
		this.contrato.add(contrato);
	}
	
	public void removerContrato(HoraContrato contrato) {
		this.contrato.remove(contrato);
	}
	
	public double ganhos (int ano, int mes) { 
		Calendar calendar = Calendar.getInstance(); // chamando um novo Calendario de datas
		double soma = salarioBase; 
		
		for (HoraContrato c : contrato) {
			calendar.setTime(c.getDate()); // resgatando a data 
			int c_ano = calendar.get(Calendar.YEAR); // implementando na variavel o ano em questão
			int c_mes = 1 + calendar.get(Calendar.MONTH); // implementando na variavel o mês em questão
			if (ano == c_ano && mes == c_mes) { // Comparando se a data incluida no método é igual a data capturada 
				soma += c.valorTotal();
			}
		}
		return soma;
	}
	
	
	
	
	

}
