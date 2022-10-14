package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		Gaulois obelix = new Gaulois("Obélix", 16);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain minus = new Romain("Minus", 6);

		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.perparerPotion();
		panoramix.booster(obelix);
		panoramix.booster(asterix);

		asterix.direBonjour();
		minus.voirGaulois();
		while (!minus.simuleCoup(asterix.getForce() / 3)) {
			// System.out.println(minus.simuleCoup(asterix.getForce()/3));
			asterix.frapper(minus);
		}
	}

}
