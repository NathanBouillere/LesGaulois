package personnages;


public class Druide {
	private String nom;
	private int force;
	private Chaudron chaudron;
	
	
	public Druide(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
		this.chaudron = new Chaudron();
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Druide " + nom + " : ";
	}
	
	public void booster(Gaulois gaulois) {
		if(chaudron.resterPotion()) {
			if(gaulois.getNom() == "Obélix") {
				parler("Non, " + gaulois.getNom() + " Non!... Et tu le sais très bien!");
			}else {
				chaudron.prendreLoucher();
				gaulois.boirePotion(chaudron.getForcePotion());
				parler("Tiens " + gaulois.getNom() + " un peu de potion magique");
			}
		}else {
			parler("Désolé " + gaulois.getNom() + " il n'y a plus une seule goutte de potion.");
		}
			
		
	}
	public void fabriquerPotion(int quantite, int forcePotion) {
		parler("J'ai concocté " + quantite + " doses de potion magique. Elle a une force de " + forcePotion + ".");
		chaudron.remplirChaudron(quantite, forcePotion);
		
		
	}
	
	
}
