import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.ImageIcon;

public class Main {
	private Frame f;
	private TextField tfId, tfPwd, tfMsg; 
	private Button bLogin;
	private Image background=new ImageIcon(Main.class.getResource("/background.png")).getImage();

	public Main() {
		f = new Frame("Log in");
		f.setSize(500, 300);
		f.setLayout(null);

		Label lid = new Label("ID : ");
		lid.setBounds(50, 50, 100, 40);

		tfId = new TextField();
		tfId.setBounds(160, 60, 190, 40);

		Label lpwd = new Label("Password : ");
		lpwd.setBounds(50, 130, 100, 40);

		tfPwd = new TextField();
		tfPwd.setBounds(160, 130, 190, 40);

		bLogin = new Button("로그인");
		bLogin.setBounds(380, 90, 50, 50);

		tfMsg = new TextField();
		tfMsg.setBounds(50, 180, 370, 40);

		f.add(lid);
		f.add(tfId);
		f.add(lpwd);
		f.add(tfPwd);
		f.add(bLogin);
		f.add(tfMsg);

		f.setVisible(true);
	}
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}

	public static void main(String[] args) {
		Main m = new Main();

	}
}