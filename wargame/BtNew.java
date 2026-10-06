package wargame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BtNew extends JButton {
	/**
	 * BtNew : classe pour la gestion du bouton pour lancer une nouvelle partie
	 */
	private static final long serialVersionUID = -6779001209787259452L;

	public BtNew(JFrame f) {
		this.setIcon(new ImageIcon(this.getClass().getResource("/new_game.png"))); /*On genere le bouton et on y raccorde une image*/
		this.setPreferredSize(new Dimension(120, 40));/*la taille du bouton*/
		this.setBorder(BorderFactory.createRaisedBevelBorder());/*on genere une bande blanche autour du boutoj afin de le voir clairement par rapport au fond*/
		addActionListener(new ActionListener() {/*on y raccorde une action*/
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				FenetreConfig fc = new FenetreConfig(f);/*On lance une nouvelle partie*/
			}
		});
	}

}
