package entities;

public class EmpregadoTercerizado extends Empregado {

	private Double porcentagemAdicional;
	
	public EmpregadoTercerizado() {
	}

	public EmpregadoTercerizado(String nome, Integer hora, Double valorHora, Double porcentagemAdicional) {
		super(nome, hora, valorHora);
		this.porcentagemAdicional = porcentagemAdicional;
	}

	public Double getPorcentagemAdicional() {
		return porcentagemAdicional;
	}

	public void setPorcentagemAdicional(Double porcentagemAdicional) {
		this.porcentagemAdicional = porcentagemAdicional;
	}
	
	@Override
	public double Pagamento() {
		return super.Pagamento() + porcentagemAdicional * 1.1;
	}
	
}
