package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		Boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);

		if (Boolean.FALSE.equals(vendeurReconnu)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		} else {
			String[] data = controlLibererEtal.libererEtal(nomVendeur);
			StringBuilder out = new StringBuilder();
			out.append("Vous avez vendu ");
			out.append(data[2]);
			out.append(" sur ");
			out.append(data[3]);
			out.append(" produit ");
			out.append(data[4]);
			out.append(". \nAu revoir ");
			out.append(nomVendeur);
			out.append(", passez une bonne journée.");
			System.out.println(out.toString());
		}
	}

}
