package view;

import javax.swing.*;

import controller.MenuMessage;
import controller.Message;
import controller.QuitMessage;
import controller.SwitchBoardMessage;
import view.Window;

import java.awt.*;
import java.util.concurrent.BlockingQueue;

public class Victoryscreen extends JFrame implements Window {
	
	JButton menu = new JButton("Menu");
	JButton quit = new JButton("quit");
	JPanel title = new JPanel();
	JLabel textfield = new JLabel();
	GridBagConstraints gbc = new GridBagConstraints();
	
	public Victoryscreen(int currentPlayer, BlockingQueue<Message> queue) {
		textfield.setBackground(Color.BLACK);
        textfield.setFont(new Font("normalFont", Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setOpaque(true);
        
		if(currentPlayer == 1) {
			textfield.setForeground(Color.BLUE);
	        textfield.setText("Player1 Wins!");
		}
		
		else {
			textfield.setForeground(Color.RED);
			textfield.setText("Player2's Wins!");
		}
		
		this.setSize(1600,1000);
        this.setVisible(true);
        this.setLayout(new GridBagLayout());
        this.setResizable(false);
        this.getContentPane().setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        title.setLayout(new BorderLayout());
        title.setBounds(0,0,400,500);
        title.add(textfield);
        title.setOpaque(true);
        
        menu.setFont(new Font("Ink Free", Font.PLAIN, 50));
        menu.setBounds(0,0,200,100);
        menu.addActionListener(e -> {
            try {
                queue.put(new MenuMessage());
            } catch (InterruptedException exception) {
                // do nothing
            }
        });
        
        quit.setFont(new Font("Ink Free", Font.PLAIN, 50));
        quit.setBounds(0,0,200,100);
        quit.addActionListener(e -> {
            try {
                queue.put(new QuitMessage());
            } catch (InterruptedException exception) {
                // do nothing
            }
        });
        
        gbc.insets = new Insets(0,5,100,5);
        gbc.gridx = 0;
        gbc.gridy = 30;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(title, gbc);
        gbc.gridy = 60;
        this.add(menu, gbc);
        gbc.gridy = 90;
        this.add(quit,gbc);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

}
