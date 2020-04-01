package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Número do Quarto: ");
			int num = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());

			Reserva reserva = new Reserva(num, checkin, checkout);
			System.out.print(reserva.toString());

			System.out.println(" ");
			System.out.println(" ");
			
			System.out.println("Entre com a nova data para a reserva: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());

			reserva.updateDatas(checkin, checkout);
			System.out.println("Atualizado, " + reserva.toString());

		} catch (ParseException e) {
			System.out.println("Data inválida!");
		}
		  catch (DomainException e) {
			System.out.println("Erro nas datas: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro Inesperado!");
		}


		sc.close();
	}

}
