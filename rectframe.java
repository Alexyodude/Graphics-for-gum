import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
	
public class rectframe extends JPanel implements ActionListener, KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 897654325678907654L;
	Timer t = new Timer(5, this);
	int sizeofrect1 = 50;
	double x = 500, y = 0, ux = 0, uy = 0;
	double speed = 2; 
	boolean gravon = false;
	double t1 = 0;
	double dt = 0.01;
	double g = 9.81;

public rectframe() {
t.start();
addKeyListener(this);
setFocusable(true);
setFocusTraversalKeysEnabled(false);
}
public void paintComponent(Graphics g) {
super.paintComponent(g);
Graphics2D g2 = (Graphics2D) g;
g2.fill(new Rectangle2D.Double(x, y, sizeofrect1, sizeofrect1));
}
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
repaint();
}
public void up() {
	for(int i = 0; i < 3; i++) {
	uy += 1;
	}while(gravon) {
		gravity();
	}
}
public void down() {
ux += 0;
uy += speed;
}
public void right() {
ux += speed;
uy += 0;
}
public void left() {
ux += -speed;
uy += 0;		
}
public void border() {
int gw = getWidth();
int gh = getHeight();
System.out.println(gw + ", " + gh);
if(x <= 0) {
	x = 1;
}if(x + sizeofrect1 >= gw) {
	x = gw - sizeofrect1;
}if(y + sizeofrect1 >= gh) {
	y = gh - sizeofrect1;
}
}
public void gravity() {
	y = y + 9.81 * dt;
}
public void keyPressed(KeyEvent e) {
int key = e.getKeyCode();

if (key == KeyEvent.VK_A) {
    left();
}if (key == KeyEvent.VK_D) {
    right();
}if (key == KeyEvent.VK_W) {
    up();
    gravon = true;
}if (key == KeyEvent.VK_S) {
    down();
}
}
public void keyReleased(KeyEvent e) {
// TODO Auto-generated method stub
ux = 0;
uy = 0;
}
public void keyTyped(KeyEvent e) {
// TODO Auto-generated method stub

}
}

	