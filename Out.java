import javax.swing.JFrame;

public class Out{
	public static void main(String[] args) {
		
		JFrame f = new JFrame("Out");
		//rectframe r = new rectframe();
		//background b = new background();
		jump j = new jump();
		f.add(j);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000,500);
		f.setVisible(true);
		/*while(s.x <= s.getWidth() && s.x >= s.getWidth() && s.y <= s.getHeight() && s.y >= s.getHeight()) {
			s.border();
		}*/
		while(true) {
			j.run();
		}
	}
}
