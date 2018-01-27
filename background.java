import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;


public class background extends JPanel implements Runnable, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1521586404369302612L;
	Timer t = new Timer(5, this);
	Random rand =  new Random();
	float rr = rand.nextFloat();
	float gg = rand.nextFloat();
	float bb = rand.nextFloat();
	Color randcolor = new Color(rr, gg, bb);
	float b4x1 = 10;
	//int b4x2 = rand.nextInt(-400);
	int iop = 5;
	//int obs = 5;
	double[] x2 = new double[iop];
	double[] y2 = new double[iop];
	double[] x3 = new double[iop];
	double[] y3 = new double[iop];
	double[] s = new double[iop];
	
public background() {
	t.start();
	setFocusable(true);
	setFocusTraversalKeysEnabled(false);
	for(int d = 0; d < iop; d++) {
		x2[d] = 1000;
	}
} 
public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D) g;
	g2.setColor(Color.BLACK);
	g2.fill(new Rectangle2D.Double(x2[0], y2[0], s[0], s[0]));
	g2.fill(new Rectangle2D.Double(x2[1], y2[1], s[1], s[1]));
	g2.fill(new Rectangle2D.Double(x2[2], y2[2], s[2], s[2]));
	g2.fill(new Rectangle2D.Double(x2[3], y2[3], s[3], s[3]));
	g2.fill(new Rectangle2D.Double(x2[4], y2[4], s[4], s[4]));
}
public void colors() {
	rr = rand.nextFloat();
	gg = rand.nextFloat();
	bb = rand.nextFloat();
	randcolor = new Color(rr, gg, bb);
}
public void objforward() {
	for(int j = 0; j < x2[4]; j++) {
	 
		x2[j] = j - 1;
	}
	if(x2[4] < 0) {
		x2[4] = 1000;
	}
}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		objforward();
		colors();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

}
