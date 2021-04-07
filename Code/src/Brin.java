import java.util.*;
import java.io.*;
import java.net.*;

public class Brin {
    private String sequence;
    private String parenthesage;
    private static int index = 0; // à garder ?
    
    public Brin(String sequence, String parenthesage) {
        this.sequence = sequence;
        this.parenthesage = parenthesage;
        index++;
    }

    /**
     * creates an object of type Brin with its sequence and its "parenthesis format"
     * @param rFamName name of the chosen family
     * @return donnee of type Brin
     * @throws IOException
     */
    public static Brin getDataRfam(String rFamName) throws IOException {
    	String parenthesage = "";
    	String sequence = "";
    	
        URL url = new URL("https://rfam.org/family/"+ rFamName +"/alignment/stockholm");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine;
       
        while ((inputLine = in.readLine()) != null) {
        	if(inputLine.startsWith("#=GC SS_cons")) {
        		inputLine = inputLine.substring(13).replaceAll("[<{]", "(").replace("[", "(");
        		inputLine = inputLine.replaceAll("[>}]", ")").replace("]", ")");
        		parenthesage = inputLine.replaceAll("[;:,_]", "-").replaceAll("[ .]", "");
        	}
        	if(inputLine.startsWith("#=GC RF")) {
        		sequence = inputLine.substring(8).replaceAll("[ .]", "").toUpperCase();
        	}
        }
        
        in.close();
        
    	Brin donnee = new Brin(sequence, parenthesage);
        return donnee;
    }
    
    /**
     * chooses a random family name in the Rfam database
     * @return result name of a random family
     * @throws FileNotFoundException
     */
    @SuppressWarnings("resource")
	public static String RandomRfam() throws FileNotFoundException {
    	File f = new File("data/data.txt");
		String result = null;
		Random rand = new Random();
		int n = 0;
		Scanner sc;
     
		for(sc = new Scanner(f); sc.hasNext(); ) {
			++n;
			String line = sc.nextLine();
			if(rand.nextInt(n) == 0)
				result = line;         
		}
     
		sc.close();
     
		return result;      
	}

	public static void main(String[] args) {
        try {
        	Brin test = getDataRfam("RF00360");
        	System.out.println(test.parenthesage);
        	System.out.println(test.sequence);
		} catch (IOException e) {
			e.printStackTrace();
		}
        try {
        	Brin test2 = getDataRfam(RandomRfam());
        	System.out.println(test2.parenthesage);
        	System.out.println(test2.sequence);
        } catch (IOException e) {
        	e.printStackTrace();
		}
    }
}
