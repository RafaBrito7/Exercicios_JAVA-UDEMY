package principal;

import java.util.Scanner;

import entities.Estudante;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Estudante quartos[] = new Estudante [10];
		
		System.out.println("Quantos quartos vai querer alugar?");
		System.out.println("[Máximo 10 Quartos]");
		int n = sc.nextInt();
		sc.nextLine();
		if (n < 1 || n > 10) {
			System.out.println("Quantidade Máxima ultrapassada!");
		}
		int i = 0;
		while (i < n ) {
			System.out.println("Informe o nome do Estudante: ");
			String nome = sc.nextLine();
			
			System.out.println("Informe o email do Estudante: ");
			String email = sc.nextLine();
			
			System.out.println("Informe o número do quarto: ");
			int numeroQuarto = sc.nextInt();
			
			if (quartos[i] == null) {
				quartos[i] = new Estudante(nome, email, numeroQuarto);
			}
			i++;
			sc.nextLine();
		}
		
		for (int j = 0; j < n; j++) {
			if (quartos[j + 1 ] != null) {
				int cont = 1 ;
				if (quartos[j].getNumeroQuarto() > quartos[j + cont].getNumeroQuarto()) {
					Estudante temp = quartos[j+cont];
					quartos [j+cont] = quartos[j];
					quartos[j] = temp;
					if (j > 0) {
						if (quartos[j - 1].getNumeroQuarto() > quartos[j].getNumeroQuarto()) {
							temp = quartos[j - 1];
							quartos[j - 1] = quartos[j];
							quartos[j] = temp;
						}
					}
				}
				cont++;
			}
		}
		for (int j = 0; j < n; j++) {
			System.out.println(quartos[j].toString());
		}
		sc.close();
	}

}
