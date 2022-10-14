package histoire;

import personnages.*;


public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain minus = new Romain("Minus", 6);
		asterix.direBonjour();
		minus.voirGaulois();
		while (!minus.simuleCoup(asterix.getForce()/3)) {
			//System.out.println(minus.simuleCoup(asterix.getForce()/3));
			asterix.frapper(minus);
		}
	}

}
