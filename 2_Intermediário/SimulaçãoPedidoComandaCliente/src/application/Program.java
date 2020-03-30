package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Cliente;
import entities.OrdemProduto;
import entities.Pedido;
import entities.Product;
import entities_enum.StatusPedido;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Entre com os do Cliente: ");
		System.out.print("Nome: ");
		String nomeCliente = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data de Nascimento(dd/MM/yyyy): ");
		Date dataCliente = sdf.parse(sc.next());
		System.out.println();
		Cliente cl = new Cliente(nomeCliente, email, dataCliente);

		System.out.println("Entre com os Dados do Pedido: ");
		System.out.print("Status: ");
		StatusPedido sp = StatusPedido.valueOf(sc.next());
		System.out.println("Quantos itens haverão nessa comanda?");
		int num = sc.nextInt();
		Pedido p = new Pedido(new Date(), sp);
		
		for (int i = 0; i < num; i++) {
			System.out.println("Entre com os dados do Pedido #" + (i + 1));
			System.out.print("Nome do Produto:");
			sc.nextLine();
			String nomeProduto = sc.nextLine();
			System.out.print("Preço do Produto:");
			double precoProduto = sc.nextDouble();
			System.out.print("Quantidade:");
			int quantidade = sc.nextInt();
			p.addItem(new OrdemProduto(quantidade,precoProduto, new Product(nomeProduto, precoProduto)));
		}
		
		System.out.print(p.toString());
		System.out.print(cl.toString());
		System.out.println("Lista de Itens: ");
		System.out.print(p.toString2());
	
		
		sc.close();
	}

}
