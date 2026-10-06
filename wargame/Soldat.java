package wargame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.Random;

public abstract class Soldat extends Element implements ISoldat, Serializable {
	/**
	 * classe qui contient monstres et héros et leurs caractéristiques
	 * @author melanie and Jeremy
	 */
	private static final long serialVersionUID = 1L;
	protected int pointsDeVie;
	protected int pvMax;
	protected int portee;
	protected int puissance;
	protected int tir;
	protected int tour;
	protected boolean select = false; // soldat pas sélactionné
	protected boolean jouer = false; // soldat qui a pas encore jouer

	/*
	 * si true, le soldat a jouer
	 * @return true
	 * */
	public boolean isJouer() {
		return jouer;
	}
	/*
	 * @return si le soldat a joué ou non
	 * */
	public void setJouer(boolean jouer) {
		this.jouer = jouer;
	}
	/*
	 * donne des points de vie à un soldat
	 * */
	public void setPointsDeVie(int pointsDeVie,Carte c) {
		if (pointsDeVie > 0) {
			if (pointsDeVie <= this.pvMax) {
				this.pointsDeVie = pointsDeVie;
			} else {
				this.pointsDeVie = this.pvMax; // points de vie maximum
			}
		} else {
			c.mort(this); // le soldat est mort
		}

	}

	@Override
	public int getPoints() {
		return pointsDeVie;
	}

	@Override
	public int getTour() {
		return tour;
	}

	@Override
	public int getPortee() {
		return portee;
	}

	@Override
	public void joueTour(int tour) {

	}

	/**
	 * Le soldat attaque le soldat en parametre puis celui ci riposte
	 * 
	 * @param soldatAttaque
	 *            le soldat a attaquer
	 * @param pj
	 *            Permet d'afficher les degats
	 */
	@Override
	public void combat(Soldat soldatAttaque, PanneauJeu pj) {
		Graphics2D g2 = (Graphics2D) pj.getGraphics();
		g2.setColor(Color.red);
		g2.setFont(new Font("test", Font.BOLD, 20));
		pj.getInfo().dispose();
		Random r = new Random();
		int degat = 0;
		// Le soldat attaque
		if (this.pos.estAPortee(soldatAttaque.pos, this.portee)) { // si ennemi dans la portée du soldat
			if (this.pos.estVoisine(soldatAttaque.pos)) {// corps à corps
				degat = 1 + r.nextInt(this.puissance - 1); // nombre de dégâts aléatoire

				g2.drawString("-" + degat, soldatAttaque.pos.getX() * Config.nb_pix_case_x + 15,
						soldatAttaque.pos.getY() * Config.nb_pix_case_y + 20);
				// affiche le nombre de dégats proche du soldat dans un panneau

			} else if (this.tir > 0) { // a distance
				degat = 1 + r.nextInt(this.tir - 1); // nombre de dégâts aléatoire

				g2.drawString("-" + degat, soldatAttaque.pos.getX() * Config.nb_pix_case_x + 15,
						soldatAttaque.pos.getY() * Config.nb_pix_case_y + 20);
				// affiche le nombre de dégats proche du soldat dans un panneau
			}

			soldatAttaque.setPointsDeVie(soldatAttaque.getPoints() - degat,pj.getC()); // MAJ des points de vie
			pj.repaint(); // reactualise le panneau
			try {
				Thread.sleep(500); // attente 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			g2.dispose();
			pj.repaint(); // reactualise la panneau
			g2 = (Graphics2D) pj.getGraphics();
			g2.setColor(Color.red);
			g2.setFont(new Font("test", Font.BOLD, 20));
		}
		
		degat = 0;
		// Le soldatAttaque riposte
		if (soldatAttaque.pos.estAPortee(this.pos, soldatAttaque.portee)) { // si ennemi dans la portée du soldat
			if (soldatAttaque.pos.estVoisine(this.pos)) { // corps a corps
				degat = 1 + r.nextInt(soldatAttaque.puissance - 1); // dégats aléatoires

				g2.drawString("-" + degat, this.pos.getX() * Config.nb_pix_case_x + 15,
						this.pos.getY() * Config.nb_pix_case_y + 20);
				// affiche le nombre de dégats proche du soldat dans un panneau

			} else if (soldatAttaque.tir > 0) {
				degat = 1 + r.nextInt(soldatAttaque.tir - 1); // dégats aléatoires

				g2.drawString("-" + degat, this.pos.getX() * Config.nb_pix_case_x + 15,
						this.pos.getY() * Config.nb_pix_case_y + 20);
				// affiche le nombre de dégats proche du soldat dans un panneau
			}
			
			this.setPointsDeVie(this.getPoints() - degat,pj.getC()); // MAJ des pv
			pj.repaint(); // reactualise
			try {
				Thread.sleep(500); // attente
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			g2.dispose();
			pj.repaint(); // reactualise
			pj.getC().toutDessiner(pj.getGraphics()); // reaffiche la carte

		}

	}

	@Override
	public void seDeplace(Position newPos) {
		this.pos = new Position(newPos.getX(), newPos.getY());

	}
	/*
	 * @return true si soldat sélectionné
	 * */
	public boolean isSelect() {
		return select;
	}
	/*
	 * attribue true ou false a select  
	 * */
	public void setSelect(boolean select) {
		this.select = select;
	}
}