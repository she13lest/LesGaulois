package personnages;
import objets.Equipement;

public class Romain {
	private String nom;
    private int force;
    private Equipement[] equipements;
    private int nbEquipement = 0;
    
    
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
        assert isInvariantVerified();
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
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
    
    private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
			} else {
				ajouterEquipement(equipement);
			}
			break;
		case 0:
			ajouterEquipement(equipement);
			break;
		}
	}
    
}
