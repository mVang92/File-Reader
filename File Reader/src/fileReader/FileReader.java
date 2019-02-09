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
			
			while(scanner.hasNextLine()) {
				String s = scanner.nextLine();
				// substring is not the most efficient, but works for now
				id = (s.substring(0, 3));
				write(printer, id);
				firstName = (s.substring(5, 12).trim());
				write(printer, firstName);
				lastName = (s.substring(12, 22).trim());
				write(printer, lastName);
				houseNumber = (s.substring(24, 30).trim());
				write(printer, houseNumber);
				street = (s.substring(30, 42).trim());
				write(printer, street);
				state = (s.substring(44, 46).trim());
				write(printer, state);
				zipCode = (s.substring(48, 53).trim());
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
