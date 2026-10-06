package wargame;

import java.awt.Graphics;
import java.io.Serializable;

/* 
 * classe Element qui contient les soldats (heros et monstres) et les obstacles
 * @author melanie
 * */
public abstract class Element implements IConfig, Serializable {
	private static final long serialVersionUID = 1L;
	protected Position pos; // position de l'element
	protected String nom; // nom de l'element
	protected boolean visible = false; // non visible par defaut (seulement s'il est dans la portee d'un heros )

	/**
	 * @return etat de visible true / false
	 */
	boolean isVisible() {
		return visible;
	}

	/**
	 * rends visible ou non l'element
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	abstract public void affiche(Graphics g);

}
