package Image;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class Main extends JFrame{

	private Image background=new ImageIcon(Main.class.getResource("/background.png")).getImage();

	public Main() {
		homeframe();
	}
	public void homeframe() {
		setTitle("MainFrame");
		setSize(400,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
	public static void main(String[] args){
		new Main();
	}
}