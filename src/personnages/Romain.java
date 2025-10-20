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
	}
	
	private boolean isInvariantVerified() {
		return force >=0;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

		

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0;
		int force_initiale = force;
		force -= forceCoup;
		if(force>0) {
			parler("Aîe !");
		}else {
			parler("J'abandonne...");
		}
		assert force<= force_initiale;
		assert isInvariantVerified();	}

	@Override
	public String toString() {
		return nom;
	}
	private void ajouterEquipement(Equipement equipement) {
		this.equipements[nbEquipement] = equipement;
		this.nbEquipement++;
		System.err.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			ajouterEquipement(equipement);
			break;
		case 1:
			if (equipements[0]==equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
			}else {
				ajouterEquipement(equipement);
			}
			break;
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		}
	}
	
	
	
	public static void main(String[] args) {
        Romain minus ;
        minus = new Romain("Minus", 6);
        
        System.out.println("--- Test Equipement ---");
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.CASQUE);
       
	}
	
	
}
