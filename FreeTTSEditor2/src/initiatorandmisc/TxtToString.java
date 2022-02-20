package initiatorandmisc;

//This class converts a txt file to a string that kevin will read
//Method convertTxtToString does the job
//Path is the path of the .txt file
//The string that outcomes is the String content


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



public class TxtToString {
	public String convertTxtToString(String path)  {
		String content ="";
	
		try {

			  // default StandardCharsets.UTF_8
           content = Files.readString(Paths.get(path));
          

      } catch (IOException e) {
          e.printStackTrace();
      }
		return content;
	}
	
	
}