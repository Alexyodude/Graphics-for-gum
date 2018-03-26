import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class terrain extends JPanel{
	int s = 10;
	int x;
	int y;
	public terrain(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(new Rectangle2D.Double(x, y, s, s));
	}
}
