import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class drawCountDown extends JPanel {

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.gray);
		g.fillOval(60, 10, 120, 120);
	}
}
