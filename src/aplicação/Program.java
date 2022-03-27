package aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reservas;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		try {
			System.out.println("Numero do quarto");
			int numero = sc.nextInt();
			System.out.println("Ceck-In (dd/MM/yyy)");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Ceck-Out (dd/MM/yyy)");
			Date checkOut = sdf.parse(sc.next());
			
			
			
			Reservas reservas = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reserva: "+reservas);
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva");
			
			
			System.out.println("Ceck-In (dd/MM/yyy)");
			checkIn = sdf.parse(sc.next());
			System.out.println("Ceck-Out (dd/MM/yyy)");
			checkOut = sdf.parse(sc.next());
			
			reservas.updateDates(checkIn, checkOut);
			System.out.println("Reserva: "+reservas);	
		}catch(ParseException e){
			System.out.println("data com fomato invalido");	
		}catch (DomainException e) {
			System.out.println("Error in reservatiom: "+e.getMessage());
		}catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();
	}
	
}
