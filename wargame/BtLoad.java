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
* BtLoad: Classe permettant la gestion du buton de chargement
*/

public class BtLoad extends JButton implements Serializable{

	private static final long serialVersionUID = -4313390067742631355L;


	
	public BtLoad(JFrame f) {
		this.setIcon(new ImageIcon(this.getClass().getResource("/charger.png"))); /*on met l'image du bouton charger*/
		this.setPreferredSize(new Dimension(120, 40));/*on initialise la taille*/
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		addActionListener(new ActionListener() {/*on declare l'action*/
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				FenetreChargement fC =new FenetreChargement(f);/*on crée un nouvelle fenetre pour selectionner la sauvegarde*/
			}
		});
	}
	
	
	

}
