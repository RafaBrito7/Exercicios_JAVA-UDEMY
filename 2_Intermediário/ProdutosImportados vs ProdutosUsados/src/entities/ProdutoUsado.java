package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto {

	private Date dataFabricacao;

	public ProdutoUsado(String nome, Double preco, Date dataFabricacao) {
		super(nome, preco);
		this.dataFabricacao = dataFabricacao;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public String tagPreco() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		sb.append(super.getNome() + " (Usado) - R$" + String.format("%.2f", super.getPreco()) + " - (Data de Fabricação: "
				+ sdf.format(dataFabricacao) + ")");
		return sb.toString();
	}

	public String toString() {
		return tagPreco();
	}

}
