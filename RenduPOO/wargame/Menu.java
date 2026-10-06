package wargame;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Menu {
	public Menu(){
		/**
		 * Menu: Classe gerant le menu principal du jeu 
		 */
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();/*Itnitialisation de la fonction pour recuperer dimension de l'ecran*/
		
		JFrame f = new JFrame("War Game"); /*creation de la fenetre*/
		JLayeredPane main = new JLayeredPane();/*creation d'un layered panel afin de faciliter la gestion du layout de la fenetre*/
		
		int h = (int) dimension.getHeight();/*recuperation de la hauteur de l'ecran*/
		int w = (int) dimension.getWidth();/*recuperation de la largeur de l'ecran**/
		
		PanneauInter bg = new PanneauInter(h,w);/*creation du panel BACKGROUND*/
		PanneauTitre titre = new PanneauTitre(h,w);/*creation du panel pour le titre du jeu*/
		JPanel button = new JPanel();/*creation du panel pour les boutons*/
		
		/*creation des boutons Nouvelle partie, charger, et quitter*/
		BtQuit exit = new BtQuit();
		BtNew new_game = new BtNew(f);
		BtLoad load = new BtLoad(f);

		
		/*Parametrage de la fenetre*/
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setUndecorated(true);
		f.setSize(1600, 900);
		/**/
		
		/*on ajoute la panel background et titre*/
		main.add(bg,new Integer(0));/*comme bg est le panel servant d'image de fond on le met au niveau le plus bas*/
		main.add(titre, new Integer(1));/*on met le titre sur la couche d'au dessus*/
		/**/
		
		/*on ahjoute les boutons dans le panel bg*/
		button.add(new_game);
		button.add(load);
		button.add(exit);
		/*parametrage du panel bouton*/
		button.setBounds((w/2)-75,(h/2)-50,150,150);
		button.setOpaque(false);/*on active la transparence afin que les boutons s'incrustre parfaitement dans l'image de fonds*/
		
		main.add(button,new Integer(2));/*on ajoute le panel bt dans le panel principale au premier plan*/
		
		f.add(main);/*on ajoute le panel principal dans la fentre*/
		f.setContentPane(main);
		
		f.setResizable(false);
		f.setVisible(true);
	}
}
