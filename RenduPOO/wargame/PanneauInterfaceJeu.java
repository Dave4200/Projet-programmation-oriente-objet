package wargame;

import java.awt.Color;
import java.awt.Dimension;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
/**
 * Classe qui affiche la carte et sont interface
 * @author Goutelle Jeremy
 *
 */
public class PanneauInterfaceJeu extends JPanel implements Serializable {
	private static final long serialVersionUID = 1L;

	private PanneauJeu p = null;
	public PanneauJeu getP() {
		return p;
	}

	public PanneauInterfaceJeu(JFrame f, int num_save) {
		f.dispose(); // on ferme l'ancienne JFRAME
		f = new JFrame("Game");
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int h = (int) dimension.getHeight();
		int w = (int) dimension.getWidth();

		switch (num_save) {
		case 0:
			p = new PanneauJeu();
			break;
		default:
			p = new PanneauJeu(GestionSauvegarde.load(num_save));
			break;
		}

		JLayeredPane main = new JLayeredPane();
		JPanel btn = new JPanel();
		JPanel bg = new JPanel();
		JPanel btnFinTour = new JPanel();
		BtOptn option = new BtOptn(f, p);
		BtFinTour finTour = new BtFinTour(p);
		
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		p.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.orange));
		p.setSize(1610, 975);
		p.setLocation(Config.position_x, Config.position_y);
		p.setBackground(Color.black);

		bg.setBounds(0, 0, w, h);
		bg.setBackground(Color.GRAY);

		btn.setBounds(0, -5, 65, 60);
		btn.setOpaque(false);
		btn.add(option);
		btnFinTour.setBounds(w/2, 5, 120, 40);
		btnFinTour.setOpaque(false);
		btnFinTour.add(finTour);

		main.add(btn, new Integer(1));
		main.add(btnFinTour, new Integer(1));
		main.add(p, new Integer(2));
		main.add(bg, new Integer(0));
		
		f.addMouseListener(new Curseur(bg));
		f.addMouseListener(new Curseur(btn));
		f.addMouseListener(new Curseur(btnFinTour));

		f.getContentPane().add(main);
		f.setResizable(false);
		f.setUndecorated(true);
		f.setVisible(true);
	}

}
