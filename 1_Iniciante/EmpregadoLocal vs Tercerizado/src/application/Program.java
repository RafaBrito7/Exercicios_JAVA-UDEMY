package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Empregado;
import entities.EmpregadoTercerizado;

public class Program {

	public static void main(String[] args) {

		Scanner sc	= new Scanner(System.in);
		
		System.out.print("Entre com o numero de funcionários: ");
		int num = sc.nextInt();
		
		List<Empregado> lista = new ArrayList<>();
		
		for (int i = 1; i <= num; i++) {
			System.out.println("Funcionário #" + i + " dados: ");
			System.out.print("Terceirizado(Y/N)?");
			char ch = sc.next().charAt(0);
			System.out.print("Nome:");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Horas:");
			int hora = sc.nextInt();
			System.out.print("Valor por hora:");
			double valorHora = sc.nextDouble();
			
			if (ch == 'Y') {
				System.out.println("Digite o Pagamento Adicional: ");
				double porcentagemAdicional = sc.nextDouble();
				lista.add(new EmpregadoTercerizado(nome, hora, valorHora, porcentagemAdicional));
				
			} else if (ch == 'N')
				lista.add(new Empregado(nome, hora, valorHora));
			
			else
				System.out.println("VALOR INCORRETO!");
		}
		
		for (Empregado empregado : lista) {
			System.out.println(empregado.toString());
		}
		sc.close();
	}

}
