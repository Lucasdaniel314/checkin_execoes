package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidade.HotelCheckin;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("número do quarto: ");
		int numeroDoQuarto = sc.nextInt(); 
		System.out.print("data de check-in (dd/mm/aaaa): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("data de check-out (dd/mm/aaaa): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("erro: check-out antes do ckeck-in");
		} else {
			HotelCheckin reserva = new HotelCheckin(numeroDoQuarto, checkIn, checkOut);
			System.out.println(reserva);
			System.out.println();
			System.out.println("atualize os dados da reserva: ");
			System.out.print("data de check-in (dd/mm/aaaa): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("data de check-out (dd/mm/aaaa): ");
			checkOut = sdf.parse(sc.next());
			
			Date agora = new Date();
			if(checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println(
				"erro: para atualizar data, deve atualizar para datas futuras!");
			} else if(!checkOut.after(checkIn)) {
				System.out.println("erro: check-out antes do ckeck-in");
			} else {
				System.out.println();
				reserva.atualizarDatas(checkIn, checkOut);
				System.out.println(reserva);
			}
		}
		
		sc.close();
	}

}
