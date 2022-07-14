package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner teclado = new Scanner (System.in);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Please enter a Room Number: ");
		int roomN = teclado.nextInt();
		System.out.print("Whats the Check-in Date (dd/MM/yyyy)? ");
		Date in = format.parse(teclado.next());
		System.out.print("Whats the Check-out Date (dd/MM/yyyy)? ");
		Date out = format.parse(teclado.next());
		
		if(!out.after(in)) {
			
			System.out.println("Error in reservation: Check-out date must be after check-in date.");
		}
		else {
			Reservation reservation = new Reservation(roomN, in, out);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update your reservation: ");
			System.out.print("Whats the Check-in Date (dd/MM/yyyy)? ");
			in = format.parse(teclado.next());
			System.out.print("Whats the Check-out Date (dd/MM/yyyy)? ");
			out = format.parse(teclado.next());
			
			String error = reservation.updateDates(in, out);
			
			if (error != null) {
				System.out.println("Error in reservation: "+ error);
			}
			else {
			
				System.out.println("Reservation: " + reservation);
				
			}
		
		
		teclado.close();
	 }
  }

}
