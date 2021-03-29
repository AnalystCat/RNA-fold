import java.net.*;
import java.util.Scanner;
import java.io.*;

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
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
        sc.close();
    }
}