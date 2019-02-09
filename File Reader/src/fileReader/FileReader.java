package fileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileReader {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			File input = new File("File Reader/src/assets/data.dat");
			File output = new File("File Reader/src/assets/output.txt");
			Scanner scanner = new Scanner(input);
			PrintWriter printer = new PrintWriter(output);
			
			while(scanner.hasNextLine()) {
				String s = scanner.nextLine();
				printer.write(s + "\n");
				// .close() only outputs the first line
				// Without .flush(), will not output anything
				printer.flush();
			}
			System.out.println("Done.");
		
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
}
