package bubblebubble;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel {

	Player player;
	int x, y;
	ImageIcon icBubble;

	public void init() {
		icBubble = new ImageIcon("images/bubble.png");

	}

	public Bubble() {
		
	}
}
