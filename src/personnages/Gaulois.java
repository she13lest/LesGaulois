package personnages;
import village_gaulois.Musee;
import village_gaulois.Village;
import objets.Equipement;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private Village village;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	private static final String BONJOUR = "Bonjour, je m'appelle ";
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setVillage(Village village) {
		this.village = village;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	public void frapper(Romain romain) {
	    System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
	    Equipement[] newTrophees = romain.recevoirCoup((force / 2) * effetPotion);
	    effetPotion--;
	    if (effetPotion < 1) {
	        effetPotion = 1;
	    }
	    for (int i = 0; newTrophees != null && i < newTrophees.length; i++, nbTrophees++) {
	        this.trophees[nbTrophees] = newTrophees[i];
	    }
	}
	
	private String prendreParole() {
	    return "Le gaulois " + nom + " : ";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}
	
	public void sePresenter() {
		if (village == null) {
			parler(BONJOUR + nom + ". Je voyage de villages en villages.");
		} else if (village.getChef() == this) {
			parler(BONJOUR + nom + ". Je suis le chef le village : " + village.getNom() + ".");
		} else {
			parler(BONJOUR + nom + ". J'habite le village : " + village.getNom() + ".");
		}
	}
	
	public void faireUneDonnation(Musee musee) {
		if (nbTrophees > 0) {
			String texte = "Je donne au musee tous mes trophees :";
			for (int i = 0; i < nbTrophees; i++) {
				texte += "\n- " + trophees[i].toString();
				musee.donnerTrophees(this, trophees[i]);
				trophees[i] = null;
			}
			nbTrophees = 0;
			parler(texte);
		}
	}

}
