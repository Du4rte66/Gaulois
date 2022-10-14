package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		this.parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin
				+ " � " + effetPotionMax + ".");
	}

	public String getNom() {
		return this.nom;
	}

	public void parler(String texte) {
		System.out.println(this.prendreParole() + "� " + texte + "�");
	}

	private String prendreParole() {
		return "Le druide " + this.nom + " : ";
	}

	public void perparerPotion() {
		Random rnd = new Random();
		this.forcePotion = this.effetPotionMin + rnd.nextInt(this.effetPotionMax - this.effetPotionMin);
		if (this.forcePotion > 7) {
			this.parler("j'ai pr�par� une super potion de force " + this.forcePotion + ' ');
		} else {
			this.parler("Je n'ai pas trouv� tous les ingr�dients, ma potion est seulement de force " + this.forcePotion
					+ ' ');
		}
	}

	public void booster(Gaulois gaulois) {
		if (gaulois.getNom().equals("Ob�lix")) {
			this.parler("Non, Ob�lix !... Tu n'auras pas de potion magique !");
			gaulois.parler("Par B�l�nos, ce n'est pas juste !");
		} else {
			gaulois.boirePotion(this.forcePotion);
		}
	}

//	public static void main(String[] args) {
//		Druide panoramix = new Druide("Panoramix", 5, 10);
//		panoramix.perparerPotion();
//	}

}