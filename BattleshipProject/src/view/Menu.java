package view;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    JButton start = new JButton("Start");
    JButton setting = new JButton("Setting");
    JPanel title = new JPanel();
    ImageIcon img = new ImageIcon(".\\Images\\Background.jpg");
    JLabel background = new JLabel("",img, JLabel.CENTER);
    JLabel textfield = new JLabel();
    GridBagConstraints gbc = new GridBagConstraints();

    public Menu(){

        this.setSize(1280,720);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.getContentPane().setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(background);
        background.setOpaque(true);

        textfield.setForeground(Color.WHITE);
        textfield.setFont(new Font("normalFont", Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Battleship");
        textfield.setOpaque(false);

        title.setLayout(new BorderLayout());
        title.setBounds(0,0,400,500);
        title.add(textfield);
        title.setOpaque(false);

        start.setFont(new Font("Ink Free", Font.PLAIN, 50));
        start.setBounds(0,0,200,100);
//        start.addActionListener(e -> {
//            try {
//                queue.put(new StartMessage());
//            } catch (InterruptedException exception) {
//                // do nothing
//            }
//        });

        setting.setFont(new Font("Ink Free", Font.PLAIN, 50));
        setting.setBounds(0,0,200,100);

        background.setLayout(new GridBagLayout());
        gbc.insets = new Insets(0,5,100,5);
        gbc.gridx = 0;
        gbc.gridy = 30;
        gbc.fill = GridBagConstraints.VERTICAL;
        background.add(title,gbc);
        gbc.gridy = 60;
        background.add(start,gbc);
        gbc.gridy = 120;
        background.add(setting,gbc);
    }

//    public static void main(String[] args) {
//        Menu m = new Menu();
//    }
}