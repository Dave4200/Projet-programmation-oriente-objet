package wargame;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

/**
 * Classe qui gere l'affiche de la carte du jeu ainsi que les cliques sur la
 * carte qui permette de deplacer les hero ou de les faire attaque un Monstre
 * 
 * @author Goutelle Jeremy
 * 
 *
 */
public class PanneauJeu extends JPanel implements MouseListener, MouseMotionListener, IConfig, Serializable {
	private Cursor curseur; // permet d'avoir un curseur personaliser
	private Carte c;
	private Position p1;
	private boolean dejaClick = false;
	JWindow info = null; // sert a afficher des info sur les monstre et les hero
	private static final long serialVersionUID = 1L;

	/**
	 * Construit un PanneauJeu en creant une nouvelle carte et ajoute des listener
	 * pour les clic et le mouvementde la souris
	 */
	public PanneauJeu() {
		c = new Carte();
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	/**
	 * Construit un PanneauJeu en avec une carte en parametre et ajoute des listener
	 * pour les clic et le mouvementde la souris
	 * 
	 * @param c Carte du jeu qui a ete charger depuis un fichier de sauvegarde
	 */
	public PanneauJeu(Carte c) {
		this.c = c;
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public JWindow getInfo() {
		return info;
	}

	public Carte getC() {
		return c;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		c.toutDessiner(g);

		if ((this.c.getNbHeros() != 0) && (this.c.getNbMonstre() != 0)) {

			if (this.c.getCompHerosJouer() == this.c.getNbHeros()) {
				this.c.setCompHerosJouer(0);
				for (Element element : this.c.getCarte()) {
					if (element instanceof Heros) {
						((Heros) element).setJouer(false);
					}
				}
				this.c.jouerSoldats(this);
			}
		} else {
			@SuppressWarnings("unused")
			EndGame end = new EndGame();

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	/**
	 * Gestion du click sur la carte
	 */
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) { // click gauche
			Position pos = new Position(e.getX(), e.getY()).convertPixPos();
			Element elm = c.getElement(pos);
			// case vide
			if (elm != null) {

				// Heros sur la case
				if (elm instanceof Heros) {

					// selectionne le hero
					if (!dejaClick && !((Heros) elm).isJouer()) {
						p1 = pos;
						dejaClick = true;
						((Heros) elm).setSelect(true);
						repaint();
					}
					// Monstre sur la case
				} else if (elm instanceof Monstre) {
					if (dejaClick == true) {
						// essaye d'attaquer le monstre de la case
						// si le monstre etait a portee

						if (c.actionHeros(p1, pos, this)) {
							dejaClick = false;
							repaint();
						}
					}
				}
			} else if (dejaClick == true) {
				if (pos.getX() >= 0 && pos.getX() <= Config.largeur_carte - 1 && pos.getY() >= 0
						&& pos.getY() <= Config.hauteur_carte - 1) {
					if (c.getElement(p1).pos.estAPortee(pos, ((Heros) c.getElement(p1)).portee)) {
						if (c.actionHeros(p1, pos, this)) {
							dejaClick = false;
						}
						repaint();
					}
				}
			}
		} else if (SwingUtilities.isRightMouseButton(e)) {
			if (dejaClick == true) {
				dejaClick = false;
				Element elm = c.getElement(p1);
				if (elm instanceof Heros) {
					((Heros) elm).setSelect(false);
				}
				repaint();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		BufferedImage curseurImg = null;
		BufferedImage epeeImg = null;
		if (info != null) {
			info.dispose();
		}
		try {
			curseurImg = ImageIO.read(this.getClass().getResource("/curseur.png"));
			epeeImg = ImageIO.read(this.getClass().getResource("/epee.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Position pos = new Position(e.getX(), e.getY()).convertPixPos();
		Element elm = c.getElement(pos);

		if (elm != null) {
			if (elm instanceof Heros) {
				// survole une case ou il y a un heros
				curseur = java.awt.Toolkit.getDefaultToolkit().createCustomCursor(curseurImg, new Point(1, 1),
						"pointeur");
				setCursor(curseur);
				info = new Info(e, elm);
			} else if (elm instanceof Monstre) {
				// survole une case ou il y a un Monstre
				if (dejaClick) {
					Heros h = (Heros) c.getElement(p1);
					if (p1.estAPortee(pos, h.getPortee())) {
						curseur = java.awt.Toolkit.getDefaultToolkit().createCustomCursor(epeeImg, new Point(1, 1),
								"pointeur");
						setCursor(curseur);
					}
				}
				if (elm.isVisible()) {
					info = new Info(e, elm);
				}

			}
		} else {
			curseur = java.awt.Toolkit.getDefaultToolkit().createCustomCursor(curseurImg, new Point(1, 1), "pointeur");
			setCursor(curseur);
		}
	}

}
