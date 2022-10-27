package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageoisMaximum;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageoisMaximum = nbVillageoisMaximum;
		this.villageois = new Gaulois[this.nbVillageoisMaximum];
	}

	public String getNom() {
		return this.nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (this.nbVillageois < this.nbVillageoisMaximum) {
			this.villageois[this.nbVillageois] = gaulois;
			this.nbVillageois++;
		} else {
			System.out.println("Le village est déjà plein !");
		}
	}

	public Gaulois trouverHabitant(int numeroVillageois) {
		return this.villageois[numeroVillageois - 1];
	}

	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + this.chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0; i < this.nbVillageois; i++) {
			System.out.println("-" + this.villageois[i].getNom());
		}
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		// Gaulois gaulois = village.trouverHabitant(30);
		// On accède à une variable non initialisée
		Chef abraracourcix = new Chef("Abraracourcix", 6, 1, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
		// Gaulois gaulois = village.trouverHabitant(1);
		// System.out.println(gaulois);
		// le système copie la valeur de astérix dans village[1] puis dans gaulois
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();

	}
}