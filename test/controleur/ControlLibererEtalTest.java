package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Village village;
	private Gaulois vivien;
	Chef harba = new Chef("Harba", 10, village);

	@BeforeEach
	public void initilaliserSituation() {
		village = new Village("Toulouse métropole", 2, 10);
		village.setChef(harba);

		vivien = new Gaulois("vivien", 10);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
	}

	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertFalse(controlLibererEtal.isVendeur(vivien.getNom()));
		village.ajouterHabitant(vivien);
		village.installerVendeur(vivien, "GLOCk", 12);
		assertTrue(controlLibererEtal.isVendeur(vivien.getNom()));
	}

	@Test
	void testLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		village.ajouterHabitant(vivien);
		village.installerVendeur(vivien, "GLOCk", 12);

		assertTrue(controlLibererEtal.isVendeur(vivien.getNom()));

		String[] donneesVente = controlLibererEtal.libererEtal(vivien.getNom());

		assertNotNull(donneesVente);
		assertFalse(controlLibererEtal.isVendeur(vivien.getNom()));
	}

}
