package wargame;

import javax.swing.JFrame;
/**
 *Classe qui lance le jeu
 * @author Goutelle Jeremy
 *
 */
public class Jeu  {
	
	PanneauInterfaceJeu pIJ;

	public Jeu(JFrame f, int num_save) {
		
		pIJ = new PanneauInterfaceJeu(f, num_save);

	}

}
