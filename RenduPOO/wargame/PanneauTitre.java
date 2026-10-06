package wargame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanneauTitre extends JPanel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1424794725293332562L;
	
	int h;
	int w;
	BufferedImage title = null;
	
	public PanneauTitre(int h, int w) {
		this.h=h;
		this.w=w;
		try {
			title= ImageIO.read(this.getClass().getResource("/titre.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setBounds((w/2)-400,(h/5),400*2,80*2);	
		addMouseListener(new Curseur(this));

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(title,0,0,400*2,80*2,null);	
	}
}
