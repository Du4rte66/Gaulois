package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return this.nom;
	}

	public int getForce() {
		return this.force;
	}

	public int getEffetPotion() {
		return this.effetPotion;
	}

	public void parler(String texte) {
		System.out.println(this.prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le gaulois " + this.nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(this.nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(this.effetPotion * this.force / 3);
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + this.nom + ", force=" + this.force + ", effetPotion=" + this.effetPotion + "]";
	}

	public void direBonjour() {
		this.parler("Bonjour à tous !");
	}

	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		this.parler("Merci Druide, je sens que ma force est " + this.effetPotion + " fois décuplée.");
	}

//	public static void main(String[] args) {
//		Gaulois asterix = new Gaulois("Astérix", 8);
//		asterix.boirePotion(3);
//	}

}