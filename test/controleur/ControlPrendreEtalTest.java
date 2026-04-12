package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {

	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;
	private Gaulois vivien;
	Chef harba = new Chef("Harba", 10, village);

	@BeforeEach
	public void initilaliserSituation() {
		village = new Village("Toulouse métropole", 2, 1);
		village.setChef(harba);

		vivien = new Gaulois("vivien", 10);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);

		assertTrue(controlPrendreEtal.resteEtals());

		village.ajouterHabitant(vivien);
		village.installerVendeur(vivien, "RPG-7", 100);

		assertFalse(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);

		assertEquals(controlPrendreEtal.prendreEtal(harba.getNom(), "RPG-7", 100), 0);
	}

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);

		assertFalse(controlPrendreEtal.verifierIdentite(vivien.getNom()));
		assertTrue(controlPrendreEtal.verifierIdentite(harba.getNom()));
	}

}
