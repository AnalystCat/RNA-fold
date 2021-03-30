import java.io.*;
import java.net.*;


public class Brin {
    String sequence;
    String Parentasage;
    int index;
    
    public Brin(String sequence, String parentasage, int index) {
        this.sequence = sequence;
        this.Parentasage = parentasage;
        this.index = index;
    }

    public static Brin GetDataRfam(int index, String rFamName  ) throws IOException {
        

    	
    	
    	String parentasage = "" ;
    	String sequence = "";
    	
        URL url = new URL("https://rfam.org/family/"+ rFamName +"/alignment/stockholm");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(url.openStream()));

        String inputLine;
       
        while ((inputLine = in.readLine()) != null) {
        	if(inputLine.startsWith("#=GC SS_cons")) {
        		
        		inputLine = inputLine.substring(13).replaceAll("[<{]", "(").replace("[", "(");
        		inputLine = inputLine.replaceAll("[>}]", ")").replace("]", ")");
        		parentasage = inputLine.replaceAll("[;:_]", "-").replaceAll("[ .]","");
        		
        	}
        	if(inputLine.startsWith("#=GC RF")) {
        		
        		sequence = inputLine.substring(8).replaceAll("[ .]","").toUpperCase();
        	}
        
        }
        in.close();
    	Brin donne = new Brin(sequence, parentasage, index);
    	
        return donne;
    }


	public static void main(String[] args) {
        System.out.println("hello");
        try {
        	Brin test =GetDataRfam(1);
        	System.out.println(test.Parentasage);
        	System.out.println(test.sequence);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
