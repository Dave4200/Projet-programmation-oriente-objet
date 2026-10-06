package wargame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BtOptn extends JButton {
	/**
	 * BtOptn: classe permettant la création d'un bouton afin d'afficher une fenetre
	 * en jeu pour quitter la partie, la sauvegarder, charger une autre ou lancer
	 * une nouvelle partie
	 */
	private static final long serialVersionUID = -6779001209787259452L;

	public BtOptn(JFrame f, PanneauJeu p) {
		this.setIcon(new ImageIcon(
				this.getClass().getResource("/optn.png"))); /* On genere le bouton et on y raccorde une image */
		this.setPreferredSize(new Dimension(120, 40));/* la taille du bouton */
		this.setBorder(BorderFactory.createRaisedBevelBorder()); /*
																	 * on genere une bande blanche autour du boutoj afin
																	 * de le voir clairement par rapport au fond
																	 */
		addActionListener(new ActionListener() {/* on y raccorde une action */
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				MenuEchap menu = new MenuEchap(f, p); /* on lance le contructeur du menu echap */
			}
		});
	}

}
