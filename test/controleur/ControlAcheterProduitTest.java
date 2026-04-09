package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	private Gaulois vivien;

	@BeforeEach
	public void initilaliserSituation() {
		System.out.println("Inisialisation....");
		village = new Village("le village de RIO", 10, 5);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		vivien = new Gaulois("vivien", 10);
		//village.ajouterHabitant(vivien);
		Chef harba = new Chef("Harba", 10, village);
		village.setChef(harba);
	}

	@Test
	void testEstDansLevillage() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,
				controlTrouverEtalVendeur, village);
		assertFalse(controlAcheterProduit.estDansLevillage(vivien.getNom()));
		village.ajouterHabitant(vivien);
		assertTrue(controlAcheterProduit.estDansLevillage(vivien.getNom()));
	}

	@Test
	void testProduitVenduAuMarche() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,
				controlTrouverEtalVendeur, village);
		village.installerVendeur(vivien, "RPG", 1);
		assertTrue(controlAcheterProduit.produitVenduAuMarche("RPG"));
	}

	@Test
	void testListeVendeurProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,
				controlTrouverEtalVendeur, village);
		village.ajouterHabitant(vivien);
		village.installerVendeur(vivien, "RPG", 1);
		Gaulois[] villageois = new Gaulois[1];
		villageois[0] = vivien;
		assertArrayEquals(controlAcheterProduit.listeVendeurProduit("RPG"), villageois);
	}

	@Test
	void testQuantiteProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,
				controlTrouverEtalVendeur, village);
		village.ajouterHabitant(vivien);
		village.installerVendeur(vivien, "RPG", 1);
		assertEquals(controlAcheterProduit.quantiteProduit(vivien.getNom()), 1);
	}

	@Test
	void testAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,
				controlTrouverEtalVendeur, village);
		village.ajouterHabitant(vivien);
		village.installerVendeur(vivien, "RPG", 1);
		controlAcheterProduit.acheterProduit(vivien.getNom(), 1);
		assertEquals(controlAcheterProduit.quantiteProduit(vivien.getNom()), 0);
	}

}
