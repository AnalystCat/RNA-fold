import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;  


public class Main  {

	
	
	
	public static void main(String[] args) {

		
		
		System.out.println("                                                                    ,           \r\n"
				+ "                                                                  ,, ,,         \r\n"
				+ "                                                                  ,,,,.,,       \r\n"
				+ "                    ,*********.               ,,,, .,,,,,,,,,,   ,.  ,,  ,      \r\n"
				+ "  *** * * ,, * * *** * *,,* * **,           .,           ,,,  .,,,,,.  ,.       \r\n"
				+ "   ** * *.,* *.**, * *.,, * * * **        ,**             ,,,,,   .             \r\n"
				+ "      ********                            ***            ,,   ,,,   ,,,,   ,, ,,\r\n"
				+ "                                ,          ,             ,      ,,          ,,,,\r\n"
				+ " ,,,,,,,,,,,,,,,         ,,,,,,   ***,  .**              .,..,.  ,,.,,          \r\n"
				+ " ,,,,,,,,,,,,,,,,,     ,,,,,,,,       *                   ,,,,   ,,,,           \r\n"
				+ " ,,,,,,,   ,,,,,,,,   ,,,,,,,,        .********          .******    *******     \r\n"
				+ " ,,,,,,,   ,,,,,,,,   ,,,,,,       ,**************     *********,************   \r\n"
				+ " ,,,,,,, ,,,,,,,,,    ,,,,,,,,,   **************,**   **********,*************  \r\n"
				+ " ,,,,,,, ,,,,,,,      ,,,,,,,,,  ,******     *******  *******  *,****.  ******  \r\n"
				+ " ,,,,,,, ,,,,,,,,     ,,,,,,,,,  .******,    *******  *******  *,****.  ******  \r\n"
				+ " ,,,,,,,  ,,,,,,,,    ,,,,,,      ********** *******  *******  *,****.  ******  \r\n"
				+ " ,,,,,,,   .,,,,,,,   ,,,,,,        ,***,*** ***,***  **,***,  *,***,.  ,***,*  \r\n"
				+ "                                                                                \r\n"
				+ " *********.            ****        ****  ,,,,,,,,,                              \r\n"
				+ " ***,       ********   ****   *********     ,,,.  ,,,.,,.  ,,,,,,,    ,,,,,,,   \r\n"
				+ " ********  ****  .**** ****  ***,  ****     ,,,.  ,,,,.  ,,,,  .,,, ,,,,   ,,,  \r\n"
				+ " ***,      ****  ,***, ****  ****  ****     ,,,.  ,,,,   ,,,,       ,,,,        \r\n"
				+ " ***,        ******,   ****   ,*,**.***     ,,,.  ,,,,     ,,,,,,,    ,,,,,,,   \r\n"
				+ "");
		System.out.println("\n \n 1 : Visualiser \n 2 : Comparer deux  \n 3 : Demo");
		
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    
		

	    int menu = myObj.nextInt();
	    
	   
	    
	    
	    
	    
	    
	    if (menu == 1) {
	    	
	    	  // Create a Scanner object
	    	
	    	System.out.println("Donner votre Rfam index : ");
	    	String rfam = myObj.nextLine();
	    	rfam = "RF00017";
	    			
	    	
	    	Brin test1 = new Brin("","");
			try {
				test1 = Brin.getDataRfam(rfam);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        	System.out.println(test1.parenthesage);
        	System.out.println(test1.sequence);
        	
        	System.out.println("Un Rfam aleatoire est : ");
    		String randomrfam = "";
			try {
				randomrfam = Brin.RandomRfam();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
    				
			Brin test2 = new Brin("","");
			try {
				test2 = Brin.getDataRfam(randomrfam);
			} catch (IOException e) {
				e.printStackTrace();
			}
        	System.out.println(test2.parenthesage);
        	System.out.println(test2.sequence);
        	

	    	Noeud arbre1 = new Noeud();
	    	Noeud arbre2 = new Noeud();
	    	
	    	arbre1 = Noeud.convertToTree(test1.parenthesage);
	    	arbre2 = Noeud.convertToTree(test2.parenthesage);
	    	
	    	System.out.println("\n le plus grand sous arbre commun est : ");
	    	
	    	System.out.println(Noeud.convertToDashBracket(Noeud.comparaison(arbre1, arbre2)));
        	

	    	
	    }
	    if (menu == 2) {
	    	
	    	System.out.println("Donner votre 1e Rfam index : ");
	    	

	    	System.out.println("Donner votre 2e Rfam index : ");
	    	
	    	String rfam1 = "RF00053";
	    	String rfam2 = "RF00333";
	    	
	    	Brin test1 = new Brin("","");
			try {
				test1 = Brin.getDataRfam(rfam1);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Brin test2 = new Brin("","");
			try {
				test2 = Brin.getDataRfam(rfam2);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	
	    	Noeud arbre1 = new Noeud();
	    	Noeud arbre2 = new Noeud();
	    	
	    	arbre1 = Noeud.convertToTree(test1.parenthesage);
	    	arbre2 = Noeud.convertToTree(test2.parenthesage);
	    	
	    	System.out.println("le plus grand sous-arbre commun est : ");
	    	
	    	System.out.println(Noeud.convertToDashBracket(Noeud.comparaison(arbre1, arbre2)));

	    	
	    
	    
	    
	    	
	    }
	    
	    if (menu == 3) {
	
			Noeud racine = new Noeud();
	     	Noeud racine2 = new Noeud();
	
	        racine = Noeud.convertToTree("--(--((--))-)");
	        racine2 = Noeud.convertToTree("-----(--((--))-)");
	        System.out.println(Noeud.convertToDashBracket(racine));
			
			System.out.println(Noeud.convertToDashBracket(racine2));
			
			System.out.println("SOus arbre :");
			System.out.println(Noeud.convertToDashBracket(Noeud.comparaison(racine2, racine)));
		
	    }
	    myObj.close();
	}

}

