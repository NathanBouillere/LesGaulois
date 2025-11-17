package personnages;

import objets.Equipement;
import objets.Musee;

public class Gaulois {
	private String nom;
	//private int force;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	private int effetPotion;
	private Village village;
	
	

	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.effetPotion = 1;
	}
	
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	
	public static void main(String[] args) {
		Gaulois asterix;
		Gaulois obelix;
		asterix = new Gaulois("Asterix", 8);
		obelix = new Gaulois("Obélix", 8);

		System.out.println(asterix.getNom());
		System.out.println(obelix.getNom());
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		Equipement[] tropheesBataille = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesBataille != null && i < tropheesBataille.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesBataille[i];
		}
	}

	
	public String toString() {
		return nom;
	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;

		
		
	}
	
	public void setVillage(Village village) {
		this.village = village;
		
	}
	
	public void sePresenter() {
		if(village!=null) {
			if (this == village.getChef()) {
				parler("Bonjour, je m'appelle " + nom + ". Je suis le chef du village " + village.getNom() + ".");
			}else {
				parler("Bonjour, je m'appelle " + nom + ". J'habite le village " + village.getNom() + ".");
			}	
		}else {
			parler("Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.");
		}
	}
	
	public void faireUneDonation(Musee musee) {
		if (nbTrophees > 0) {
			parler("Je donne au musee tous mes trophees :");
			for (int i=0; i< nbTrophees; i++) {
				System.out.println("- " + trophees[i]);
				musee.donnerTrophees(this, trophees[i]);
			}
			nbTrophees = 0;
		}
	}

	
}

