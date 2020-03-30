package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities_enum.StatusPedido;

public class Pedido {
	private Date momento;
	private StatusPedido status;
	private List<OrdemProduto> pedidos = new ArrayList<>();
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public Pedido() {
	}

	public Pedido(Date momento, StatusPedido status) {
		this.momento = momento;
		this.status = status;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public List<OrdemProduto> getPedidos() {
		return pedidos;
	}

	public void addItem(OrdemProduto comanda) {
		pedidos.add(comanda);
	}

	public void removeItem(OrdemProduto comanda) {
		pedidos.remove(comanda);
	}

	public double totalGeral() {
		double soma = 0;
		for (OrdemProduto ordemProduto : pedidos) {
			soma += ordemProduto.subTotal();
		}
		return soma;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Resumo do Pedido:\n");
		sb.append("Data do pedido: " + sdf.format(getMomento()) + "\n");
		sb.append("Status do Pedido: " + getStatus() + "\n");

		return sb.toString();
	}
	
	public String toString2() {
		StringBuilder sb = new StringBuilder();
		for (OrdemProduto lista : pedidos) {
			sb.append(lista + "\n");
		}
		sb.append("Preço Total: R$");
		sb.append(String.format("%.2f", totalGeral()));
		return sb.toString();
	}
}
