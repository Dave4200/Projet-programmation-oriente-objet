package wargame;
import java.awt.Color;
/**
 * interface pour avoir les parametres par defaut 
 * @author jerem
 *
 */
public interface IConfig {
	int LARGEUR_CARTE = 40; int HAUTEUR_CARTE = 20; // en nombre de cases
	int NB_PIX_CASE = 50; 
	int POSITION_X = 100; int POSITION_Y = 50; // Position de la fenetre
	int NB_HEROS = 6; int NB_MONSTRES = 15; int NB_OBSTACLES = 50;
	Color COULEUR_VIDE = Color.white, COULEUR_INCONNU = Color.lightGray;
	Color COULEUR_TEXTE = Color.black, COULEUR_MONSTRES = Color.black;
	Color COULEUR_HEROS = Color.red, COULEUR_HEROS_DEJA_JOUE = Color.pink;
	Color COULEUR_EAU = Color.blue, COULEUR_FORET = Color.green, COULEUR_ROCHER = Color.gray;
}