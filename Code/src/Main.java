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
		System.out.println("\n \n 1 : Visualiser \n 2 : Comparer deux ");
		
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    
		

	    int menu = myObj.nextInt();
	    
	    if (!(menu == 1 || menu == 2 )) {
	    	
	    	while(!(menu == 1 || menu == 2 )) {
	    		System.out.println("Veuillez taper 1 ou 2 ");
	    		System.out.println("\n \n 1 : Visualiser \n 2 : Comparer deux ");
	    	}
	    if (menu == 1) {
	    	
	    	System.out.println("Donner votre Rfam index : ");
	    	String rfam = myObj.nextLine();
	    	
	    	
	    	Brin test1 = Brin.getDataRfam(rfam);
        	System.out.println(test1.parenthesage);
        	System.out.println(test1.sequence);
        	
        	System.out.println("Un Rfam aletoire est : ");
    		String rfamale;
			rfamale = Brin.RandomRfam();
    				
    		Brin test2 = Brin.getDataRfam(rfamale);
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
	    	String rfam1 = myObj.nextLine();
	    	
	    	System.out.println("Donner votre 2e Rfam index : ");
	    	String rfam2 = myObj.nextLine();
	    	
	    	Brin test1 = Brin.getDataRfam(rfam1);
	    	Brin test2 = Brin.getDataRfam(rfam1);
	    	
	    	Noeud arbre1 = new Noeud();
	    	Noeud arbre2 = new Noeud();
	    	
	    	arbre1 = Noeud.convertToTree(test1.parenthesage);
	    	arbre2 = Noeud.convertToTree(test2.parenthesage);
	    	
	    	System.out.println("le plus grand sous arbre commun est : ");
	    	
	    	System.out.println(Noeud.convertToDashBracket(Noeud.comparaison(arbre1, arbre2)));

	    	
	    }
	    
	    myObj.close();
	    
	    	
	    }
	
		
	}


}
