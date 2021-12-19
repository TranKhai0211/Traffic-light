import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class draw_light extends JPanel {
	private int width = 120, height = 120;
	Color redLight = Color.gray;
	Color yellowLight = Color.gray;
	Color greenLight = Color.GREEN;
	String trangthai = "green";

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(greenLight);
		g.fillOval(65, 50, width, height);
		g.setColor(Color.BLACK);
		g.drawOval(65, 50, width, height);
		
		g.setColor(yellowLight);
		g.fillOval(65, 180, width, height);
		g.setColor(Color.BLACK);
		g.drawOval(65, 180, width, height);
		
		g.setColor(redLight);
		g.fillOval(65, 310, width, height);
		g.setColor(Color.BLACK);
		g.drawOval(65, 310, width, height);
	}
	
	public void changeColor() {
		redLight = Color.GRAY;
		yellowLight = Color.GRAY;
		greenLight = Color.GRAY;
		if(trangthai.equals("green")) {
			yellowLight = Color.YELLOW;
			trangthai = "yellow";
		}
		else if(trangthai.equals("yellow")) {
			redLight = Color.RED;
			trangthai = "red";
			
		}
		else if(trangthai.equals("red")) {
			greenLight = Color.GREEN;
			trangthai = "green";
		}
		repaint();
	}
}
