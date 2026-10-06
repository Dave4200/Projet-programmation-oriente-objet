package wargame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
/**
 * Classe de bouton qui permet de fermer une JDialog
 * @author Goutelle Jeremy
 *
 */
public class BtRetour extends JButton implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
 * Construi un BtRetour
 * @param jd La Jdialog a fermer
 */
public BtRetour(JDialog jd) {
	this.setIcon(new ImageIcon(this.getClass().getResource("/retour.png")));//image
	this.setPreferredSize(new Dimension(60, 40));//taille
	this.setBorder(BorderFactory.createRaisedBevelBorder());//bordure
	addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			jd.dispose(); // ferme la JDialog
		}
	});}
}
