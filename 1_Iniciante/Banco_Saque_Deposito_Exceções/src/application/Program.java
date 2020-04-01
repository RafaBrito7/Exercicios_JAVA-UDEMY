package application;

import java.util.Scanner;

import model.entities.Conta;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.println("Entre com os dados da conta: ");
		System.out.print("Número: ");
		int numero = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine();
		String titular = sc.nextLine();
		System.out.print("Saldo inicial: ");
		double saldo = sc.nextDouble();
		System.out.print("Limite de Saque: ");
		double limiteSaque = sc.nextDouble();
		
		Conta conta = new Conta(numero, titular, saldo, limiteSaque);
		
		System.out.print("Entre com o valor que deseja sacar: ");
		double valor = sc.nextDouble();
		
		saldo = conta.sacar(valor);
		System.out.print("Saldo Atualizado: " + saldo);
		
		}
		catch (DomainException e) {
			System.out.println("ERRO: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro Inesperado!");
		}
		
		
		sc.close();
		
	}

}
