package wargame;

import java.io.Serializable;
/**
 * Classe qui permet la gestion des position et converti en pixel ou en cases
 * @author jerem
 *
 */
public class Position  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x, y;

	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean estValide() {
		if (x < 0 || x >= Config.largeur_carte || y < 0 || y >= Config.hauteur_carte)
			return false;
		else
			return true;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public boolean estVoisine(Position pos) {
		return ((Math.abs(x - pos.x) <= 1) && (Math.abs(y - pos.y) <= 1));
	}

	public Position convertPosPix() {
		int x, y;
		if (this.getX() % 2 == 0) {
			x = this.getX() * Config.nb_pix_case_x;
			y = this.getY() * Config.nb_pix_case_y;
		} else {
			x = this.getX() * Config.nb_pix_case_x;
			y = this.getY() * Config.nb_pix_case_y - (25 *20/Config.hauteur_carte);
		}
		return new Position(x, y);
	}

	public Position convertPixPos() {
		int y;
		int x = this.getX() / Config.nb_pix_case_x;
		if (x % 2 == 0) {
			y = this.getY() / Config.nb_pix_case_y;
		} else {
			y = (this.getY() + 25) / Config.nb_pix_case_y;
		}
		return new Position(x, y);
	}

	public boolean estAPortee(Position pos, int portee) {
		int dx = Math.abs(this.x - pos.x);
		int dy = Math.abs(this.y - pos.y);

		switch (dx) {
		case 0:
			if (dy <= portee) {
				return true;
			}
			break;
		case 1:
			if (pos.x % 2 == 0) {
				if (this.y - pos.y < 0) {
					if (dy <= portee - 1) {
						return true;
					}
				} else if (dy <= portee) {
					return true;
				}
			} else {
				if (this.y - pos.y < 0) {
					if (dy <= portee) {
						return true;
					}
				} else if (dy <= portee - 1) {
					return true;
				}
			}
			break;
		case 2:
			if (dy <= portee - 1) {
				return true;
			}

			break;
		case 3:
			if (pos.x % 2 == 0) {
				if (this.y - pos.y < 0) {
					if (dy <= portee - 2) {
						return true;
					}
				} else if (dy <= portee - 1) {
					return true;
				}
			} else {
				if (this.y - pos.y < 0) {
					if (dy <= portee - 1) {
						return true;
					}
				} else if (dy <= portee - 2) {
					return true;
				}
			}
			break;
		case 4:
			if (dy <= portee - 2) {
				return true;
			}
			break;
		case 5:
			if (pos.x % 2 == 0) {
				if (this.y - pos.y < 0) {
					if (dy <= portee - 3) {
						return true;
					}
				} else if (dy <= portee - 2) {
					return true;
				}
			} else {
				if (this.y - pos.y < 0) {
					if (dy <= portee - 2) {
						return true;
					}
				} else if (dy <= portee - 3) {
					return true;
				}
			}
			break;
		}
		return false;
	}

	public boolean equals(Position pos) {
		return (((this.x - pos.getX()) == 0) && ((this.y - pos.getY()) == 0));
	}
}
