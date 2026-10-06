package wargame;

import java.awt.Color;
import java.awt.Dimension;
import java.io.Serializable;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Fenetre qui contient un {@link PanneauConfig}
 * 
 * @author Goutelle Jeremy
 *
 */
public class FenetreConfig extends JDialog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanneauConfig p = null;

	/**
	 * Construit FenetreConsfig
	 * 
	 * @param f fenetre parente
	 */
	public FenetreConfig(JFrame f) {
		super(f, true);
		p = new PanneauConfig(f, this); // le panneau permetant de configurer le jeu

		add(p);
		setSize(new Dimension(500, 400));
		setResizable(false);
		setLocationRelativeTo(f);
		setBackground(Color.yellow);
		setUndecorated(true);
		setVisible(true);
	}
}
