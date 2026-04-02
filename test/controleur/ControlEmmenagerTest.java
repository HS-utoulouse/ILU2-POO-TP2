package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef harba;

	@BeforeEach
	public void initilaliserSituation() {
		System.out.println("Inisialisation....");
		village = new Village("le village de RIO",10,5);
		harba = new Chef("Harba",10,village);
		village.setChef(harba);
	}

	@Test
	void testControleEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertNotNull(controlEmmenager, "Ton constructeur ne renvoi pas null!!!!");
	}
	
	@Test
	void testIsHabitant() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Tana Originel", 1000);
		assertTrue(controlEmmenager.isHabitant("Tana Originel"));
		assertFalse(controlEmmenager.isHabitant("Le roi de france"));
		controlEmmenager.ajouterDruide("La Frape du quartier", 1, 1,2);
		assertTrue(controlEmmenager.isHabitant("La Frape du quartier"));
	}
	
	@Test
	void testAjouterDruide() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("Tana Originel",1, 1,2);
		assertTrue(controlEmmenager.isHabitant("Tana Originel"));
	}

}
