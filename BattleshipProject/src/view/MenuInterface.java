package view;

import javax.swing.*;

import controller.Message;
import controller.StartMessage;

import java.awt.*;
import java.util.concurrent.BlockingQueue;
/**
 * 
 * @author Team 9 
 *	This class is for displaying the first thing the user will see when using the application
 */
public class MenuInterface extends JFrame implements Window{

    JButton start = new JButton("Start");
    JButton setting = new JButton("Setting");
    JPanel title = new JPanel();
    //ImageIcon img = new ImageIcon(".\\Images\\Background.jpg");
    //JLabel background = new JLabel("",img, JLabel.CENTER);
    JLabel textfield = new JLabel();
    GridBagConstraints gbc = new GridBagConstraints();
/**
 * Constructor for this class
 * @param queue queue from BlockingQueue interface
 */
    public MenuInterface(BlockingQueue<Message> queue){

        this.setSize(1280,720);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.getContentPane().setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //this.add(background);
        //background.setOpaque(true);

        textfield.setForeground(Color.WHITE);
        textfield.setFont(new Font("normalFont", Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Battleship");
        textfield.setOpaque(false);

        title.setLayout(new BorderLayout());
        title.setBounds(0,0,400,500);
        title.add(textfield);
        title.setOpaque(false);

        start.setFont(new Font("normalFont", Font.PLAIN, 50));
        start.setBounds(0,0,200,100);
        start.addActionListener(e -> {
            try {
                queue.put(new StartMessage(queue));
            } catch (InterruptedException exception) {
                // do nothing
            }
        });

        setting.setFont(new Font("normalFont", Font.PLAIN, 50));
        setting.setBounds(0,0,200,100);
        
        
        this.setLayout(new GridBagLayout());
        //background.setLayout(new GridBagLayout());
        gbc.insets = new Insets(0,5,100,5);
        gbc.gridx = 0;
        gbc.gridy = 30;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(title, gbc);
        //background.add(title,gbc);
        gbc.gridy = 60;
        this.add(start, gbc);
        //background.add(start,gbc);
        gbc.gridy = 120;
        this.add(setting, gbc);
        //background.add(setting,gbc);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
}