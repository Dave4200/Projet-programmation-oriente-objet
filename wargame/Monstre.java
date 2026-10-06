package wargame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
/** 
 * cette classe contient toutes les données du monstre (pv, portée, puissance, tir),
 *  et son type choisi aléatoirement
 * elle affiche les images concernant les monstres
 * @author melanie
 */
public class Monstre extends Soldat implements Serializable{

	private static final long serialVersionUID = 1L;
	private static TypesM monstre;
	/**
	 * constructeur de Monstre qui permet d'associer les caractéristiques de Soldat
	 * a celle de Monstre
	 * @param pos : position du monstre
	 */
	public Monstre(Position pos) {
		monstre = TypesM.getTypeMAlea(); // type du monstre aléatoire
		pointsDeVie = monstre.getPoints(); // points de vie du monstre
		pvMax = monstre.getPoints(); // points de vie maximum du monstre
		portee = monstre.getPortee(); // portée du monstre
		puissance = monstre.getPuissance(); // puissance du monstre
		tir = monstre.getTir(); // tir du monstre
		this.pos = pos; // position
		
		switch(monstre) { // affichage du type lors du survol de la souris
		case GOBELIN:
			nom="Gobelin";
			break;
		case ORC:
			nom="Orc";
			break;
		case TROLL:
			nom="Troll";
			break;
		default:
			break;		
		}
		visible = false; // visible seulement si dans la portée des héros
	}

	/**
	 * affiche l'image d'un monstre pour chaque monstre dans la map
	 */
	public void affiche(Graphics g) {
		// déclaration des images
		BufferedImage monstre = null;
		BufferedImage plaine = null;
		// récupération des images
		try {
			monstre = ImageIO.read(this.getClass().getResource("/monstre.png"));
			plaine = ImageIO.read(this.getClass().getResource("/vert.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		// position récupérée du click
		Position pos = new Position(this.pos.getX(), this.pos.getY()).convertPosPix();
		// affichage des images
		g.drawImage(plaine, pos.getX(), pos.getY(), Config.nb_pix_case_y,Config.nb_pix_case_y,null);
		g.drawImage(monstre, pos.getX(), pos.getY(), Config.nb_pix_case_y,Config.nb_pix_case_y,null);
		setVisible(true); // rends visible les images
	}

	/**
	 * @return état de visibilité true / false
	 */
	public Boolean getVisible() {
		return visible;
	}

	/**
	 * rends visible ou non le monstre
	 */
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
}
