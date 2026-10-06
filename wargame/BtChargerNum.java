package wargame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Classe bouton qui permet de charger un partie
 * 
 * @author Goutelle Jeremy
 *
 */
public class BtChargerNum extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construit un BtChargerNum
	 * 
	 * @param f        fenetre ou va etre charger la partie
	 * @param num_save numero du fichier de sauvegarde a charger
	 */
	public BtChargerNum(JFrame f, int num_save) {
		String s = "/save" + num_save + ".png"; // image du bouton avec le nom de la sauvegarde
		File saveFile = new File("save" + num_save); // est ce quel existe
		if (!saveFile.exists()) {
			s = "/vide.png"; // image du bouton ou il est ecrit vide car cette sauvegarde n'existe pas
		}
		setIcon(new ImageIcon(this.getClass().getResource(s))); // image du bouton
		setPreferredSize(new Dimension(120, 40)); // taille du bouton
		setBorder(BorderFactory.createRaisedBevelBorder()); // bord du bouton
		addActionListener(new ActionListener() { // acrtion du bouton si on click dessus

			@Override
			public void actionPerformed(ActionEvent e) {
				if (saveFile.exists()) {
					@SuppressWarnings("unused")
					Jeu j = new Jeu(f, num_save); // charge la partie
				}
			}
		});
	}

}
