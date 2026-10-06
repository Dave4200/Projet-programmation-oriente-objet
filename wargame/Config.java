package wargame;

import java.io.Serializable;

/**
 * Classe abstraite contenant des varible static permet de configurer le jeu
 * 
 * @author Goutelle Jeremy
 *
 */
public abstract class Config implements IConfig, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8587767569366128486L;
	public static int largeur_carte = LARGEUR_CARTE;
	public static int hauteur_carte = HAUTEUR_CARTE; // en nombre de cases
	public static int nb_pix_case_y = NB_PIX_CASE;
	public static int nb_pix_case_x = NB_PIX_CASE - 10;
	public static int position_x = POSITION_X;
	public static int position_y = POSITION_Y; // Position de la fenetre
	public static int nb_heros = NB_HEROS;
	public static int nb_monstres = NB_MONSTRES;
	public static int nb_obstacles = NB_OBSTACLES;

	/**
	 * Configuration par defaut
	 */
	public static void defautConfig() {
		Config.setLargeur_carte(LARGEUR_CARTE);
		Config.setHauteur_carte(HAUTEUR_CARTE);
		Config.setNb_pix_case_y(NB_PIX_CASE);
		Config.setNb_pix_case_x(NB_PIX_CASE - 10);
		Config.setPosition_x(POSITION_X);
		Config.setPosition_y(POSITION_Y);
		Config.setNb_heros(NB_HEROS);
		Config.setNb_monstres(NB_MONSTRES);
		Config.setNb_obstacles(NB_OBSTACLES);
	}

	/**
	 * Definit la largeur de la carte
	 * 
	 * @param largeur_carte nouvelle largeur de la carte
	 */
	public static void setLargeur_carte(int largeur_carte) {
		if (largeur_carte <= 20) {
			Config.largeur_carte = 20;
		} else if (largeur_carte <= 40) {
			Config.largeur_carte = largeur_carte;
		} else {
			Config.largeur_carte = 40;
		}
	}

	/**
	 * Definit la hauteur de la carte
	 * 
	 * @param hauteur_carte nouvelle hauteur de la carte
	 */
	public static void setHauteur_carte(int hauteur_carte) {
		if (hauteur_carte <= 10) {
			Config.hauteur_carte = 10;
		} else if (hauteur_carte <= 20) {
			Config.hauteur_carte = hauteur_carte;
		} else {
			Config.hauteur_carte = 40;
		}
	}

	/**
	 * Definit le nombre de pixel en hauteur pour une image
	 * 
	 * @param nb_pix_case_y taille en hauteur de l'image
	 */
	public static void setNb_pix_case_y(int nb_pix_case_y) {
		Config.nb_pix_case_y = nb_pix_case_y;
	}

	/**
	 * Definit le nombre de pixel en largeur d'une image
	 * 
	 * @param nb_pix_case_x taille en largeur de l'image
	 */
	public static void setNb_pix_case_x(int nb_pix_case_x) {
		Config.nb_pix_case_x = nb_pix_case_x;
	}

	/**
	 * Definit la positon du panneauJeu largeur
	 * 
	 * @param position_x coordonee x
	 */
	public static void setPosition_x(int position_x) {
		Config.position_x = position_x;
	}

	/**
	 * Definit la position du panneauJeu en hauteur
	 * 
	 * @param position_y coordonee y
	 */
	public static void setPosition_y(int position_y) {
		Config.position_y = position_y;
	}
/**
 * Defint le nombre de hero
 * @param nb_heros nouveu nombre de hero
 */
	public static void setNb_heros(int nb_heros) {
		if (nb_heros <= 1) {
			Config.nb_heros = 1;
		} else if (nb_heros <= 20) {
			Config.nb_heros = nb_heros;
		} else {
			Config.nb_heros = 20;
		}

	}
/**
 * Definit Le nombre de Monstre
 * @param nb_monstres nouveau nombre de monstre
 */
	public static void setNb_monstres(int nb_monstres) {
		if (nb_monstres <= 1) {
			Config.nb_monstres = 1;
		} else if (nb_monstres <= 60) {
			Config.nb_monstres = nb_monstres;
		} else {
			Config.nb_monstres = 60;
		}
	}
/**
 * Definit le nombre d'obstacle
 * @param nb_obstacles nouveau nombre d'obstacle
 */
	public static void setNb_obstacles(int nb_obstacles) {
		if (nb_obstacles <= 20) {
			Config.nb_obstacles = 20;
		} else if (nb_obstacles <= 100) {
			Config.nb_obstacles = nb_obstacles;
		} else {
			Config.nb_obstacles = 100;
		}
	}

}
