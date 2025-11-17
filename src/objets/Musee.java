package objets;

import personnages.Gaulois;

public class Musee {
	private Trophees[] trophees = new Trophees[200];
	private int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		if (nbTrophee < trophees.length) {
            trophees[nbTrophee] = new Trophees(gaulois, equipement);
            nbTrophee++;
        }
	}
	
	public String extraireInstructionsOCaml() {
		String ocaml = "let musee = [\n";
		for (int i = 0; i < nbTrophee; i++) {
			ocaml += "\"" + trophees[i].donnerNom() + "\", \"" + trophees[i].getEquipement() + "\"";
			if (i < nbTrophee - 1) {
                ocaml += ";\n";
            } else {
                ocaml += "\n";
            }
		}
		ocaml += "]";
        return ocaml;
	}
}
