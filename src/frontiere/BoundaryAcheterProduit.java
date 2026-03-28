package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {

		if (!controlAcheterProduit.estDansLevillage(nomAcheteur)) {
			System.out.println("Je suis désolée " + nomAcheteur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
		} else {
			String reponse = Clavier.entrerChaine("Quel produit voulez-vous acheter ?\n");

			if (!controlAcheterProduit.produitVenduAuMarche(reponse)) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			} else {
				Gaulois[] listeVendeurs = controlAcheterProduit.listeVendeurProduit(reponse);
				int numVendeur = 0;

				while (numVendeur < 1 || numVendeur > listeVendeurs.length) {
					System.out.println("Chez quel commerçant voulez-vous acheter des " + reponse + " ?");

					for (int i = 0; i < listeVendeurs.length; i++) {
						System.out.println((i + 1) + " - " + listeVendeurs[i].getNom());
					}

					numVendeur = Clavier.entrerEntier("");
				}

				String nomVendeur = listeVendeurs[numVendeur - 1].getNom();

				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur);
				System.out.println("Bonjour " + nomAcheteur);

				int nombreDeProduit = Clavier.entrerEntier("Combien de " + reponse + " voulez-vous acheter ?\n");
				int quantiteDispo = controlAcheterProduit.quantiteProduit(nomVendeur);

				if (quantiteDispo == 0) {
					System.out.println(nomAcheteur + " veut acheter " + nombreDeProduit + " " + reponse
							+ ", malheureusement il n'y en a plus !");
				} else if (quantiteDispo < nombreDeProduit) {
					System.out.println(nomAcheteur + " veut acheter " + nombreDeProduit + " " + reponse
							+ ", malheureusement " + nomVendeur + " n'en a plus que " + quantiteDispo + ".\n"
							+ nomAcheteur + " achète tout le stock de " + nomVendeur + ".");
					controlAcheterProduit.acheterProduit(nomVendeur, quantiteDispo);
				} else {
					System.out.println(
							nomAcheteur + " achète " + nombreDeProduit + " " + reponse + " à " + nomVendeur + ".");
					controlAcheterProduit.acheterProduit(nomVendeur, nombreDeProduit);
				}
			}
		}
	}
}