package wargame;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Classe permetant d'effectuer un sauvegarde dans un fichier d'un objet carte
 * et de le charger
 * 
 * @author Goutelle Jeremy
 *
 */
public abstract class GestionSauvegarde {
	/**
	 * Sauvegarde la carte dans un fichier
	 * 
	 * @param c        carte a sauvegarder
	 * @param num_save numero du fichier de la sauvegarde
	 */
	public static void save(Carte c, int num_save) {
		String s = "save" + num_save;
		try {
			ObjectOutputStream oos = new ObjectOutputStream(

					new BufferedOutputStream(new FileOutputStream(new File(s))));
			oos.writeObject(c);
			oos.close();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

	/**
	 * Charge une carte
	 * 
	 * @param num_save numero de save a charger
	 * @return
	 */
	public static Carte load(int num_save) {
		Carte c = null;
		String s = "save" + num_save;
		try {
			ObjectInputStream oIS = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(s))));
			try {
				c = (Carte) oIS.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			oIS.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return c;

	}

}
