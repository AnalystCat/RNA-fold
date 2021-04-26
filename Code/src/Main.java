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
	    	Brin test = getDataRfam(rfam);
        	System.out.println(test.parenthesage);
        	System.out.println(test.sequence);
        	
        	System.out.println("Un Rfam aletoire est : ");
    		String rfamale = RandomRfam();
    				
    		Brin test2 = getDataRfam(rfamale);
        	System.out.println(test2.parenthesage);
        	System.out.println(test2.sequence);
        	

	    	Noeud arbre1 = new Noeud();
	    	Noeud arbre2 = new Noeud();
	    	
	    	arbre1 = convertToTree(test1);
	    	arbre2 = convertToTree(test2);
	    	
	    	System.out.println("\n le plus grand sous arbre commun est : ");
	    	
	    	System.out.println(convertToDashBracket(comparaison(arbre1, arbre2)));
        	
        	
	    	
	    }
	    if (menu == 2) {
	    	
	    	System.out.println("Donner votre 1e Rfam index : ");
	    	String rfam1 = myObj.nextLine();
	    	
	    	System.out.println("Donner votre 2e Rfam index : ");
	    	String rfam2 = myObj.nextLine();
	    	
	    	Brin test1 = getDataRfam(rfam);
	    	Brin test2 = getDataRfam(rfam);
	    	
	    	Noeud arbre1 = new Noeud();
	    	Noeud arbre2 = new Noeud();
	    	
	    	arbre1 = convertToTree(test1);
	    	arbre2 = convertToTree(test2);
	    	
	    	System.out.println("le plus grand sous arbre commun est : ");
	    	
	    	System.out.println(convertToDashBracket(comparaison(arbre1, arbre2)));

	    	
	    }
	    
	    
	    
	    	
	    }
	
		
	}


}
