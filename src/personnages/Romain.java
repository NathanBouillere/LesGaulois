package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
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
	
	public static void main(String[] args) {
        Romain minus ;
        minus = new Romain("Minus", 6);
	}
	
	
}
