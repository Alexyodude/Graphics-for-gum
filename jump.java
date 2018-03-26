import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class jump extends JPanel implements Runnable, ActionListener, KeyListener, MouseListener{

		/**
	 * 
	 */
	private static final long serialVersionUID = 2447649188635840058L;
		Timer t = new Timer(5, this);
		background b = new background();
		JLabel label = new JLabel("Test");
		int sizeofrect1 = 30;
		int numofshad = 5;
		int numofmenu = 10;
		int menustart1 = 20;
		int iop = 5;
		int point = 0;
		double menuwidth = 100;
		double menuheight = 30;
		double movement = 0.1;
		double movement2 = 0.00001;
		double[] menuposx = new double[numofmenu];
		double[] menuposy = new double[numofmenu];
		double t1 = 0;
		double g = 9.81;
		double dt = 0.01;
		double spacing = 2.5;
		double ground = 0;
		double speed = 2;
		double ux[] = new double[numofshad];
		double uy[] = new double[numofshad];
		double[] x = new double[numofshad];
		double[] y = new double[numofshad];
		double[] x1 = new double[numofmenu];
		double[] y1 = new double[numofmenu];
		double[] x2 = new double[iop];
		double[] y2 = new double[iop];
		double[] s = new double[iop];
		boolean collision = false;
		boolean menu = false;
		boolean wall = false;
		boolean pause = false;
		boolean jump1 = false;
		boolean left = false;
		boolean right = false;
		boolean oops = true;
		boolean pointbool = false;
		
		
		//private List<Bullets> firedBullets = new ArrayList<Bullets>();

public jump() {
	t.start();
	addKeyListener(this);
	addMouseListener(this);
	setFocusable(true);
	setFocusTraversalKeysEnabled(false);
	x1[0] = 900;
	y1[0] = 20;
	x[0] = 500 - sizeofrect1/2;
	y[0] = 20;
	//y[0] = ground - (sizeofrect1);
	}
/*public void fire(){
    Bullets bullets = new Bullets(x[0], y[0]);
    firedbullets.add(bullets);
    bullets.launch(direction);
}*/
public void paintComponent(Graphics g) {
	ground = getHeight()*6/7;
	for(int l = 1; l < numofmenu - 3; l++) {
		x1[l] = (getWidth()/2) - (menuwidth/2);
		y1[l] = (getHeight()/4) - (menuheight/2) + l * 2 * menuheight;
	}
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D) g;
	g2.setColor(Color.BLACK);
	g2.fill(new Rectangle2D.Double(x[0], y[0], sizeofrect1, sizeofrect1));
	g2.fill(new Rectangle2D.Double(x1[0] ,y1[0] , menustart1, menustart1));
	if(menu == true) {
		int i = 1;
	g2.fill(new Rectangle2D.Double(x1[i] ,y1[i] , menuwidth, menuheight));
	g2.fill(new Rectangle2D.Double(x1[i+1] ,y1[i+1] , menuwidth, menuheight));
	g2.fill(new Rectangle2D.Double(x1[i+2] ,y1[i+2] , menuwidth, menuheight));
	}
	g2.fill(new Rectangle2D.Double(x2[1], y2[1], s[1], s[1]));
	g2.fill(new Rectangle2D.Double(x2[2], y2[2], s[2], s[2]));
	g2.fill(new Rectangle2D.Double(x2[3], y2[3], s[3], s[3]));
	g2.fill(new Rectangle2D.Double(x2[4], y2[4], s[4], s[4]));
	g2.fill(new Rectangle2D.Double(10+point, 10+point, point, point));
	/*g2.fill(new Rectangle2D.Double(x1[1] ,y1[1] , menuwidth, menuheight));
	g2.fill(new Rectangle2D.Double(x1[2] ,y1[2] , menuwidth, menuheight));
g2.setColor(Color.YELLOW);
g2.fill(new Rectangle2D.Double(x[1], y[1], sizeofrect1, sizeofrect1));
g2.setColor(Color.YELLOW);
g2.fill(new Rectangle2D.Double(x[2], y[2], sizeofrect1, sizeofrect1));
g2.setColor(Color.YELLOW);
g2.fill(new Rectangle2D.Double(x[3], y[3], sizeofrect1, sizeofrect1));
g2.setColor(Color.YELLOW);
g2.fill(new Rectangle2D.Double(x[4], y[4], sizeofrect1, sizeofrect1));
*/
g2.draw(new Line2D.Double(0, ground, getWidth(), ground));
}
public void actionPerformed(ActionEvent e) {
	repaint();
	}
/*public void objforward() {
		if(0 < x2[4]) {
			for(int h = 0;h < iop; h++) {
			x2[h] = x2[h] - 1;
			}if(x2[4] < 0) {
				x2[4] = 1000;
			}
		}
	}*/
