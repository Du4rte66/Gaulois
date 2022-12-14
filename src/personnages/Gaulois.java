package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];

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
		System.out.println(this.prendreParole() + "? " + texte + "?");
	}

	private String prendreParole() {
		return "Le gaulois " + this.nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(this.nom + " envoie un grand coup dans la m?choire de " + romain.getNom());
		Equipement[] trophees = romain.recevoirCoup((this.force / 3) * this.effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, this.nbTrophees++) {
			this.trophees[this.nbTrophees] = trophees[i];
		}
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + this.nom + ", force=" + this.force + ", effetPotion=" + this.effetPotion + "]";
	}

	public void direBonjour() {
		this.parler("Bonjour ? tous !");
	}

	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		this.parler("Merci Druide, je sens que ma force est " + this.effetPotion + " fois d?cupl?e.");
	}

//	public static void main(String[] args) {
//		Gaulois asterix = new Gaulois("Ast?rix", 8);
//		asterix.boirePotion(3);
//	}

}