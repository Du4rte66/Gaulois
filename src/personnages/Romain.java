package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	public int nbEquipement = 0;

	public Romain(String nom, int force) {
		assert force >= 0 : "La force d’un Romain est toujours positive";
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
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
	
	public void sEquiper(Equipement equipement) {
		switch(this.nbEquipement) {
		case 2:
			System.out.println("Le soldat " + this.nom + " est déjà bien protégé !");
			break;
			
		case 1:
			if (equipements[0].toString().equals(equipement.toString())) {
				System.out.println("Le soldat " + this.nom + " possède déjà un " + equipement + " !" );
				break;
			}
		
		default:
			equipements[nbEquipement++] = equipement;
			System.out.println("Le soldat " + this.nom + " s'équipe avec un " + equipement.toString() + ".");
			break;
		}
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 8);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}
}