package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Departamento;
import entities.HoraContrato;
import entities.Trabalhador;
import entities_enum.NivelTrabalhador;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Entre com o nome do Departamento: ");
		String departamento = sc.nextLine();
		System.out.println("Entre com os dados do Trabalhador: ");
		System.out.print("Nome: ");
		String nomeTrabalhador = sc.nextLine();
		System.out.print("Nivel: ");
		String nivelTrabalhador = sc.next();
		System.out.print("Salário Base: ");
		double salario = sc.nextDouble();
		System.out.println("Quantos contratos tem esse trabalhador?");
		int n = sc.nextInt();
		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador), salario,
				new Departamento(departamento));

		for (int i = 0; i < n; i++) {
			System.out.println("Entre com os dados do contrato #" + (i + 1));
			System.out.print("Data(dd/mm/yyyy):");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorHora = sc.nextDouble();
			System.out.print("Duração(horas): ");
			double duracao = sc.nextDouble();
			HoraContrato contrato = new HoraContrato(dataContrato, valorHora, duracao);
			trabalhador.addContrato(contrato);
		}
		System.out.println();
		System.out.println("Entre com o mês e o ano para calcular o ganho(MM/yyyy):");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));

		System.out.println("Nome:" + trabalhador.getNome());
		System.out.println("Departamento:" + trabalhador.getDepartamento().getName());
		System.out.println("Ganhos entre " + mesAno + ": " + String.format("%.2f", trabalhador.ganhos(ano, mes)));

		sc.close();
	}

}
