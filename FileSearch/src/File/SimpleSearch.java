package File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

/**
 * Simple Search - where each word is picked
 * @author User
 *
 */
public class SimpleSearch extends Search {

	
	public static void searchWord(String input) throws IOException {
		Set<String> fileSet=listFilesUsingJavaIO(".");
		for(String filename:fileSet) {
		  
		File f1=new File(filename); //Creation of File Descriptor for input file
		  String[] words=null;  //Intialize the word Array
	      FileReader fr = new FileReader(f1);  //Creation of File Reader object
	      BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
	      String s;     
	      int count=0;   //Intialize the word to zero
	      while((s=br.readLine())!=null)   //Reading Content from the file
	      {
	         words=s.split(" ");  //Split the word using space
	          for (String word : words) 
	          {
	                 if (word.equals(input))   //Search for the given word
	                 {
	                   count++;    //If Present increase the count by one
	                 }
	          }
	      }
	      if(count!=0)  //Check for count not equal to zero
	      {
	         System.out.println("The "+input+" word is present for "+count+ " Times in the file "+filename);
	      }
	     
	         fr.close();
			}
		 
	     
	}
	
}
