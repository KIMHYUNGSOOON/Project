package TestExample;

import javax.swing.*;
import java.awt.*;

public class CustomButtonWithTextField extends JButton {
    private JTextField textField;

    public CustomButtonWithTextField() {
        super();
        setLayout(new BorderLayout());

        textField = new JTextField();
        add(textField, BorderLayout.CENTER);
    }

    public String getText() {
        if (textField != null) {
            return textField.getText();
        } else {
            return "";
        }
    }

    public void setText(String text) {
        if (textField != null) {
            textField.setText(text);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom Button with TextField");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());

            CustomButtonWithTextField button = new CustomButtonWithTextField();
            button.setText("Click me");

            button.addActionListener(e -> {
                String text = button.getText();
                JOptionPane.showMessageDialog(frame, "Entered Text: " + text);
            });

            frame.add(button);
            frame.pack();
            frame.setVisible(true);
        });
    }
}