package wargame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Classe bouton qui permet de lancer la partie
 * 
 * @author Goutelle Jeremy
 *
 */
public class BtCommencer extends JButton implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7553465517901076395L;

	/**
	 * Construit un BtCommencer
	 * 
	 * @param f  fenetre ou le jeu va etre lancer
	 * @param jd fenetre de dialog qui sera fermer
	 */
	public BtCommencer(JFrame f, JDialog jd) {
		this.setIcon(new ImageIcon(this.getClass().getResource("/commencer.png"))); // image du bouton
		this.setPreferredSize(new Dimension(120, 40)); // taille du bouton
		this.setBorder(BorderFactory.createRaisedBevelBorder()); // bord du bouton
		addActionListener(new ActionListener() { // action du bouton
			public void actionPerformed(ActionEvent e) {
				jd.dispose(); // ferme la fenetre de dialog
				// configure le nombre de pixel pour afficher les image de la carte a la bonne
				// taille
				Config.setNb_pix_case_y(1000 / Config.hauteur_carte);
				Config.setNb_pix_case_x(1610 / Config.largeur_carte);
				@SuppressWarnings("unused")
				Jeu j = new Jeu(f, 0); // lance le jeu
			}
		});
	}

}
