package objets;

public class Chaudron {
	private int quantitePotion;
    private int forcePotion;

    public void remplirChaudron(int quantite, int forcePotion) {
    	this.quantitePotion = quantite;
        this.forcePotion = forcePotion;
    }

    public boolean resterPotion() {
    	return quantitePotion > 0;
    }

    public int prendreLouche() {
    	quantitePotion--;
        int forceRendue = forcePotion;
        if (quantitePotion == 0) {
            forcePotion = 0;
        }
        return forceRendue;
    }

}
