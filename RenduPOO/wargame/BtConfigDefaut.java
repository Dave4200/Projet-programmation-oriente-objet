package wargame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Classe bouton qui met les parametre par defaut
 * 
 * @author Goutelle Jeremy
 *
 */
public class BtConfigDefaut extends JButton implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construit un BtConfigDefaut
	 */
	public BtConfigDefaut() {
		this.setIcon(new ImageIcon(this.getClass().getResource("/defaut.png"))); // image
		this.setPreferredSize(new Dimension(120, 40)); // taille
		this.setBorder(BorderFactory.createRaisedBevelBorder()); // bordure
		addActionListener(new ActionListener() {// action
			public void actionPerformed(ActionEvent e) {
				Config.defautConfig(); // configure le nombre de hero de monstre d'obstacle par defaut et aussi la
										// hauteur et la largeur de la carte
			}
		});
	}
}
