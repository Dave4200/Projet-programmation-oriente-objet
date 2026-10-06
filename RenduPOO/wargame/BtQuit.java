package wargame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BtQuit extends JButton {
	/**
	 * BtQuit: classe gérant le bouton permettant l'extinction du jeu .
	 */
	private static final long serialVersionUID = -5837767528299914084L;

	public BtQuit() {
		this.setIcon(new ImageIcon(this.getClass().getResource("/quit_game.png")));
		this.setPreferredSize(new Dimension(120, 40));
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

}
