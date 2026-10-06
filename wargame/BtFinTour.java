package wargame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Classe bouton qui permet de terminer le tour de jeu du joueur et de soigner
 * les heros qui non pas jouer
 * 
 * @author Goutelle Jeremy
 *
 */
public class BtFinTour extends JButton implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2018360745470729321L;

	/**
	 * Construit un BtfinTour
	 * 
	 * @param p PanneauJeu
	 */
	public BtFinTour(PanneauJeu p) {
		this.setIcon(new ImageIcon(this.getClass().getResource("/repos.png")));// image
		this.setPreferredSize(new Dimension(120, 40));// taille
		this.setBorder(BorderFactory.createRaisedBevelBorder());// bordure
		addActionListener(new ActionListener() {// action
			public void actionPerformed(ActionEvent e) {
                //pour afficher le +5 en vert
				Graphics2D g2 = (Graphics2D) p.getGraphics();
				g2.setColor(Color.green);
				g2.setFont(new Font("test", Font.BOLD, 20));

				p.getC().setCompHerosJouer(p.getC().getNbHeros());
				// pour tous les hero qui ont pas jour ont leur ajoute 5 point de vie et c'est
				// au tour de l'ia
				for (Element element : p.getC().getCarte()) {
					if (element instanceof Heros) {
						if (!((Heros) element).isJouer()) {
							((Heros) element).setPointsDeVie(((Heros) element).getPoints() + 5, p.getC());
							g2.drawString("+5", element.pos.getX() * Config.nb_pix_case_x + 15,
									element.pos.getY() * Config.nb_pix_case_y + 20);

							p.repaint();//actualise le panneau de jeu

						}
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				p.repaint();//actualise le panneau de jeu
			}

		});
	}

}