public void keyPressed(KeyEvent e) {
	int key = e.getKeyCode();
	//double r = 100 + (y[0] - (y[0] % 100));
	if(wall == false) {
	if ((key == KeyEvent.VK_W || key == KeyEvent.VK_SPACE) && collision && !pause) {
		//System.out.println(uy[0]);
		//uy[0] = uy[0] * (9 * -g * dt);
		y[0] = y[0] - (uy[0] * dt);
	}if (key == KeyEvent.VK_A && !pause) {
    	left = true;
    }if (key == KeyEvent.VK_D && !pause) {
    	right = true;
    }if(KeyEvent.VK_ESCAPE == key && (pause == false)) {
		pause = true;
		menu = true;
    }if((KeyEvent.VK_ESCAPE == key) && (pause == true)) {
		pause = false;
		menu = false;
	}if((KeyEvent.VK_1 == key) && (!pause)) {
		pause = true;
		menu = true;
	}if((KeyEvent.VK_9 == key) && (!pause)) {
		x[0] = getWidth()/2;
		y[0] = getHeight()/10;
	}
	}
}
public void right() {
	ux[0] = 1;
	x[0] = x[0] + movement * dt;
}
public void left() {
	x[0] = x[0] - movement * dt;
}
public void jumping() {
	if((y[0] <= (ground - sizeofrect1)) && !pause && !collision) {
		uy[0] = uy[0] + (-g * dt);
		y[0] = y[0] - (uy[0] * dt);
		//t1 = t1 + dt;
		//System.out.println("Time: " + t1 + ", Ypos: " + y[0]+ ", Yvel: " + uy[0]);
	}/*if(y[0] > (ground - sizeofrect1)) {
		uy[0] = 0;
		y[0] = ground - sizeofrect1; 
		System.out.println(y[0] + "," + uy[0] + "," + (ground - sizeofrect1) + "," + ground);
 	}*/
	delay(1);
}
public void objforward() {
	/*for(int count = 0; count < iop; count++) {
		if(x2[count] >= (0 - (s[count]/2))) {
		x2[count] = ((x2[count]) - movement2);
	System.out.println(x2[count]);
		}if(x2[count] <= (0 - (s[count]/2))) {
			for(int l = 0; l < iop; l++) {
				x2[l] = 1000;
			}
	}
	}*/
	for(int count = 0; count < iop; count++) {
		if(x2[count] < getWidth() + s[count]) {
			x2[count] = x2[count] - movement2;
		}if((x2[count] < (0 - (s[count]/2)))) {
			x2[count] = getWidth()- s[count];
		}if(x2[count] > getWidth() + s[count]) {
			x2[count] = getWidth() + s[count];
		}
	}
}
public void bump() {
	for(int count = 0; count < iop; count++) {
		if(x[0]+sizeofrect1 > x2[count] && x[0]+sizeofrect1 < x2[count] + s[count] && y[0] > y2[0] && y[0] < y2[4]+s[count]) {
			right = false;
		x[0] = x[0] - 1;
		}
	}
}
public void score(){
	for(int count = 0; count < iop; count++) {
		if(y[0] < y2[count] && x[0] > x2[count] && x[0] < x2[count] + s[count]) {
			pointbool = true;
		}if(pointbool == true && collision) {
				point++;
				pointbool = false;
				System.out.println(point);
			}
		}
	//System.out.println(pointbool);
}
public void delay(int delay){
	try{
		Thread.sleep(delay);
	} catch (InterruptedException e) {
	}
}
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	left = false;
	right = false;
}
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
} 
public void run() {
	// TODO Auto-generated method stub
	if(!pause) {
		objforward();
		bump();
		score();
	if(left) {
		left();
	}if(right) {
		right();
	}if(y[0] < (ground - sizeofrect1)) {
		movement = 40;
		movement2 = 0.2;
		collision = false;
		jumping();
	}if(y[0] >= (ground - sizeofrect1)) {
		movement = 0.005;
		movement2 = 0.00002;
		collision = true;
		uy[0] = 60;
		if(y[0]+1 > (ground - sizeofrect1)) {
			y[0] = ground - sizeofrect1;
		}
	}}for(int k = 0; k < iop; k++) {
		y2[k] = 200 + s[k] * k/2;
		}for(int s2 = 0; s2 < iop; s2++ ) {
			s[s2] = 50;
	}
	}
	//System.out.println(y[0] + sizeofrect1);
	//System.out.println(ground);
	//System.out.println(x[0] + "," + y[0]);

@Override
public void mouseClicked(MouseEvent e) {
	int mouse = e.getButton();
	if(mouse == 1 && (menu == false) && (getMousePosition().x < x1[0] + menustart1) && (getMousePosition().y < y1[0] + menustart1) && (getMousePosition().x > x1[0]) && (getMousePosition().y > y1[0])) {
		menu = true;
		pause = true;
	}else if(mouse == 1 && (menu == true) && (getMousePosition().x < x1[0] + menustart1) && (getMousePosition().y < y1[0] + menustart1) && (getMousePosition().x > x1[0]) && (getMousePosition().y > y1[0])) {
		menu = false;
		pause = false;
	} /*if(mouse == 1 && pause) {
		pause = false;
		System.out.println(pause + "hi");
	}else if((mouse == 1) && (pause == false)) {
		pause = true;
		System.out.println(pause);
	}*/
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}