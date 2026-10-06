package wargame;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**
 * Classe qui affiche les point de vie des hero et des monstre et leur attaque
 * 
 * @author Goutelle Jeremy
 *
 */
public class Info extends JWindow implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel pdv = null;
/**
 * affiche au survole de la souris
 * @param e position de la souris
 * @param elm source des information
 */
	public Info(MouseEvent e, Element elm) {
		if (elm instanceof Heros) {
			pdv = new JLabel("<html><h2>" + ((Heros) elm).nom + "</h2>" + ((Heros) elm).getPoints() + "/"
					+ ((Heros) elm).pvMax + " pdv <br>Atk : " + ((Heros) elm).puissance + "<br>atkD : "
					+ ((Heros) elm).tir + "</html>");
			pdv.setForeground(Color.blue);
		} else if (elm instanceof Monstre) {
			pdv = new JLabel("<html><h2>" + ((Monstre) elm).nom + "</h2> " + ((Monstre) elm).getPoints() + "/"
					+ ((Monstre) elm).pvMax + " pdv <br>Atk :" + ((Monstre) elm).puissance + "<br>atkD : "
					+ ((Monstre) elm).tir + "</html>");
			pdv.setForeground(Color.red);
		}
		JPanel p = new JPanel();
		p.setBackground(Color.yellow);
		p.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.orange));
		p.add(pdv);
		setSize(80, 100);
		setLocation(e.getX() + 105, e.getY() - 55);
		add(p);
		setVisible(true);
	}
}
