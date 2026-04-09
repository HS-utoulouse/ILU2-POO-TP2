package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef harba;

	@BeforeEach
	public void initilaliserSituation() {
		System.out.println("Inisialisation....");
		village = new Village("le village de RIO", 10, 5);
		harba = new Chef("Harba", 10, village);
		village.setChef(harba);
	}

	@Test
	public void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[0], harba.getNom());
	}

	@Test
	public void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(controlAfficherVillage.donnerNomVillage(), village.getNom());
	}

	@Test
	public void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(controlAfficherVillage.donnerNbEtals(), 0);

		village.installerVendeur(harba, null, 0);
		assertEquals(controlAfficherVillage.donnerNbEtals(), 1);

	}
}
