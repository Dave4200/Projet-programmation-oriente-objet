package wargame;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe fenetre pour choisir quel partie charger ou bien supprimer
 * 
 * @author Goutelle Jeremy
 *
 */
public class FenetreChargement extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construit FenetreChargement
	 * 
	 * @param f fenetre parente
	 */
	public FenetreChargement(JFrame f) {
		super(f, true);

		BtChargerNum charger1 = new BtChargerNum(f, 1);//bouton charger
		BtChargerNum charger2 = new BtChargerNum(f, 2);
		BtChargerNum charger3 = new BtChargerNum(f, 3);
		BtSupprimerSauvegarde supp1 = new BtSupprimerSauvegarde(1);//bouton pour supprimer
		BtSupprimerSauvegarde supp2 = new BtSupprimerSauvegarde(2);
		BtSupprimerSauvegarde supp3 = new BtSupprimerSauvegarde(3);
		BtRetour retour = new BtRetour(this);//bonton pour reveir sans charger une partie
		JPanel p = new JPanel();
		JLabel titre = new JLabel("<html><h1>Charger une partie</h1></html>");
		p.setSize(300, 250);
		p.setBackground(Color.gray);
		p.add(titre);
		p.add(charger1);
		p.add(supp1);
		p.add(charger2);
		p.add(supp2);
		p.add(charger3);
		p.add(supp3);
		p.add(retour);
		addMouseListener(new Curseur(p));
		add(p);
		setUndecorated(true);
		setSize(300, 250);
		setResizable(false);
		setLocationRelativeTo(f);
		setVisible(true);
	}

}
