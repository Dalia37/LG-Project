package LG;

import java.time.LocalDate;
import java.util.Random;

public class Parameter {
	
	Random random = new Random();
	String[] emails = {
            "user1@example.com",
            "user2@gmail.com",
            "user3@yahoo.com",
            "user4@hotmail.com",
            "user5@example.com",
            "user6@gmail.com",
            "user7@yahoo.com",
            "user8@hotmail.com",
            "user9@example.com",
            "user10@gmail.com"
        };
	int RandEmail = random.nextInt(emails.length);
	
	 String[] passwords = {
			  "DODA4672121@Amal"
	        };
	 int RandPassword = random.nextInt(passwords.length);
	 
	   LocalDate[] datesOfBirth = {
	            LocalDate.of(1990, 5, 15),
	            LocalDate.of(1985, 8, 22),
	            LocalDate.of(1992, 11, 7),
	            LocalDate.of(1980, 3, 12),
	            LocalDate.of(1995, 6, 25),
	            LocalDate.of(1988, 9, 30),
	            LocalDate.of(1976, 2, 18),
	            LocalDate.of(1998, 12, 5),
	            LocalDate.of(1982, 7, 9),
	            LocalDate.of(2000, 4, 3)
	        };
	   
	   int RandDates = random.nextInt(datesOfBirth.length);

}



