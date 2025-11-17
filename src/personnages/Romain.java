package personnages;

import objets.Equipement;

public class Romain {
	
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private boolean vainqueur;
	private String texte;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.vainqueur = true;
		assert isInvariantVerified();
	}
	
	private boolean isInvariantVerified() {
		return force >=0;
	}
	
	public boolean estVainqueur() {
        return vainqueur;
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
	
	public Equipement[] recevoirCoup(int forceCoup) {
        Equipement[] equipementEjecte = null;
        
        // Précondition
        assert force > 0 : "La force d'un Romain doit être positive";
        
        int oldForce = force;
        
        forceCoup = calculResistanceEquipement(forceCoup);
        
        force -= forceCoup;
        
        if (force > 0) {
            if (force == oldForce) {
                parler("Même pas mal !"); // "Faire parler le romain en conséquence"
            } else {
                parler("Aïe");
            }
            vainqueur = true; // Toujours en vie
        } else {
            equipementEjecte = ejecterEquipement();
            parler("J'abandonne...");
            vainqueur = false; // Vaincu
        }
        return equipementEjecte;
    }
	
	
	
	private int calculResistanceEquipement(int forceCoup) {
	    texte = "Ma force est  de " + this.force + ", et la force du coup est de " + forceCoup;
	    int resistanceEquipement = 0;
	    if (nbEquipement != 0) {
	        texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
	        for (int i = 0; i < nbEquipement;i++) {
	            if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
	                resistanceEquipement += 8;
	            } else {
	                System.out.println("Equipement casque");
	                resistanceEquipement += 5;
	            }
	        }
	        texte += resistanceEquipement + "!";
	    }
	    parler(texte);
	    if (forceCoup >= resistanceEquipement) {
	    	forceCoup -= resistanceEquipement;
	    	return forceCoup;
	    }else {
		    resistanceEquipement -= forceCoup;
		    return resistanceEquipement;
	    }
	}
	
	
	public int getForce() {
		return force;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
	    System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
	        
	    int nbEquipementEjecte = 0;
	    for (int i = 0; i < nbEquipement; i++) {
	    	if (equipements[i] != null) {
	    		equipementEjecte[nbEquipementEjecte] = equipements[i];
	            nbEquipementEjecte++;
	            equipements[i] = null;
	        }
	    }
	    nbEquipement = 0;
	    return equipementEjecte;
	}

	//public void recevoirCoup(int forceCoup) {
	//	assert forceCoup > 0;
	//	int force_initiale = force;
	//	force -= forceCoup;
	//	if(force>0) {
	//		parler("Aîe !");
	//	}else {
	//		parler("J'abandonne...");
	//	}
	//	assert force<= force_initiale;
	//	assert isInvariantVerified();	}

	@Override
	public String toString() {
		return nom;
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
        default:
            ajouterEquipement(equipement);
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
