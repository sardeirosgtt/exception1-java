package aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reservas;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		System.out.println("Numero do quarto");
		int numero = sc.nextInt();
		System.out.println("Ceck-In (dd/MM/yyy)");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Ceck-Out (dd/MM/yyy)");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: check-out date must be after check-in date");
		}
		else {
			Reservas reservas = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reserva: "+reservas);
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva");
			
			
			System.out.println("Ceck-In (dd/MM/yyy)");
			checkIn = sdf.parse(sc.next());
			System.out.println("Ceck-Out (dd/MM/yyy)");
			checkOut = sdf.parse(sc.next());
			
			String error = reservas.updateDates(checkIn, checkOut);
			if (error!=null) {
				System.out.println("Error in reservation: "+ error);
			}else {
			System.out.println("Reserva: "+reservas);	
			}
		 }
		sc.close();
	}
	
}
