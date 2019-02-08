package fileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class FileReader {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		File file = new File("File Reader/src/assets/data.dat");
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			System.out.println(line);
			output(line);
		}

	}

	public static void output(String line) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("File Reader/src/assets/output.txt", "UTF-8");
		
		writer.append(line + "\n");
		writer.close();
	}

}
