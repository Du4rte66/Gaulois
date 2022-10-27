package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		assert force >= 0 : "La force d’un Romain est toujours positive";
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return this.nom;
	}

	public void parler(String texte) {
		System.out.println(this.prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + this.nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert this.force >= 0 : "La force d’un Romain est toujours positive";
		int forceDepart = this.force;
		this.force -= forceCoup;
		if (this.force > 0) {
			this.parler("Aïe");
		} else {
			this.parler("J'abandonne...");
		}
		assert this.force < forceDepart : "La force d’un Romain a diminué";
	}

	public Boolean simuleCoup(int forceCoup) {
		return this.force < forceCoup;
	}

	public void voirGaulois() {
		this.parler("UN GAU... UN GAUGAU...");

	}

	public static void main(String[] args) {
		Equipement test = Equipement.CASQUE;
		System.out.println(test);

	}

}