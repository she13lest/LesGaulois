package personnages;

public class Romain {
	private String nom;
    private int force;
    
    
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}
	
    
	public void parler(String texte) {
        System.out.println(prendreParole() + "\"" + texte + "\"");
    }
	
	
	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0;
		int forceInit = force;
		
		force -= forceCoup;
        if (force > 0) {
            parler("Aïe");
        } else {
        	force = 0;
            parler("J'abandonne !");
        }
        assert isInvariantVerified();
        assert force < forceInit;
	}
	

    private String prendreParole() {
        return "Le romain " + nom + " : ";
    }
    
    
    private boolean isInvariantVerified() {
        return force >= 0;
    }
    
    public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
	}
    
}
