package wargame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * @author Goutelle J�r�my
 * */
public class PanneauConfig extends JPanel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanneauConfig(JFrame f,JDialog jd) {
		setPreferredSize(new Dimension(500, 500));
		setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.red));
		setBackground(Color.pink);
		
		JLabel lHauteur = new JLabel("<html><h1>Taille de la carte (10-20)</html></h1>");
		add(lHauteur);
		JTextField hauteur = new JTextField(""+Config.hauteur_carte);
		hauteur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int hauteurInt = Integer.parseInt(hauteur.getText());
				System.out.println(hauteurInt);
				Config.setHauteur_carte(hauteurInt);
			}
		});
		add(hauteur);
		
		JLabel lLargeur = new JLabel("<html><h1>Largeur de la carte (20-40)</html></h1>");
		
		add(lLargeur);
		JTextField largeur = new JTextField(""+Config.largeur_carte);
		largeur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int largeurInt = Integer.parseInt(largeur.getText());
				System.out.println(largeurInt);
				Config.setLargeur_carte(largeurInt);
			}
		});
		add(largeur);
		
		JLabel lMonstre = new JLabel("<html><h1>Nombre de monstres (1-60)</html></h1>");
		add(lMonstre);
		JTextField monstre = new JTextField(""+Config.nb_monstres);
		monstre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int monstreInt =  Integer.parseInt(monstre.getText());
				System.out.println(monstreInt);
				Config.setNb_monstres(monstreInt);
			}
		});
		add(monstre);
		
		JLabel lHero = new JLabel("<html><h1>Nombre de heros (1-20)</html></h1>");
		add(lHero);
		JTextField hero = new JTextField(""+Config.nb_heros);
		hero.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int heroInt = Integer.parseInt(hero.getText());
				System.out.println(heroInt);
				Config.setNb_heros(heroInt);
			}
		});
		add(hero);
		
		JLabel lObstacle = new JLabel("<html><h1>Nombre d'obstacles (20-100)</html></h1>");
		add(lObstacle);
		JTextField obstacle = new JTextField(""+Config.nb_obstacles);
		obstacle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int obstacleInt =  Integer.parseInt(obstacle.getText());
				System.out.println(obstacleInt);
				Config.setNb_obstacles(obstacleInt);
			}
		});
		add(obstacle);
		
		BtConfigDefaut defaut = new BtConfigDefaut();
		add(defaut);
		BtCommencer commencer = new BtCommencer(f,jd); 
		add(commencer);
		BtRetour retour = new BtRetour(jd);
		add(retour);
		addMouseListener(new Curseur(this));

	}

}
