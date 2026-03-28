package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean estDansLevillage(String nomVillageoi) {
		return controlVerifierIdentite.verifierIdentite(nomVillageoi);
	}

	public boolean produitVenduAuMarche(String produit) {
		return village.rechercherVendeursProduit(produit).length != 0;
	}

	public Gaulois[] listeVendeurProduit(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	public int quantiteProduit(String nomVendeur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal.getQuantite();
	}
	
	public void acheterProduit(String nomVendeur,int quantite) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		etal.acheterProduit(quantite);
	}
}
