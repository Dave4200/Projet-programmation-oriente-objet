package wargame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanneauInter extends JPanel {
	/**
	 * PanneauInter classe gérant l'mage de fond de la fenetre de lancement de partie
	 */
	private static final long serialVersionUID = 1L;
	int h;/*hauteur de l'ecran*/
	int w;/*largeur de l'écran*/
	BufferedImage background = null;/*potentielle image*/
	
	public PanneauInter(int h, int w) {
		this.h=h;/*on assigne a notre panel la heuteur et la largeur de l'écran*/
		this.w=w;
		try {
			background= ImageIO.read(this.getClass().getResource("/jeu.jpg"));/*on tente de recuperer l'image*/

		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setBounds(0,0,w,h);/*si cela marche on parametre l'image dans le JPanel*/	
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background,0,0,w,h,null);	
	}
}
