package controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private Village village;
	private ControlAfficherMarche controlAfficherMarche;

	@BeforeEach
	public void initilaliserSituation() {
		village = new Village("Village des fous", 10, 3);
		controlAfficherMarche = new ControlAfficherMarche(village);
	}

	@Test
	void testDonnerInfosMarcheAvecVendeurs() {
		Gaulois asterix = new Gaulois("Astérix", 5);
		Gaulois obelix = new Gaulois("Obélix", 15);

		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);

		village.installerVendeur(asterix, "Sanglier", 3);
		village.installerVendeur(obelix, "Menhir", 2);

		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();

		assertEquals("Astérix", infosMarche[0]);
		assertEquals("3", infosMarche[1]);
		assertEquals("Sanglier", infosMarche[2]);

		assertEquals("Obélix", infosMarche[3]);
		assertEquals("2", infosMarche[4]);
		assertEquals("Menhir", infosMarche[5]);
	}
}
