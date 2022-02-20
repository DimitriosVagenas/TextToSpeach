package fttsEditor;

public class Encoder {
 
	private static String plain = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" ;
    private static String cipher= "zyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBA";
	
  //reverser method reverses the words of the main text    	
	public String reverser(String reversed) {
		String words[]=reversed.split(" ");
		reversed="";
		for (int i = 1; i < words.length; i++) {
		  reversed += words[words.length-i]+ " ";
		}
		reversed +=words[0];
		
		return reversed;
		
	}
	
	


//atBash method implements atBash encoding to the main text    
    
    public String atBash(String input) {
    	String atbash ="";
    	for(int i=0; i<input.length();i++) {
    		if( plain.indexOf(input.charAt(i))>-1)  {
    			atbash+=cipher.charAt(plain.indexOf(input.charAt(i)));
    		
			}
    		else{
    			atbash+=input.charAt(i);
    				
    		}
    	}
    	return atbash;
    }
    

  //rot13 method implements rot13 encoding to the main text 
    
    public String rot13(String value) {
		
        char[] values = value.toCharArray();
        for (int i = 0; i < values.length; i++) {
            char letter = values[i];

            if (letter >= 'a' && letter <= 'z') {
                if (letter > 'm') {
                    letter -= 13;
                } else {
                    letter += 13;
                }
            } else if (letter >= 'A' && letter <= 'Z') {
                if (letter > 'M') {
                    letter -= 13;
                } else {
                    letter += 13;
                }
            }
            values[i] = letter;
        }
        // Convert array to a new String.
        return new String(values);
	}	
}