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

	public void parler(String texte) {
		System.out.println(this.prendreParole() + "� " + texte + "�");
	}

	private String prendreParole() {
		return "Le gaulois " + this.nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(this.nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		romain.recevoirCoup(this.force / 3);
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + this.nom + ", force=" + this.force + ", effetPotion=" + this.effetPotion + "]";
	}

	public void direBonjour() {
		this.parler("Bonjour � tous !");
	}

//	public static void main(String[] args) {
//		Gaulois asterix = new Gaulois("Ast�rix", 8);
//		System.out.println(asterix);
//	}

}