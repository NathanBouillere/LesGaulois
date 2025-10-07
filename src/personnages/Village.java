package personnages;

import personnages.Gaulois;

public class Village {
	private int nbVillageois = 0;
	private String nom;
	private Gaulois chef;
	private Gaulois[] villageois;
	private static final int NB_VILLAGEOIS_MAX = 30;
		


	public Village(String nom, Gaulois chef, int nbVillageoismax) {
		this.nom = nom;
		this.chef = chef;
		villageois = new Gaulois[nbVillageoismax];
	}

	public String getNom() {
		return nom;
		
	}
	
	public Gaulois getChef() {
		return chef;
		
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		
		villageois[numVillageois] = gaulois;
		nbVillageois++;
	}
	

	public Gaulois trouverVillageois(numVillageois) {
		if(villageois[numVillageois]!=null) {
			return numVillageois;
		}else {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		}
		
	}

	public void afficherVillage() {
		
	}
	
	public static void main(String[] args) {
		Gaulois abraracourcix;
		abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", abraracourcix, NB_VILLAGEOIS_MAX);
		Gaulois gaulois = village.trouverVillageois(30);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		
		
		
	}
	
	
	
}
