
package wargame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import wargame.Obstacle.TypeObstacle;

/**
 * Classe de gestion de la carte
 * 
 * @author Goutelle Jeremy
 * 
 */
public class Carte implements ICarte, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Element> carte = new ArrayList<>();
	private int compHerosJouer = 0;
	private int compMonstreJouer = 0;
	private int nbHeros = Config.nb_heros;
	private int nbMonstre = Config.nb_monstres;

	/**
	 * Creer une carte aleatoirement
	 */
	public Carte() {
		// cree les Obstacles
		for (int i = 0; i < Config.nb_obstacles; i++) {
			Position pos = trouvePositionVide();
			carte.add(new Obstacle(TypeObstacle.getObstacleAlea(), pos));
		}
		// Cree les Monstres
		for (int i = 0; i < Config.nb_monstres; i++) {
			Position pos;
			do {
				pos = trouvePositionVide();

			} while (pos.getX() < Config.largeur_carte / 2);
			carte.add(new Monstre(pos));
		}

		// Cree les Heros
		for (int i = 0; i < Config.nb_heros; i++) {
			Position pos;
			do {
				pos = trouvePositionVide();

			} while (pos.getX() > Config.largeur_carte / 2);
			carte.add(new Heros(pos));
		}
	}

	/**
	 * Recupere un Element stocker dans carte parcour la carte en comparant les
	 * position des element avec celle en parametre
	 * 
	 * @param pos Position de l'element a recuperer
	 */
	@Override
	public Element getElement(Position pos) {
		int i = 0;
		while (i < carte.size() && !carte.get(i).pos.equals(pos)) {
			i++;
		}

		if (i < carte.size() && carte.get(i).pos.equals(pos)) {
			return carte.get(i);
		}
		return null;
	}

	/**
	 * Trouve une position vide dans la carte
	 * 
	 * @return {@link Position} Position de l' emplacement vide sur la carte
	 */
	@Override
	public Position trouvePositionVide() {
		Random r = new Random();
		Position newPos;
		do {
			newPos = new Position(r.nextInt(Config.largeur_carte), r.nextInt(Config.hauteur_carte));
		} while (this.getElement(newPos) != null);
		return newPos;
	}

	/**
	 * Trouve une Position vide a portee de la position pos
	 * 
	 * @param pos Definit la possition autour de laquel il faut chercher une case
	 *            vide
	 * @return renvoie une {@link Position}
	 */
	@Override
	public Position trouvePositionVide(Position pos) {
		ArrayList<Position> posVide = new ArrayList<>();
		for (int i = pos.getX() - 1; i < pos.getX() + 1 + 1; i++) {
			for (int j = pos.getY() - 1; j < pos.getY() + 1 + 1; j++) {

				Position p = new Position(i, j);
				Element elem = getElement(p);
				if (elem == null) {
					if (p.estAPortee(new Position(i, j), 1)) {
						posVide.add(p);
					}
				}
			}
		}
		Random r = new Random();
		if (posVide.size() == 0) {
			return null;
		}
		return posVide.get(r.nextInt(posVide.size()));
	}

	/**
	 * Trouve un {@link Heros} aleatoirement sur la carte
	 * 
	 * @return renvoie un {@link Heros}
	 */
	@Override
	public Heros trouveHeros() {
		Random r = new Random();
		int rand;
		do {
			rand = r.nextInt(carte.size());

		} while (carte.get(rand) instanceof Heros);
		Heros h = (Heros) carte.get(rand);
		return h;
	}

	/**
	 * Trouve un heros aléatoirement autour d'une position qui est a portee du
	 * Monstre situer en pos
	 * 
	 * @param pos {@link Position} Definit la ou se situe le monstre autour duquel
	 *            il faut chercher
	 */
	@Override
	public Heros trouveHeros(Position pos) {
		Monstre monstre = (Monstre) getElement(pos);
		int portee = monstre.portee;
		ArrayList<Heros> posHeros = new ArrayList<>();
		for (int i = pos.getX() - portee; i < pos.getX() + portee + 1; i++) {
			for (int j = pos.getY() - portee; j < pos.getY() + portee + 1; j++) {

				Position p = new Position(i, j);
				Element elem = getElement(p);
				if (elem instanceof Heros) {
					if (p.estAPortee(new Position(i, j), portee)) {
						posHeros.add((Heros) elem);
					}
				}
			}
		}
		Random r = new Random();
		if (posHeros.size() == 0) {
			return null;
		}
		return posHeros.get(r.nextInt(posHeros.size()));
	}

	/**
	 * D�place un {@link Soldat} sur la carte et met a jour l'affichage graphique
	 * 
	 * @param pos    Nouvelle position du soldat
	 * @param soldat Soldat a déplacer
	 * @param pj     Permet de mettre a jour l'interface graphique
	 */
	@Override
	public boolean deplaceSoldat(Position pos, Soldat soldat, PanneauJeu pj) {
		if (soldat.isVisible()) {
			Position depart = new Position(soldat.pos.getX(), soldat.pos.getY());
			Position arriver = new Position(pos.getX(), pos.getY());
			boolean supX = depart.getX() > arriver.getX();
			boolean supY = depart.getY() > arriver.getY();

			// trouve la prochaine position pour l'animation de deplacement
			while (!depart.equals(arriver)) {
				if (depart.getX() != arriver.getX()) {
					if (supX) {
						depart.setX(depart.getX() - 1);
						;
					} else {
						depart.setX(depart.getX() + 1);
						;
					}
				}
				if (depart.getY() != arriver.getY()) {
					if (supY) {
						depart.setY(depart.getY() - 1);
					} else {
						depart.setY(depart.getY() + 1);
					}
				}
				soldat.pos = new Position(depart.getX(), depart.getY());
				this.toutDessiner(pj.getGraphics());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		// Une fois l'animation finit ou si il n'y en a pas eu pour les Monstre non
		// visible il est deplacer a la bonne place
		soldat.pos = new Position(pos.getX(), pos.getY());
		return false;
	}

	/**
	 * Enleve un soldat de la carte
	 * 
	 * @param perso Soldat a enlever
	 */
	@Override
	public void mort(Soldat perso) {
		//
		if (perso.pointsDeVie < 1) {
			if (perso instanceof Heros) {
				this.setNbHeros(getNbHeros() - 1);
			} else if (perso instanceof Monstre) {
				this.setNbMonstre(getNbMonstre() - 1);
			}
			// enleve le solodat de la carte
			carte.remove(perso);
		}
	}

	/**
	 * permet de gerer les action du joueur
	 * 
	 * @param pos  position ou se situe le Heros
	 * @param pos2 position ou s975e situe l'action d&placement ou combat
	 * @param pj   permet de metre a jour l'inerface graphique
	 */
	@Override
	public boolean actionHeros(Position pos, Position pos2, PanneauJeu pj) {
		Element elem1 = getElement(pos);
		Element elem2 = getElement(pos2);
		if (elem1 == null) {
			return false;
		}
		if (elem1 instanceof Heros) { // verifie si c'est vraiment un Hero
			if (elem2 == null) {// Effectue un d�placement
				if (elem1.pos.estAPortee(pos2, ((Heros) elem1).getPortee())) {
					deplaceSoldat(pos2, (Soldat) elem1, pj);
					setCompHerosJouer(getCompHerosJouer() + 1);
					((Heros) elem1).setSelect(false);
					((Heros) elem1).setJouer(true);
					return true;
				}
			} else if (elem2 instanceof Monstre) {// Attaque le monstre
				if (elem1.pos.estAPortee(pos2, ((Heros) elem1).getPortee())) {
					((Heros) elem1).combat((Soldat) elem2, pj);
					setCompHerosJouer(getCompHerosJouer() + 1);
					((Heros) elem1).setSelect(false);
					((Heros) elem1).setJouer(true);
					return true;
				}
			} else if (elem2 instanceof Obstacle) {
				return false;
			}
		}
		return false;
	}

	/**
	 * permet de faire jouer les monstre
	 * 
	 * @param pj permet de mettre a jour l'interface graphique
	 * 
	 */
	@Override
	public void jouerSoldats(PanneauJeu pj) {
		pj.repaint();

		pj.repaint();

		for (Element element : pj.getC().carte) {
			if (compMonstreJouer == nbMonstre) {
				compMonstreJouer = 0;
				break;
			} else if (element instanceof Monstre) {
				Heros h = trouveHeros(element.pos);// Cherche un hero a attaquer
				if (h != null) {
					((Monstre) element).combat(h, pj);
				} else {// Il se deplace si il na pas pu attaquer
					Position p = trouvePositionVide(element.pos);
					if (p != null) {
						deplaceSoldat(p, (Soldat) element, pj);
						compMonstreJouer++;
					} else {

					}
				}
				pj.repaint();
			}
		}
	}

	/**
	 * Affiche la carte dans l'interface graphique
	 * 
	 * @param g permet l'affichage des image des element du jeu
	 */
	@Override
	public void toutDessiner(Graphics g) {
		BufferedImage plaine = null;
		BufferedImage porteeImg = null;
		try {
			plaine = ImageIO.read(this.getClass().getResource("/vert.png"));
			porteeImg = ImageIO.read(this.getClass().getResource("/portee.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		/* Affiche les Obstacle et Monstre visible et Tous les Heros */
		for (Element element : carte) {
			if (element instanceof Heros) {
				int portee = ((Heros) element).getPortee();
				int x = element.pos.getX();
				int y = element.pos.getY();
				for (int i = x - portee; i < x + portee + 1; i++) {
					for (int j = y - portee; j < y + portee + 1; j++) {
						Position pos = new Position(i, j);
						if (((Heros) element).pos.estAPortee(pos, portee)) {
							Element elem = getElement(pos);
							if (elem == null) {
								pos = pos.convertPosPix();
								g.drawImage(plaine, pos.getX(), pos.getY(), Config.nb_pix_case_y, Config.nb_pix_case_y,
										null);
							} else {
								elem.affiche(g);
							}
						} else {
							Element elem2 = getElement(pos);
							if (elem2 != null) {
								elem2.setVisible(false);
							}
						}
					}
				}
				element.affiche(g);
			}
		}

		/* Affiche la portee du heros selectinner */
		for (

		Element element2 : carte) {
			if (element2 instanceof Heros) {
				if (((Heros) element2).isSelect()) {
					int portee = ((Heros) element2).portee;
					int x = ((Heros) element2).pos.getX();
					int y = ((Heros) element2).pos.getY();
					for (int i = x - portee; i < x + portee + 1; i++) {
						for (int j = y - portee; j < y + portee + 1; j++) {
							Position pos = new Position(i, j).convertPosPix();
							if (((Heros) element2).pos.estAPortee(new Position(i, j), portee)) {
								g.drawImage(porteeImg, pos.getX(), pos.getY(), Config.nb_pix_case_y,
										Config.nb_pix_case_y, null);
							}
						}
					}
				}
			}
		}

	}

	/**
	 * Donne le nombre de hero present dans la carte
	 * 
	 * @return renvoie le nombre de hero present sur la carte
	 */
	public int getNbHeros() {
		return nbHeros;
	}

	/**
	 * Donne le nombre de Monstre present sur la carte
	 * 
	 * @return renvoie le nombre de Monstre
	 */
	public int getNbMonstre() {
		return nbMonstre;
	}

	/***
	 * Definit le nombre de hero present sur la carte
	 * 
	 * @param nbHeros nouveau nombre de hero present sur la carte
	 */
	public void setNbHeros(int nbHeros) {
		this.nbHeros = nbHeros;
	}

	/**
	 * Definit le nombre de monstre present sur la carte
	 * 
	 * @param nbMonstre nouveau nombre de monstre present sur la carte
	 */
	public void setNbMonstre(int nbMonstre) {
		this.nbMonstre = nbMonstre;
	}

	/**
	 * Donne le nombre de hero qui on jouer leur tour
	 * 
	 * @return renvoie le nombre de hero ayant jouer leur tour
	 */
	public int getCompHerosJouer() {
		return compHerosJouer;
	}

	/**
	 * Definit le nombre de hero ayant jouer leur tour
	 * 
	 * @param compHerosJouer nombre de hero qui ont jouer leur tour
	 */
	public void setCompHerosJouer(int compHerosJouer) {
		this.compHerosJouer = compHerosJouer;
	}

	/**
	 * Donne la carte du jeu contenant les Heros les Monstres et les obstacles
	 * 
	 * @return
	 */
	public ArrayList<Element> getCarte() {
		return carte;
	}
}
