package wargame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class RetourMenu extends JButton implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3308057067796240027L;

	public RetourMenu(JFrame f, JDialog m) {
		setIcon(new ImageIcon(this.getClass().getResource("/menu_game.png")));
		setPreferredSize(new Dimension(120, 40));
		setBorder(BorderFactory.createRaisedBevelBorder());
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				m.dispose();
				f.dispose();
				@SuppressWarnings("unused")
				Menu m = new Menu();
				
			}
		});
	}

}
