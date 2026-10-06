package wargame;


import java.io.Serializable;

import javax.swing.SwingUtilities;
import wargame.Config;
/**
 * Classe contenant le main Permet de lancer l'application
 * @author Goutelle Jeremy
 *
 */
public class FenetreJeu extends Config implements IConfig , Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6876475270346699947L;

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				@SuppressWarnings("unused")
				Menu m = new Menu(); // affiche le menu du jeu

			}
		});

	}
}
