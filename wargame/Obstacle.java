package wargame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
/**
 * classe qui contient les obstacles 
 */
public class Obstacle extends Element implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * pour les obstacles : les types, la couleur
	 */
	public enum TypeObstacle {
		ROCHER(COULEUR_ROCHER), FORET(COULEUR_FORET), EAU(COULEUR_EAU);
		@SuppressWarnings("unused")
		private final Color COULEUR;
		/**
		 * couleur de l'obstacle
		 */
		TypeObstacle(Color couleur) {
			COULEUR = couleur;
		}
		/**
		 * @return un obstacle aléatoire
		 */
		public static TypeObstacle getObstacleAlea() {
			return values()[(int) (Math.random() * values().length)];
		}
	}

	private TypeObstacle TYPE;
	/**
	 * récupère le type de l'obstacle
	 */
	public TypeObstacle getTYPE() {
		return TYPE;
	}
	/**
	 * donne le nom du type
	 */
	Obstacle(TypeObstacle type, Position pos) {
		TYPE = type;
		this.pos = pos;
		switch (type) {
		case EAU:
			nom = "Eau";
			break;
		case FORET:
			nom = "Foret";
			break;
		case ROCHER:
			nom = "Montagne";
			break;
		default:
			break;
		}
	}
	/**
	 * @return le type
	 */
	public String toString() {
		return "" + TYPE;
	}
	/**
	 * affiche les images des obstacles
	 */
	public void affiche(Graphics g) {
		// déclaration des images
		BufferedImage montagne = null;
		BufferedImage eau = null;
		BufferedImage foret = null;
		// récupération des images
		try {
			eau = ImageIO.read(this.getClass().getResource("/eau.png"));
			foret = ImageIO.read(this.getClass().getResource("/foret.png"));
			montagne = ImageIO.read(this.getClass().getResource("/montagne.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		// position récupérée lors du click
		Position pos = new Position(this.pos.getX(), this.pos.getY()).convertPosPix();
		// affichage des images
		switch (this.TYPE) {
		case EAU:
			g.drawImage(eau, pos.getX(), pos.getY(),Config.nb_pix_case_y,Config.nb_pix_case_y, null);

			break;
		case FORET:
			g.drawImage(foret, pos.getX(), pos.getY(), Config.nb_pix_case_y,Config.nb_pix_case_y,null);

			break;
		case ROCHER:
			g.drawImage(montagne, pos.getX(), pos.getY(), Config.nb_pix_case_y,Config.nb_pix_case_y,null);

			break;
		default:
			break;

		}
	}

}