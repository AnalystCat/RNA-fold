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
	
	/**
	 * converts a Dash Bracket format to a fold rna tree
	 * @param parenthesage Dash Bracket format
	 * @return racine root of the fold rna tree
	 */
	public static Noeud convertToTree(String parenthesage) {
		Stack<Noeud> pile = new Stack<Noeud>();
		Noeud racine = new Noeud();
		pile.push(racine);
		
		for(int i=0; i<parenthesage.length(); i++) {
			char chara = parenthesage.charAt(i);
			if(chara == '(') {
				Noeud n = new Noeud();
				Noeud pere = new Noeud();
				pere = pile.peek();
				pile.pop();
				pere.ajoutFils(n);
				pile.push(pere);
				pile.push(n);
			}
			else if(chara == '-') {
				Noeud n = new Noeud();
				Noeud pere = new Noeud();
				pere = pile.peek();
				pile.pop();
				pere.ajoutFils(n);
				pile.push(pere);
			}
			// chara == ')'
			else {
				pile.pop();
			}
		}
		return pile.peek();
	}
	
	/**
	 * traversal of the tree, every node is counted and then the total number is returned
	 * @param racine is the root of the subtree
	 * @return number of nodes in the subtree
	 */
	public static int nombreNoeuds(Noeud racine) {
		int nb = 0;
		if (!racine.fils.isEmpty()) {
			for(int i=0; i<racine.fils.size(); i++) {
				nb++;
				nb += nombreNoeuds(racine.fils.get(i));
			}
			return nb;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println("ok");
		Noeud racine = new Noeud();
		Noeud n1 = new Noeud();
		racine.ajoutFils(n1);
		racine.ajoutFils(n1);
		racine = convertToTree("--(--((--))-)");
		System.out.println("res = "+ nombreNoeuds(racine));
	}
}