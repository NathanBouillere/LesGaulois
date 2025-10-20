
package personnages;

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
	
	public int getForcePotion() {
		return forcePotion;
		
	}
	
	public void prendreLoucher() {
		if(quantitePotion > 0) {
			quantitePotion--;
		}
		if(quantitePotion == 0) {
			forcePotion = 0;
		}
	}
	
	
}

