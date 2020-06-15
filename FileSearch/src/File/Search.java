package File;

import java.io.File;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This is a Base class for our Search mechanism
 * @author User
 *
 */
public class Search {

	
	  public static Set<String> listFilesUsingJavaIO(String dir) {
		    return Stream.of(new File(dir).listFiles())
		      .filter(file -> !file.isDirectory())
		      .map(File::getName)
		      .collect(Collectors.toSet());
		}
}
