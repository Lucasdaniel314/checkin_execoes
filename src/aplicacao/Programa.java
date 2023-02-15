package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entidade.HotelCheckin;
import model.exceptions.DomainException;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("número do quarto: ");
			int numeroDoQuarto = sc.nextInt(); 
			System.out.print("data de check-in (dd/mm/aaaa): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("data de check-out (dd/mm/aaaa): ");
			Date checkOut = sdf.parse(sc.next());
			
			HotelCheckin reserva = new HotelCheckin(numeroDoQuarto, checkIn, checkOut);
			System.out.println(reserva);
			
			System.out.println();
			System.out.println("atualize os dados da reserva: ");
			System.out.print("data de check-in (dd/mm/aaaa): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("data de check-out (dd/mm/aaaa): ");
			checkOut = sdf.parse(sc.next());
			
			System.out.println();
			reserva.atualizarDatas(checkIn, checkOut);
			System.out.println("(atualizado) " + reserva);
		} catch(InputMismatchException e) {
			System.out.println("erro: letra no numero de quarto");
		} catch (ParseException e) {
			System.out.println("erro: formato de data inválido!");
		} catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}

}
