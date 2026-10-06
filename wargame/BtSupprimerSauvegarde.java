package wargame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * Classe bouton qui permet d'effacer une sauvegarde existante
 * @author Goutelle Jeremy
 *
 */
public class BtSupprimerSauvegarde extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
 * Construit un BtSupprimerSauvegarde
 * @param num_save Le numero de la sauvegarde a supprimer
 */
	public BtSupprimerSauvegarde(int num_save) {
		
		setIcon(new ImageIcon(this.getClass().getResource("/supprimer2.png")));//image
		setPreferredSize(new Dimension(60, 40));//taille
		setBorder(BorderFactory.createRaisedBevelBorder());//bordure
		addActionListener(new ActionListener() {//action

			@Override
			public void actionPerformed(ActionEvent e) {
				File saveFile = new File("save" + num_save);
				if (saveFile.exists()) {//supprime le fichier si il existe
					saveFile.delete();
				}

			}
		});
	}
}
