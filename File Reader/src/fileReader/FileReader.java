package fileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileReader {
	
	static String id;
	static String firstName;
	static String lastName;
	static String houseNumber;
	static String street;
	static String state;
	static String zipCode;
	static String comma = ", ";

	public static void main(String[] args) throws FileNotFoundException {
		try {
			File input = new File("File Reader/src/assets/data.dat");
			File output = new File("File Reader/src/assets/output.txt");
			Scanner scanner = new Scanner(input);
			PrintWriter printer = new PrintWriter(output);
			
			while (scanner.hasNextLine()) {
				String s = scanner.nextLine();
				// substring is not the most efficient, but works for now
				// not ideal for maintainability
				// trim removes spaces
				id = (s.substring(0, 3).trim());
				firstName = (s.substring(5, 12).trim());
				lastName = (s.substring(12, 22).trim());
				houseNumber = (s.substring(24, 30).trim());
				street = (s.substring(30, 42).trim());
				state = (s.substring(44, 46).trim());
				zipCode = (s.substring(48, 53).trim());
				
				// call write function to print to output file
				write(printer, id);
				write(printer, firstName);
				write(printer, lastName);
				write(printer, houseNumber);
				write(printer, street);
				write(printer, state);
				write(printer, zipCode);
				printer.write("\n");
				// .close() only outputs the first line
				// Without .flush(), will not output anything
				printer.flush();
			}
			
			System.out.println("Done.");
		
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
	
	public static void write(PrintWriter p, String s) {
		p.write(s);
		p.write(comma);
	}
}
