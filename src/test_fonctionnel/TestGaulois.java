package test_fonctionnel;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class TestGaulois {

	public static void main(String[] args) {
		Gaulois asterix;
		Gaulois obelix;
		Romain brutus;
		Druide panoramix;
		asterix = new Gaulois("Astérix", 8);
		obelix = new Gaulois("Obélix", 16);
		brutus = new Romain("Brutus", 14);
		panoramix = new Druide("Panoramix", 2);
		
		panoramix.fabriquerPotion(4, 3);
		panoramix.booster(obelix);
		panoramix.booster(asterix);
		
		for (int i = 0; i < 3; i++) {
            asterix.frapper(brutus);
		}

}
}
