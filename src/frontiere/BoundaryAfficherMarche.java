package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();

		if (infosMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plsu tard!!");
		} else {
			StringBuilder buffer = new StringBuilder();
			buffer.append(nomAcheteur);
			buffer.append(",vous trouverez au marché:\n");
			for (int i = 0; i < infosMarche.length; i += 3) {
				buffer.append("-");
				buffer.append(infosMarche[i]);
				i++;
				buffer.append(" qui vend ");
				buffer.append(infosMarche[i]);
				i++;
				buffer.append(" ");
				buffer.append(infosMarche[i]);
				buffer.append("\n");
			}
			System.out.println(buffer.toString());
		}
	}
}
