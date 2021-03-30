

import java.io.*;
import java.util.*;

public class RandomRfam {

  public static void main(String[] args) throws FileNotFoundException {
     
     
       String s = choose(new File("data.txt"));
       

     System.out.println(s);
  }

  @SuppressWarnings("resource")
public static String choose(File f) throws FileNotFoundException
  {
     String result = null;
     Random rand = new Random();
     int n = 0;
     Scanner sc;
     for( sc = new Scanner(f); sc.hasNext(); )
     {
        ++n;
        String line = sc.nextLine();
        if(rand.nextInt(n) == 0)
           result = line;         
     }
     sc.close();
     return result;      
  }
}