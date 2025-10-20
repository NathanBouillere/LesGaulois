package objets;

import java.security.PrivateKey;

public enum Equipement {
	CASQUE("casque"),
	BOUCLIER("bouclier");
	
	private String nom;
	
	private Equipement(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		return nom;
	}
}
