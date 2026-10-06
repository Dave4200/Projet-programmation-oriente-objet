package wargame;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe de fenetre pour choisir l'emplacement de la sauvegarde
 * 
 * @author Goutelle Jeremy
 *
 */
public class FenetreSauvegarde extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construit FenetreSauvegarde
	 * 
	 * @param f fentre parente
	 * @param c la carte a sauvegarder
	 */
	public FenetreSauvegarde(JFrame f, Carte c) {
		super(f, true);
		BtSaveNum save1 = new BtSaveNum(this, c, 1);//bouton pour sauvegarder
		BtSaveNum save2 = new BtSaveNum(this, c, 2);
		BtSaveNum save3 = new BtSaveNum(this, c, 3);
		BtRetour retour = new BtRetour(this);
		JLabel titre = new JLabel("<html><h1>Sauvegarder une partie</h1></html>");

		JPanel p = new JPanel();
		p.setSize(300, 200);
		p.setBackground(Color.gray);
		p.add(titre);
		p.add(save1);
		p.add(save2);
		p.add(save3);
		p.add(retour);
		addMouseListener(new Curseur(p));

		add(p);
		setSize(300, 200);
		setResizable(false);
		setLocationRelativeTo(f);
		setUndecorated(true);
		setVisible(true);
	}
}
