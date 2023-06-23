package sdad;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnSignup; // 회원가입 버튼 추가

    public LoginFrame() {
        // 레이블, 텍스트 필드, 버튼 등을 생성하고 위치를 설정합니다.
        lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 30, 80, 25);
        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 70, 80, 25);

        txtUsername = new JTextField();
        txtUsername.setBounds(130, 30, 150, 25);
        txtPassword = new JPasswordField();
        txtPassword.setBounds(130, 70, 150, 25);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(130, 120, 80, 25);
        btnSignup = new JButton("회원가입"); // 회원가입 버튼 생성
        btnSignup.setBounds(220, 120, 100, 25); // 회원가입 버튼 위치 설정

        // 로그인 버튼에 ActionListener를 추가하여 클릭 이벤트를 처리합니다.
        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            // 예시로 아이디와 비밀번호를 간단히 확인합니다.
            if (username.equals("admin") && password.equals("password")) {
                JOptionPane.showMessageDialog(this, "로그인 성공!");
            } else {
                JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 올바르지 않습니다.");
            }
        });

        // 회원가입 버튼에 ActionListener를 추가하여 클릭 이벤트를 처리합니다.
        btnSignup.addActionListener(e -> {
            // 회원가입 창을 나타내는 SignUpFrame을 생성하거나 원하는 동작을 구현합니다.
            JOptionPane.showMessageDialog(this, "회원가입 창을 띄웁니다.");
        });

        // 프레임에 컴포넌트들을 추가합니다.
        add(lblUsername);
        add(lblPassword);
        add(txtUsername);
        add(txtPassword);
        add(btnLogin);
        add(btnSignup); // 회원가입 버튼 추가

        // 프레임의 기본 설정을 지정합니다.
        setTitle("로그인");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); // 화면 중앙에 프레임을 배치합니다.
        setResizable(false); // 프레임 크기 조절 비활성화
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}