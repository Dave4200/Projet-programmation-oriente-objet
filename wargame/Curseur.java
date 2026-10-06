package wargame;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 * Classe qui permet d'avoir un cuseur personaliser
 * @author Goutelle Jeremy
 *
 */
public class Curseur extends MouseAdapter {
	JPanel p=null;
	/**
	 * Construit Curseur
	 * @param panel JPanel ou le cuseur sera vue
	 */
	public Curseur(JPanel panel) {
		this.p = panel;
	}
	/**
	 * Personalise le cuseur quand on est dans le panel p
	 */
	public void mouseEntered(MouseEvent e) {
		super.mouseEntered(e);
		 Cursor curseur;
		BufferedImage curseurImg = null;
		try {
			curseurImg = ImageIO.read(this.getClass().getResource("/curseur.png"));//image du curseur
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		curseur = java.awt.Toolkit.getDefaultToolkit().createCustomCursor(curseurImg, new Point(1, 1),
				"pointeur");
		p.setCursor(curseur);
	}

}
