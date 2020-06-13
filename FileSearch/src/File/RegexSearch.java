package File;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Regex used to match the input string
 * @author User
 *
 */
public class RegexSearch extends Search{
	
	public static void searchString( String phrase) throws IOException {
		Set<String> fileSet=listFilesUsingJavaIO(".");
		for(String fileName:fileSet) {
		
		
		Scanner fileScanner = new Scanner(new File(fileName));
		int lineID = 0;
		Pattern pattern = Pattern.compile(phrase);
		Matcher matcher = null;
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			lineID++;
			matcher = pattern.matcher(line);
			if (matcher.find()) {
				lineID++;
			}

		}
		System.out.println("The given word is present for "+lineID+ " Times in the file "+fileName);
		}
		
	}
}
