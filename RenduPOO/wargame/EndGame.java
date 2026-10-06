package wargame;


import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EndGame extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EndGame() {
		JFrame menu = new JFrame();

		JPanel b1 = new JPanel();
		JPanel b2 = new JPanel();
		BtQuit exit = new BtQuit();
		
		menu.setSize(600, 100);
		menu.setLocationRelativeTo(null);
		menu.setUndecorated(true);
		
		
		b2.setBounds(10, 10, 400, 100);
		b2.setBackground(Color.GRAY);
		
		b1.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
		b1.add(exit);
		
		b2.setLayout(new BoxLayout(b2, BoxLayout.PAGE_AXIS));
		b1.add(b1);
		
		menu.add(b2);
		menu.addMouseListener(new Curseur(b2));
		
		menu.setVisible(true);
	}

}
