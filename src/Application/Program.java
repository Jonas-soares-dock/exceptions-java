package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args)  {
		
		Scanner teclado = new Scanner (System.in);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Please enter a Room Number: ");
			int roomN = teclado.nextInt();
			System.out.print("Whats the Check-in Date (dd/MM/yyyy)? ");
			Date in = format.parse(teclado.next());
			System.out.print("Whats the Check-out Date (dd/MM/yyyy)? ");
			Date out = format.parse(teclado.next());

		
			Reservation reservation = new Reservation(roomN, in, out);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update your reservation: ");
			System.out.print("Whats the Check-in Date (dd/MM/yyyy)? ");
			in = format.parse(teclado.next());
			System.out.print("Whats the Check-out Date (dd/MM/yyyy)? ");
			out = format.parse(teclado.next());
			
			reservation.updateDates(in, out);
			System.out.println("Reservation: " + reservation);	
			
		}
		catch (ParseException e) {
			System.out.println("Invalid date Format");
		}
		catch (DomainException i) {
			System.out.println("Error in reservation: "+ i.getMessage());
		}
		catch (RuntimeException r) {
			System.out.println("Unexpected error");
		}
		
	
		
		teclado.close();
	 
  }

}
