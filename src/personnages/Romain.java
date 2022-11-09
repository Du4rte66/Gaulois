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
		return force;
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
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		//		parler("Aïe");
		// } else {
		// 		equipementEjecte = ejecterEquipement();
		// 		parler("J'abandonne...");
		// }
		if (force == 0) { 
			parler("Aïe");
		}
		else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
		}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) { 
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + this.nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
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
		switch(this.nbEquipement) {
		case 2:
			System.out.println(texte + " est déjà bien protégé !");
			break;
			
		case 1:
			if (equipements[0].toString().equals(equipement.toString())) {
				System.out.println(texte + " possède déjà un " + equipement + " !" );
				break;
			}
		
		default:
			equipements[nbEquipement++] = equipement;
			System.out.println(texte + " s'équipe avec un " + equipement.toString() + ".");
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