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
		if(!racine.fils.isEmpty()) {
			for(int i=0; i<racine.fils.size(); i++) {
				nb++;
				nb += nombreNoeuds(racine.fils.get(i));
			}
			return nb;
		}
		return 0;
	}
	
	/**
	 * tests if two trees are equals (same number of children for each node)
	 * @param pattern is the root of the tree we want to compare to the target tree
	 * @param target root of the target tree
	 * @return true if they are the same, false if they are different
	 */
	public static boolean egalite(Noeud pattern, Noeud target) {
		if(!pattern.fils.isEmpty() && !target.fils.isEmpty()) {
			for(int i=0; i<pattern.fils.size();) {
				if(nombreNoeuds(pattern)==nombreNoeuds(target) && egalite(pattern.fils.get(i), target.fils.get(i))) {
					return true;
				} else {
					return false;
				}
			}		
		}
		return true;
	}
	
	public static Noeud comparaison(Noeud pattern, Noeud target) {
		Noeud subtree = new Noeud();
		if(egalite(pattern, target)) {
			subtree = pattern;
		}
		
		if(!pattern.fils.isEmpty()) {
			for(int i=0; i<pattern.fils.size();) {
				
				
				
				if(!target.fils.isEmpty()) {
			    	for(int j=0; j<target.fils.size();) {
			    		if(nombreNoeuds(subtree)< nombreNoeuds(comparaison(pattern.fils.get(i), target.fils.get(j))) ){
							
							//subtree 
						}
					}
				}
			}
		}
		return subtree;
	}
	
	/*
	 * if(egalite(pattern.fils.get(i), target.fils.get(i))) {
			    			subtree = pattern.fils.get(i); 
	   }
	 */
	
	public static void main(String[] args) {
		Noeud racine = new Noeud();
		Noeud racine2 = new Noeud();
		Noeud racine3 = new Noeud();
		racine = convertToTree("--(--((--))-)");
		racine2 = convertToTree("--(--((--))-)");
		racine3 = convertToTree("(-(--)-)");
		System.out.println(egalite(racine, racine2));
		System.out.println(egalite(racine, racine3));
	}
}