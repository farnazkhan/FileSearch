package File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Indexed Based search
 * @author User
 *
 */
public class IndexedSearch extends Search {

	private static List<HashMap> list=new ArrayList<>();
	// The static block that initializes the Index
	static {
		//Read each file 
		Set<String> fileSet=listFilesUsingJavaIO(".");
		for(String fileName:fileSet) {
			  if(fileName.endsWith(".txt")) {
				
		String content;
		try {
			content = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
		
		String[] words;
		Set<String> uniqueWords = new HashSet<String>();
		words = content.split("[\\W]+");
		for (int i = 0; i < words.length; i++)
		{
		    uniqueWords.add(words[i]);
		}
		HashMap<String,Integer> map=new HashMap<>();
		//System.out.println(uniqueWords);
		
		for(String word: uniqueWords)
		countOccurences(content, word,map);
		Map<Object, Object> collect=map.entrySet().stream().filter(e->e.getValue()>=1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		list.add((HashMap) collect);
		
		
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		}
	}}
	
	  
	 
	
public static void searchWord (String input) throws IOException, InterruptedException {
	long currentTime=System.nanoTime();
	
	
	for(int i=0;i<list.size();i++)
	{
	if(list.get(i).get(input)!=null) 
	{
		  System.out.println("The given word is present for "+list.get(i).get(input)+ " times, searched from the cache Times in the file "+i);
	}
	
	}
	
  
}

static int countOccurences(String str, String word, HashMap<String,Integer> map)  
{ 
    
	// split the string by spaces in a 
    String a[] = str.split(" "); 
  
    // search for pattern in a 
    int count = 0; 
    for (int i = 0; i < a.length; i++)  
    { 
    // if match found increase count 
    if (word.equals(a[i])) 
        count++; 
    } 
    map.put(word, count);
    
  
    return count; 
} 
	
}
