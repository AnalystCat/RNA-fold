import java.util.ArrayList;
import java.util.Stack;

public class Noeud {
	private ArrayList<Noeud> fils;

	public Noeud() {
        this.fils = new ArrayList<>();
    }
	
	public void ajoutFils(Noeud n) {
		this.fils.add(n);
	}
	
	// en cours
	public Noeud convertToTree(String parenthesage) {
		String[] elements = parenthesage.split("");
		System.out.println(elements);
		Stack<Noeud> pile = new Stack<Noeud>();
		Noeud pere = new Noeud();
		Noeud racine = new Noeud();
		pere = racine;
		
		for(int i=0; i<parenthesage.length(); i++) {
		 	System.out.println(elements[i]);
			/*if(elements[i] == "(") {
				Noeud n = new Noeud();
				pile.push(n);
				System.out.println("(");
				pere = n;
			}
			else if(elements[i] == "-") {
				Noeud n = new Noeud();
				pile.push(n);
				System.out.println("-");
				pere.ajoutFils(n);
				pile.pop();
			}
			// elements[i] == ")"
			else {
				pile.pop();
				System.out.println(")");
			}*/
		}
		return racine;
	}
	
	public static void main(String[] args) {
		Noeud racine = new Noeud();
		racine.convertToTree("((((((---------------------------------------------------------------------------------------------------------))))))");
	}
}