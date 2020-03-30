package entities;

public class OrdemProduto {

	private Integer quantidade;
	private Double preco;
	private Product produto;

	public OrdemProduto() {
	}

	public OrdemProduto(Integer quantidade, Double preco, Product produto) {
		this.quantidade = quantidade;
		this.preco = produto.getPrecoP();
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Product getProduto() {
		return produto;
	}

	public void setProduto(Product produto) {
		this.produto = produto;
	}

	public Double subTotal() {
		return quantidade * produto.getPrecoP();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getProduto().getNomeP() + ", R$" + getProduto().getPrecoP() + ", " + "Quantidade: " + getQuantidade()
				+ ", " + "SubTotal: R$" + String.format("%.2f", subTotal()));

		return sb.toString();
	}

}
