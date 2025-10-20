package personnages;

import personnages.Gaulois;

public class Village {
	private int nbVillageois = 0;
	private String nom;
	private Gaulois chef;
	private Gaulois[] villageois;
		


	public Village(String nom, Gaulois chef, int nbVillageoismax) {
		this.nom = nom;
		this.chef = chef;
		this.villageois = new Gaulois[nbVillageoismax];
	}

	public String getNom() {
		return nom;
		
	}
	
	public Gaulois getChef() {
		return chef;
		
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
		gaulois.setVillage(this);
	}
	

	public Gaulois trouverVillageois(int numVillageois) {
		int indice = numVillageois - 1;
		if(indice >=0 && indice < nbVillageois) {
			return villageois[indice];
		}else {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		}
		
	}

	public void afficherVillageois() {
		System.out.println("Dans le village " + nom + " du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i=0; i< nbVillageois; i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Gaulois abraracourcix;
		abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", abraracourcix, 30);
		abraracourcix.setVillage(village);
		Gaulois gaulois = village.trouverVillageois(30);
		
		Gaulois asterix;
		asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		
		gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		Gaulois obelix;
		obelix = new Gaulois("Obélix", 25);
		village.ajouterVillageois(obelix);
		
		village.afficherVillageois();
		
		Gaulois doublePolemix;
		doublePolemix = new Gaulois("Doublepolémix", 4);
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublePolemix.sePresenter();
		
		
		
		
	}
	
	
	
}
