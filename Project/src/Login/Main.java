package Login;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Main implements ActionListener {
    private Frame f;
    private TextField tfId, tfPwd, tfMsg,subtfId,subtfPwd,subtfPwd2,subtftell,subtfname, sub2tftell,sub2tfname;
    private Button bLogin;
    private MemberDAO dao = new MemberDAO();

    public Main() {
        dao = new MemberDAO();

        f = new Frame("로그인");
        f.setSize(500, 300);
        f.setLayout(null);

        Label lid = new Label("아이디 : ");
        lid.setBounds(50, 50, 100, 40);

        tfId = new TextField();
        tfId.setBounds(160, 60, 190, 40);

        Label lPwd = new Label("비밀번호 : ");
        lPwd.setBounds(50, 130, 100, 40);

        tfPwd = new TextField();
        tfPwd.setBounds(160, 130, 190, 40);

        bLogin = new Button("로그인");
        bLogin.setBounds(380, 90, 50, 50);
        bLogin.addActionListener(this);

        tfMsg = new TextField();
        tfMsg.setBounds(50, 180, 370, 40);
        
        
        
        // 아이디 찾기 프레임 ------------------------------------------
        Frame bw2sub = new Frame("아"
        		+ "이디 찾기");
        bw2sub.setSize(400, 300);
        bw2sub.setLocationRelativeTo(null);
        
        Label sub2lname = new Label("     이름");
        sub2lname.setBounds(70, 50, 100, 40);

        sub2tfname = new TextField();
        sub2tfname.setBounds(150, 55, 230, 30);
        
        Label sub2ltell = new Label("   전화번호");
        sub2ltell.setBounds(70, 150, 100, 40);

        sub2tftell = new TextField();
        sub2tftell.setBounds(150, 155, 230, 30);
        
        Button subbt2=new Button("아이디 찾기");
        subbt2.setBounds(220,200, 80, 30);
        
        //회원가입 프레임 ---------------------------------------------------------
        
        Frame bw1sub =new Frame("회원가입");
        bw1sub.setSize(500,400);
        bw1sub.setLocationRelativeTo(null); //프레임창 화면 가운데 위치
        
        Label sublname = new Label("     이름");
        sublname.setBounds(70, 50, 100, 40);

        subtfname = new TextField();
        subtfname.setBounds(150, 55, 230, 30);
        
        Label sublid = new Label("    아이디");
        sublid.setBounds(70, 110, 100, 40);

        subtfId = new TextField();
        subtfId.setBounds(150, 115, 230, 30);

        
        Label sublPwd = new Label("   비밀번호");
        sublPwd.setBounds(70, 170, 100, 40);

        subtfPwd = new TextField();
        subtfPwd.setBounds(150, 175, 230, 30);
        
        Label sublPwd2 = new Label("비밀번호 확인");
        sublPwd2.setBounds(70, 230, 100, 40);

        subtfPwd2 = new TextField();
        subtfPwd2.setBounds(150, 235, 230, 30);

        Label subltell = new Label("   전화번호");
        subltell.setBounds(70, 300, 100, 40);

        subtftell = new TextField();
        subtftell.setBounds(150, 305, 230, 30);
        
        Button subbt=new Button("회원가입");
//        subbt.setSize(20,30);
//        subbt.setLocation(100, 170);
        subbt.setBounds(220,230, 80, 30);
        
        
        
        
        Button bw1=new Button("회원가입");
        bw1.setSize(80,30);
        bw1.setLocation(100, 75);
        bw1.setBounds(220, 230, 80, 30);
        
        bw1.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e) {
        	bw1sub.setVisible(true);
        	String ID=subtfname.getText();
        	String PASSWORD=subtfPwd.getText();
        	String NAME=subtfname.getText();
        	String TELL=subtftell.getText();
        	
        	dao.insertForStatement(ID, PASSWORD, NAME, TELL);
        	}
        });
        
        Button bw2=new Button("ID/Password 찾기");
        bw2.setSize(80,30);
        bw2.setLocation(100, 75);
        bw2.setBounds(320, 230, 130, 30);
        
        bw2.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e) {
        	bw2sub.setVisible(true);	
        	}
        });

        f.add(tfId);
        f.add(lPwd);
        f.add(tfPwd);
        f.add(lid);
        f.add(bLogin);
        f.add(tfMsg);
        f.add(bw1);
        f.add(bw2);
        
        bw1sub.add(subtfname);
        bw1sub.add(sublname);
        bw1sub.add(subtfId);
        bw1sub.add(sublid);
        bw1sub.add(subtfPwd);
        bw1sub.add(sublPwd);
        bw1sub.add(subtfPwd2);
        bw1sub.add(sublPwd2);
        bw1sub.add(subtftell);
        bw1sub.add(subltell);
        bw1sub.add(subbt);
        
        bw2sub.add(sublname);
        bw2sub.add(sub2tfname);
        bw2sub.add(sub2ltell);
        bw2sub.add(sub2tftell);
        bw2sub.add(subbt2);
        
        bw1sub.addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosing(WindowEvent e) {
        		bw1sub.dispose();
        	}
        });
        
        bw2sub.addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosing(WindowEvent e) {
        		bw2sub.dispose();
        	}
        });
        
        
        //프레임을 화면 중앙에 배치
        f.setLocationRelativeTo(null);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("click");
        System.out.println(tfId.getText() + " " + tfPwd.getText());

        String strId = tfId.getText();

        ArrayList<MemberVo> list = dao.list(strId);

        for (int i = 0; i < list.size(); i++) {
            MemberVo data = (MemberVo) list.get(i);
            String id = data.getId();
            String pwd = data.getpassword();

            System.out.println("DB ==> " + id + " " + pwd);

            if (tfPwd.getText().equals(pwd)) {
                System.out.println("로그인이 되었습니다.");
            } else {
                System.out.println("다시 입력하세요");
            }
        }
    }
}