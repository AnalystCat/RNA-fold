import java.util.ArrayList;
import java.util.Stack;

public class Noeud {
	ArrayList<Noeud> fils;

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
	 * 
	 * @param racine is the root of the subtree
	 * @return 
	 */
	public static String convertToDashBracketInter(Noeud racine) {
		String parenthesage = "";
		if(!racine.fils.isEmpty()) {
			parenthesage += "(";
			for(int i=0; i<racine.fils.size(); i++) {
				parenthesage += convertToDashBracketInter(racine.fils.get(i));
			}
			return parenthesage + ")";
		}
		return "-";
	}
	
	/**
	 * 
	 * @param racine is the root of the tree
	 * @return final Dash Bracket format
	 */
	public static String convertToDashBracket(Noeud racine) {
		String parenthesage = convertToDashBracketInter(racine);
		return parenthesage.substring(1, parenthesage.length() - 1);
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
		else if(pattern.fils.isEmpty() && target.fils.isEmpty()) return true;
		return false;
	}
	
	/**
	 * give largest common subtree between two given tree
	 * @param pattern is the root of the tree we want to compare to the target tree
	 * @param target root of the target tree
	 * @return the root of the subtree
	 */
	public static Noeud comparaison(Noeud pattern, Noeud target) {
		Noeud maxsubtree = new Noeud();
		Noeud subtree = new Noeud();
		
		if(egalite(pattern, target)) {
			maxsubtree = pattern;
		}
		
		if(!pattern.fils.isEmpty()) {
			for(int i=0; i<pattern.fils.size(); i++) {
				if(!target.fils.isEmpty()) {
			    	for(int j=0; j<target.fils.size(); j++) {
			    		subtree = comparaison(pattern.fils.get(i), target.fils.get(j));
			    		if(nombreNoeuds(maxsubtree) < nombreNoeuds(subtree)) {
			    			maxsubtree = subtree;
						}
					}
				}
			}
		}
		return maxsubtree;
	}
	
	public static void main(String[] args) {
		Noeud racine = new Noeud();
		Noeud racine2 = new Noeud();

		
		racine = convertToTree("--(--((--))-)");
		racine2 = convertToTree("-----(--((--))-)");
		
		
		System.out.println(convertToDashBracket(racine));
		
		System.out.println(convertToDashBracket(racine2));

		System.out.println(convertToDashBracket(comparaison(racine2, racine)));
		
		/*System.out.println("ok1");
		res = comparaison(racine3, racine);
		System.out.println("ok2");
		System.out.println(egalite(res, racine));*/
	}
}