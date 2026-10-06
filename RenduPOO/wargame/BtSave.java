package wargame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
	 * BtSave: classe gérant le bouton permettant la sauvegarde de la partie en cours .
	 */
public class BtSave extends JButton implements Serializable {
	
	private static final long serialVersionUID = 4726734608755542972L;

	public BtSave(JFrame f,PanneauJeu pj) {
		setIcon(new ImageIcon(this.getClass().getResource("/saveBouton.png")));
		setPreferredSize(new Dimension(120, 40));
		setBorder(BorderFactory.createRaisedBevelBorder());
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				FenetreSauvegarde fS = new FenetreSauvegarde(f, pj.getC()); /*lancement de la fenetre pour sauvegarder*/
			}
		});	 
	}

}
