package wargame;

import java.awt.Color;

import java.io.Serializable;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuEchap extends JDialog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4429153733838300774L;

	public MenuEchap(JFrame f, PanneauJeu p) {
		JDialog menu = new JDialog(f, true);

		JPanel b1 = new JPanel();
		JPanel b2 = new JPanel();
		JPanel b3 = new JPanel();

		menu.setSize(600, 100);
		menu.setLocationRelativeTo(null);
		menu.setUndecorated(true);

		RetourMenu retour = new RetourMenu(f, menu);
		BtLoad load = new BtLoad(f);
		BtSave save = new BtSave(f, p);
		BtRetour retourEnjeu = new BtRetour(menu);
		BtQuit exit = new BtQuit();

		b3.setBounds(10, 10, 400, 100);
		b3.setBackground(Color.GRAY);

		b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
		b1.add(retour);
		b1.add(save);
		b1.add(load);
		b1.add(retourEnjeu);

		b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
		b2.add(exit);

		b3.setLayout(new BoxLayout(b3, BoxLayout.PAGE_AXIS));
		b3.add(b1);
		b3.add(b2);
		b3.setSize(400, 100);
		menu.add(b3);
		menu.addMouseListener(new Curseur(b1));
		menu.addMouseListener(new Curseur(b2));
		menu.addMouseListener(new Curseur(b3));
		menu.setVisible(true);
	}

}
