package File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

/**
 * Unit test class to test performance of each search method.
 * @author User
 *
 */
class FileSearchWordTest {

	private String[] words;
	
	public  FileSearchWordTest()  {
		
		String content;
		try {
			content = new Scanner(new File("test.txt")).useDelimiter("\\Z").next();
			words = content.split("[\\W]+");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//@Test
	void testSimpleSearch() throws IOException, InterruptedException {
		
		long currentTime=System.currentTimeMillis();
		
		for (int i = 0; i < words.length; i++)
		{
		SimpleSearch.searchWord(words[i]);
		} 
		System.out.println("*****************Elapsed time:");
	    System.out.print(System.currentTimeMillis()-currentTime);
	    // Time taken: 9529 milliseconds
		     
	}

	//@Test
	void testRegexSearch() throws IOException, InterruptedException {
		
		long currentTime=System.currentTimeMillis();
		
		for (int i = 0; i < words.length; i++)
		{
		RegexSearch.searchString(words[i]);
		} 
		System.out.println("*****************Elapsed time:");
	    System.out.print(System.currentTimeMillis()-currentTime);
	    // Time taken: 11703 milliseconds
		     
	}

	@Test
	void testIndexedSearch() throws IOException, InterruptedException {
		
		long currentTime=System.currentTimeMillis();
		
		for (int i = 0; i < words.length; i++)
		{
		IndexedSearch.searchWord(words[i]);
		} 
		System.out.println("*****************Elapsed time:");
	    System.out.print(System.currentTimeMillis()-currentTime);
		 //Time taken: 415 milliseconds
	}

}
