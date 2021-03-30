import java.util.ArrayList;

public class Noeud {
	private Noeud pere;
	private ArrayList<Noeud> fils;
	
	// for root only (no father)
	public Noeud() {
        this.fils = new ArrayList<>();
    }
	
	public Noeud(Noeud pere) {
		this.pere = pere;
        this.fils = new ArrayList<>();
    }
	
	public void ajoutFils(Noeud n) {
		this.fils.add(n);
	}
	
	// en cours
	public Noeud convertToTree(String parenthesage) {
		String[] elements = parenthesage.split("");
		if (elements != null) {
			Noeud n = new Noeud();
			for(int i=0; i<parenthesage.length(); i++) {
				if(elements[i] == "(") {
					
				}
				if(elements[i] == "-") {
					
				}
			}
			return n;
		}
		return null;
	}
	
	public static void main(String[] args) {
		Noeud racine = new Noeud();
		Noeud f1 = new Noeud(racine);
		racine.ajoutFils(f1);
	}
}
