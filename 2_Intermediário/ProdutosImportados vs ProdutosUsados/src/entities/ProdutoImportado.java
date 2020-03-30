package entities;

public class ProdutoImportado extends Produto {

	private Double taxaAlfandega;

	public ProdutoImportado(String nome, Double preco, Double taxaAlfandega) {
		super(nome, preco);
		this.taxaAlfandega = taxaAlfandega;
	}

	public Double getTaxaAlfandega() {
		return taxaAlfandega;
	}

	public void setTaxaAlfandega(Double taxaAlfandega) {
		this.taxaAlfandega = taxaAlfandega;
	}

	public double subTotal() {
		return super.getPreco() + taxaAlfandega;
	}

	public String tagPreco() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getNome() + " - R$" + String.format("%.2f", subTotal()) + 
				" (Taxa Alfandegaria: R$" + String.format("%.2f", getTaxaAlfandega()) + ")");
		return sb.toString();
	}

	public String toString() {
		return tagPreco();
	}
}
