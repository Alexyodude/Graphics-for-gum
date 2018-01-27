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
		int sizeofrect1 = 30;
		int numofshad = 5;
		int numofmenu = 10;
		int menustart1 = 20;
		int iop = 5;
		double menuwidth = 100;
		double menuheight = 30;
		double movement = 0.1;
		double[] menuposx = new double[numofmenu];
		double[] menuposy = new double[numofmenu];
		double t1 = 0;
		double g = 9.81;
		double dt = 0.01;
		double spacing = 2.5;
		double ground = 500/4*3;
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
		boolean pause = true;
		boolean jump1 = false;
		boolean left = false;
		boolean right = false;
		
		
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
	for(int l = 1; l < numofmenu - 3; l++) {
		x1[l] = (getWidth()/2) - (menuwidth/2);
		y1[l] = (getHeight()/4) - (menuheight/2) + l * 2 * menuheight;
	}if(x[4] > 0) {
		for(int d = 0; d < iop; d++) {
		x2[d] = x2[d] - d * 10;
		System.out.println(x2);
		}
	}for(int k = 0; k < iop; k++) {
	y2[k] = 100 * k;
	}if(x2[4] < 0) {
		x[4] = getWidth();
	}for(int s2 = 0; s2 < iop; s2++ ) {
		s[s2] = 10;
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
	g2.fill(new Rectangle2D.Double(100, y[1], s[1], 200));
	g2.fill(new Rectangle2D.Double(x2[2], y2[2], s[2], s[2]));
	g2.fill(new Rectangle2D.Double(x2[3], y2[3], s[3], s[3]));
	g2.fill(new Rectangle2D.Double(x2[4], y2[4], s[4], s[4]));
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
public void objforward() {
		if(0 < x2[4]) {
			for(int h = 0;h < iop; h++) {
			x2[h] = x2[h] - 1;
			if(x2[4] < 0) {
				x2[4] = 1000;
				System.out.println("g");
		}
		}
		}
	}
public void keyPressed(KeyEvent e) {
	int key = e.getKeyCode();
	//double r = 100 + (y[0] - (y[0] % 100));
	if(wall == false) {
	if ((key == KeyEvent.VK_W || key == KeyEvent.VK_SPACE) && collision && pause) {
		//System.out.println(uy[0]);
		uy[0] = uy[0] * (9 * -g * dt);
		y[0] = y[0] - (uy[0] * dt);
	}else if (key == KeyEvent.VK_A && pause) {
    	left = true;
    }else if (key == KeyEvent.VK_D && pause) {
    	right = true;
    }
	}if(KeyEvent.VK_P == key && pause) {
    		pause = false;
    }if((KeyEvent.VK_P == key) && (pause == false)) {
    		pause = true;
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
	if((y[0] <= (ground - sizeofrect1)) && pause) {
		uy[0] = uy[0] + (-g * dt);
		y[0] = y[0] - (uy[0] * dt);
		//t1 = t1 + dt;
		delay(1);
		//System.out.println("Time: " + t1 + ", Ypos: " + y[0]+ ", Yvel: " + uy[0]);
	}/*if(y[0] > (ground - sizeofrect1)) {
		uy[0] = 0;
		y[0] = ground - sizeofrect1; 
		System.out.println(y[0] + "," + uy[0] + "," + (ground - sizeofrect1) + "," + ground);
 	}*/
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
	jumping();
	objforward();
	b.run();
	if(left) {
		left();
	}if(right) {
		right();
	}if(y[0] < (ground - sizeofrect1)) {
		movement = 40;
		collision = false;
	}else if(y[0] >= (ground - sizeofrect1)) {
		movement = 0.005;
		collision = true;
		uy[0] = 60;
	}if(y[0] - 1.1 >= (ground - sizeofrect1)) {
		y[0]= 1;
	}
	//System.out.println(y[0] + sizeofrect1);
	//System.out.println(ground);
	//System.out.println(x[0] + "," + y[0]);
}

@Override
public void mouseClicked(MouseEvent e) {
	int mouse = e.getButton();
	if(mouse == 1 && (menu == false) && (getMousePosition().x < x1[0] + menustart1) && (getMousePosition().y < y1[0] + menustart1) && (getMousePosition().x > x1[0]) && (getMousePosition().y > y1[0])) {
		menu = true;
		pause = false;
	}else if(mouse == 1 && (menu == true) && (getMousePosition().x < x1[0] + menustart1) && (getMousePosition().y < y1[0] + menustart1) && (getMousePosition().x > x1[0]) && (getMousePosition().y > y1[0])) {
		menu = false;
		pause = true;
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