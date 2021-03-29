import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Brin {
    String sequence;
    String dotFormat;
    int index;

    public static String parserStockholmToDot() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nom de la famille: ");
        String str1 = sc.next();
        //Concatenating the two Strings
        URL url = new URL("https://rfam.org/family/"+str1+"/alignment/stockholm");
        /* Ouvre une connection avec l'object URL */
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        //Methode GET
        connection.setRequestMethod("GET");

        /* Utilise BufferedReader pour lire ligne par ligne */
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String inputLine;

        StringBuffer content = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        //Ferme BufferedReader
        in.close();
        sc.close();

        System.out.println(inputLine);

        return "";
    }

    public static void main(String[] args) {
        System.out.println("hello");
        try {
			parserStockholmToDot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
