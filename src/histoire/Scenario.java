package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		Gaulois obelix = new Gaulois("Ob�lix", 16);
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		Romain minus = new Romain("Minus", 6);

		panoramix.parler("Je vais aller pr�parer une petite potion...");
		panoramix.perparerPotion();
		panoramix.booster(obelix);
		panoramix.booster(asterix);

		asterix.direBonjour();
		minus.voirGaulois();
//		System.out.println(asterix.getForce());
//		System.out.println(asterix.getEffetPotion());
//		System.out.println(minus.simuleCoup(asterix.getEffetPotion() * asterix.getForce() / 3));
		asterix.frapper(minus);
		while (!minus.simuleCoup(asterix.getEffetPotion() * asterix.getForce() / 3)) {
			asterix.frapper(minus);
		}
	}

}
