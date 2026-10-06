package wargame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

/**
 * Classe de bouton qui permet de sauvegarder une partie dans un fichier
 * spécifique
 * 
 * @author Goutelle Jeremy
 *
 */
public class BtSaveNum extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
 * Construit un BtSaveNum
 * @param jd la JDialog a fermer une la sauvegarde effectuer
 * @param c La carte a sauvegarder
 * @param num_save Le numero de la sauvegarde
 */
	public BtSaveNum(JDialog jd, Carte c, int num_save) {
		String s = "/save" + num_save + ".png";//image avec le bon numero
		File saveFile = new File("save" + num_save);
		if (!saveFile.exists()) {
			s = "/vide.png";//image si elle n'existe pas deja
		}
		setIcon(new ImageIcon(this.getClass().getResource(s)));//image
		setPreferredSize(new Dimension(120, 40));//taille
		setBorder(BorderFactory.createRaisedBevelBorder());//bordure
		addActionListener(new ActionListener() {//action

			@Override
			public void actionPerformed(ActionEvent e) {
				GestionSauvegarde.save(c, num_save);//sauvegarde
				jd.dispose();// retour en jeu
			}
		});
	}
}
