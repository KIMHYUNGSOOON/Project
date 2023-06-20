package FirstProj;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LunchMenuRoulette extends JFrame {
    private JLabel resultLabel;
    private JButton recommendButton;
    private String[] menuOptions = {
            "Pizza",
            "Hamburger",
            "Jajangmyeon",
            "Sushi",
            "Salad",
            "Kimbap",
            "Tteokbokki",
            "Episode",
            "Pasta",
            "Curry",
            "Chiken",
            "Pork belly"
    };

    public LunchMenuRoulette() {
        setTitle("LunchMenuRoulette");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        resultLabel = new JLabel("Today Menu??");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(resultLabel);

        recommendButton = new JButton("Choice");
        recommendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recommendMenu();
            }
        });
        panel.add(recommendButton);

        add(panel);
    }

    private void recommendMenu() {
        Random random = new Random();
        int index = random.nextInt(menuOptions.length);
        String recommendedMenu = menuOptions[index];
        resultLabel.setText("recommended menu: " + recommendedMenu);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LunchMenuRoulette frame = new LunchMenuRoulette();
                frame.setVisible(true);
            }
        });
    }
}