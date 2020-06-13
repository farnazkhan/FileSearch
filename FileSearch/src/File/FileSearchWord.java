package File;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
/**
 * This is the main class that executes the Search program
 * @author User
 *
 */
public class FileSearchWord {
	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

		System.out.println("Enter the search term:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String searchString = br.readLine();
		System.out.println("Search  Method: 1) String Match 2) Regular Expression 3) Indexed");
		String searchMethod = br.readLine();
		int searchMethodInt = Integer.parseInt(searchMethod);
		System.out.println(searchString + " " + searchMethod);

		
		switch (searchMethodInt) {
		case 1: {
			SimpleSearch.searchWord(searchString);

			break;
		}

		case 2: {
			
				RegexSearch.searchString( searchString);
			
			break;
		}
		case 3: {

			IndexedSearch.searchWord(searchString);

			break;
		}

		default: {
			System.out.println("Invalid value");
			break;
		}
		}

	}


}