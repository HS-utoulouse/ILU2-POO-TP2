package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolée " + nomVendeur + " mais il faut que tu soit un habitant du village");
		} else {
			System.out.println("Bonjour " + nomVendeur + " je vais regarder si je  peux vous trouver une étal.");

			if (controlPrendreEtal.resteEtals()) {
				System.out.println("Désolé " + nomVendeur + " je n'ais plus d'étal de libre.");
			} else {
				this.installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) { // permet de factoriser et clarifier le code
		StringBuilder question = new StringBuilder();

		question.append("C'est parfait il y a une étal pour vous!\n");
		question.append("Il me faudrait quelques renseignements :\n");
		question.append("Quel produit souhaite tu vendre ?");

		String produit = Clavier.entrerChaine(question.toString());
		question.setLength(0);

		question.append("Combien souhaites vous en vendre ?");
		int nbproduit = Clavier.entrerEntier(question.toString());

		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbproduit);
		if (numEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + numEtal);
		}
	}
}
