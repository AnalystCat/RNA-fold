    import java.io.*;

	import java.net.*;
	import java.util.Scanner;

public class URLReader {

	    public static void main(String[] args) throws Exception {
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("Nom de la famille: ");
	        String str1 = sc.next();
	        
	        //Concatenating the two Strings
	        URL url = new URL("https://rfam.org/family/"+str1+"/alignment/stockholm");
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(url.openStream()));

	        String inputLine;
	       
	        while ((inputLine = in.readLine()) != null) {
	        	
	        	String  aaa;
	        	if(inputLine.startsWith("#=GC SS_cons")) {
	        		System.out.println("Trouvé !");
	        		inputLine = inputLine.substring(13).replaceAll("[<{]", "(").replace("[", "(");
	        		inputLine = inputLine.replaceAll("[>}]", ")").replace("]", ")");
	        		aaa = inputLine.replaceAll("[;:_]", "-").replaceAll("[ .]","");
	        		
	        		System.out.println(aaa);
	        	}
	        	if(inputLine.startsWith("#=GC RF")) {
	        		System.out.println("Trouvé !".toUpperCase());
	        		inputLine = inputLine.substring(8).replaceAll("[ .]","").toUpperCase();
	        		
	        		System.out.println(inputLine);
	        	}
	        
	        }
	        in.close();
	        sc.close();
    }
}