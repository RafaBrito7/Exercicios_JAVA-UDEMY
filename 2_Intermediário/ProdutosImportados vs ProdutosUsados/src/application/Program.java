package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		List<Produto> listaProdutos = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Digite o numero de Produtos: ");
		int num = sc.nextInt();
		
		for (int i = 1; i <= num; i++) {
			System.out.println("Produto #" + i + " dados:");
			System.out.print("Comum, usado ou importado?(c/u/i)");
			char ch = sc.next().charAt(0);
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			double preco = sc.nextDouble();
			
			if (ch == 'c') {
				listaProdutos.add(new Produto(nome, preco));
				
			} else if(ch == 'u') {
				System.out.print("Data de Fabricação(dd/mm/yyyy): ");
				Date dataFabricacao = sdf.parse(sc.next()); 
				listaProdutos.add(new ProdutoUsado(nome, preco, dataFabricacao));
				
			} else if (ch == 'i') {
				System.out.print("Taxa Alfandegária: ");
				double taxaAlfandega = sc.nextDouble();
				ProdutoImportado pi = new ProdutoImportado(nome, preco, taxaAlfandega);
				listaProdutos.add(pi);
				pi.subTotal();
				
			}else {
				System.out.println("Caracter Inválido!");
			}
		}
		
		for (Produto produto : listaProdutos) {
			System.out.println(produto);
		}
		
		System.out.println();
		
		sc.close();
	}

}
