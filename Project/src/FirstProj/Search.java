package FirstProj;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Frame sf=new Frame("주변 검색");
			sf.setSize(1000, 700);
			sf.setLayout(null);
			sf.setVisible(true);
			sf.setLocationRelativeTo(null);
			
			Label sflabel =new Label("");
			sflabel.setBounds(200, 100, 100, 40);
			
			TextField sftf= new TextField();
			sftf.setBounds(400, 105, 300, 30);
			
			Button sfbt=new Button("검색");
			sfbt.setBounds(500, 105, 40, 40);
			sfbt.setLocation(800, 100);
			sfbt.setSize(40,40);
			
			sf.addWindowListener(new WindowAdapter() {
	        	@Override
	        	public void windowClosing(WindowEvent e) {
	        		sf.dispose();
	        	}
	        });
			
			sf.add(sflabel);
			sf.add(sftf);
			sf.add(sfbt);
	}

}
