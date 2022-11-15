package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		assert force >= 0 : "La force d’un Romain est toujours positive";
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
	}

	public int getForce() {
		return this.force;
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

//	public void recevoirCoup(int forceCoup) {
//		assert this.force >= 0 : "La force d’un Romain est toujours positive";
//		int forceDepart = this.force;
//		this.force -= forceCoup;
//		if (this.force > 0) {
//			this.parler("Aïe");
//		} else {
//			this.parler("J'abandonne...");
//		}
//		assert this.force < forceDepart : "La force d’un Romain a diminué";
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert this.force > 0;
		int oldForce = this.force;
		forceCoup = this.calculResistanceEquipement(forceCoup);
		this.force -= forceCoup;
		if (this.force > 0) {
			this.parler("Aïe");
		} else {
			equipementEjecte = this.ejecterEquipement();
			this.parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert this.force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (this.nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < this.nbEquipement; i++) {
				if ((this.equipements[i] != null && this.equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}

		this.parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup < 1) {
			return 1;
		}
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[this.nbEquipement];
		System.out.println("L'équipement de " + this.nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < this.nbEquipement; i++) {
			if (this.equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = this.equipements[i];
				nbEquipementEjecte++;
				this.equipements[i] = null;
			}
		}
		this.nbEquipement = 0;
		return equipementEjecte;
	}

	public Boolean simuleCoup(int forceCoup) {
		return this.force < forceCoup;
	}

	public void voirGaulois() {
		this.parler("UN GAU... UN GAUGAU...");

	}

	public void sEquiper(Equipement equipement) {
		String texte = "Le soldat " + this.nom;
		switch (this.nbEquipement) {
		case 2:
			System.out.println(texte + " est déjà bien protégé !");
			break;

		case 1:
			if (this.equipements[0].toString().equals(equipement.toString())) {
				System.out.println(texte + " possède déjà un " + equipement + " !");
				break;
			}

		default:
			this.equipements[this.nbEquipement++] = equipement;
			System.out.println(texte + " s'équipe avec un " + equipement.toString() + ".");
			break;
		}
	}

//	public static void main(String[] args) {
//		Romain minus = new Romain("Minus", 8);
//		minus.sEquiper(Equipement.CASQUE);
//		minus.sEquiper(Equipement.CASQUE);
//		minus.sEquiper(Equipement.BOUCLIER);
//		minus.sEquiper(Equipement.BOUCLIER);
//	}
}