import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class Part3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame fr=new Frame("Lunch Main");
		fr.setSize(1000, 800);
		fr.setLayout(new FlowLayout());
		Label lid= new Label("메뉴");
		TextField id =new TextField(50);
		id.setBounds(30, 0, 30, 10);
		id.setBounds(500, 500, 0, 0);
		
		fr.setVisible(true);
		id.setVisible(true);
		fr.add(lid);
		fr.add(id);
	}
}
