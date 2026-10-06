package wargame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
/** 
 * cette classe contient toutes les donnees du heros (pv, portee, puissance, tir),
 *  et son type choisi aléatoirement
 * elle affiche les images concernant les heros (un heros, un symbole pour dire qu'un heros a jouer
 * et qu'on en a sélectionne un.
 * @author melanie
 */
public class Heros extends Soldat implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private TypesH heros;

	/**
	 * constructeur de Heros qui permet d'associer les caracteristiques de Soldat
	 * a celle de Heros
	 * @param pos : position du heros
	 */
	public Heros(Position pos) {
		visible=true; // visibilité du heros dans la carte
		heros = TypesH.getTypeHAlea(); // heros choisi aleatoirement
		pointsDeVie = heros.getPoints(); // nombre de points de vie du heros
		pvMax = heros.getPoints(); // nombre de points de vie maximum
		portee = heros.getPortee(); // portee du heros
		puissance = heros.getPuissance(); // puissance du heros
		tir = heros.getTir(); // tir du heros
		this.pos = pos; // position
		switch (heros) { // nom du type du heros
		case ELF:
			nom = "Elf";
			break;
		case HOBBIT:
			nom = "Hobbit";
			break;
		case HUMAIN:
			nom = "Humain";
			break;
		case NAIN:
			nom = "Nain";
			break;
		default:
			break;
		}
		visible = true;
	}

	/*
	 * fonction qui affiche les images concernant le heros et ses actions possibles
	 * */
	public void affiche(Graphics g) {
		// declaration des images
		BufferedImage hero = null;
		BufferedImage plaine = null;
		BufferedImage selectHero = null;
		BufferedImage heroJouer = null;
		
		// recuperation des images
		try {
			hero = ImageIO.read(this.getClass().getResource("/hero.png"));
			plaine = ImageIO.read(this.getClass().getResource("/vert.png"));
			selectHero = ImageIO.read(this.getClass().getResource("/selecHeros.png"));
			heroJouer = ImageIO.read(this.getClass().getResource("/herosJouer.png"));


		} catch (IOException e) {
			e.printStackTrace();
		}
		// pos est la position recuperee par le click pour y afficher les images
		Position pos = new Position(this.pos.getX(), this.pos.getY()).convertPosPix();
		// affichage des images
		g.drawImage(plaine, pos.getX(), pos.getY(),Config.nb_pix_case_y,Config.nb_pix_case_y, null);
		g.drawImage(hero, pos.getX(), pos.getY(),Config.nb_pix_case_y,Config.nb_pix_case_y, null);
		if(this.select == true) { // si le heros est selectionne
			g.drawImage(selectHero, pos.getX(), pos.getY(),Config.nb_pix_case_y,Config.nb_pix_case_y, null);
		}
		if(this.jouer == true) { // si le heros a deja� jouer
			g.drawImage(heroJouer, pos.getX(), pos.getY(),Config.nb_pix_case_y,Config.nb_pix_case_y, null);

		}
		setVisible(true); // rends visible les images
	}

}