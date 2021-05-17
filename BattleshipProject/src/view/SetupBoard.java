package view;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Message;
import model.Boat;
import model.Tile;

public class SetupBoard extends JFrame implements Window {
	Tile[][] grid = new Tile[8][8];
	JTextField[] textField = new JTextField [5];
	JTextField[] textField2 = new JTextField [5];
	JCheckBox[] vertical = new JCheckBox[5];
	JCheckBox[] horizontal = new JCheckBox[5];
	ButtonGroup[] checkBoxGroup = new ButtonGroup[5];
	JPanel gridPanel = new JPanel();
	JPanel rowsPanel = new JPanel();
	JPanel columnsPanel = new JPanel();
	JPanel left_topPanel = new JPanel();
	JPanel blankPanel = new JPanel();
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	JPanel title = new JPanel();
	JLabel textfield = new JLabel();
	JPanel boatPanel = new JPanel();
	BlockingQueue<Message> queue;
	JButton[] rows = new JButton[8];
	JButton[] columns = new JButton[8];
	JButton update = new JButton("Update");
	JButton next = new JButton("Next");
	ImageIcon blackOIcon = new ImageIcon(".\\Images\\blacko.png");
	
	public SetupBoard(int player, BlockingQueue<Message> queue) {
		//setup title panel
		textfield.setBackground(Color.WHITE);
        textfield.setFont(new Font("normalFont", Font.BOLD,35));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setOpaque(true);
        
		if(player == 1) {
			textfield.setForeground(Color.BLUE);
	        textfield.setText("Player1 place your warships");
		}
		
		else {
			textfield.setForeground(Color.RED);
			textfield.setText("Player2 place you warships");
		}
		
		title.setLayout(new BorderLayout());
        title.setBounds(0,0,400,500);
        title.add(textfield);
        title.setOpaque(true);
        
        //setup right panel
        GridBagConstraints gbc = new GridBagConstraints();
        rightPanel.setLayout(new GridBagLayout());
        JPanel boat1 = new JPanel();
        boat1.setLayout(new GridLayout(1,5,1,1));
        for(int i = 0; i < 5; i++) {
        	JButton j1 = new JButton();
        	j1.setEnabled(false);
        	j1.setDisabledIcon(blackOIcon);
        	j1.setIcon(blackOIcon);
        	j1.setPreferredSize(new Dimension(75,75));
        	boat1.add(j1);
        }
        
        JPanel boat2 = new JPanel();
        boat2.setLayout(new GridLayout(1,4,1,1));
        for(int i = 0; i < 4; i++) {
        	JButton j1 = new JButton();
        	j1.setEnabled(false);
        	j1.setDisabledIcon(blackOIcon);
        	j1.setIcon(blackOIcon);
        	j1.setPreferredSize(new Dimension(75,75));
        	boat2.add(j1);
        }
        JPanel boat3 = new JPanel();
        boat3.setLayout(new GridLayout(1,3,1,1));
        for(int i = 0; i < 3; i++) {
        	JButton j1 = new JButton();
        	j1.setEnabled(false);
        	j1.setDisabledIcon(blackOIcon);
        	j1.setIcon(blackOIcon);
        	j1.setPreferredSize(new Dimension(75,75));
        	boat3.add(j1);
        }
        
        JPanel boat4 = new JPanel();
        boat4.setLayout(new GridLayout(1,3,1,1));
        for(int i = 0; i < 3; i++) {
        	JButton j1 = new JButton();
        	j1.setEnabled(false);
        	j1.setDisabledIcon(blackOIcon);
        	j1.setIcon(blackOIcon);
        	j1.setPreferredSize(new Dimension(75,75));
        	boat4.add(j1);
        }
        
        JPanel boat5 = new JPanel();
        boat4.setLayout(new GridLayout(1,2,1,1));
        for(int i = 0; i < 2; i++) {
        	JButton j1 = new JButton();
        	j1.setEnabled(false);
        	j1.setDisabledIcon(blackOIcon);
        	j1.setIcon(blackOIcon);
        	j1.setPreferredSize(new Dimension(75,75));
        	boat5.add(j1);
        }
        
        for (int i = 0; i < textField.length; i++){
            textField[i] = new JTextField();
            textField2[i] = new JTextField();
            vertical[i] = new JCheckBox("Vertical");
            horizontal[i] = new JCheckBox("Horizontal");
            checkBoxGroup[i] = new ButtonGroup();
            checkBoxGroup[i].add(vertical[i]);
            checkBoxGroup[i].add(horizontal[i]);
        }
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(1,10,1,10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        rightPanel.add(new JLabel("Ship 1"),gbc);
        gbc.gridy = 1;
        gbc.gridwidth = 5;
        rightPanel.add(boat1,gbc);
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        rightPanel.add(new JLabel("Row: "),gbc);
        gbc.gridx = 1;
        rightPanel.add(textField[0], gbc);
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        rightPanel.add(textField2[0],gbc);
        gbc.gridx = 0;
        rightPanel.add(new JLabel("Column: "),gbc);
        gbc.gridy = 4;
        rightPanel.add(vertical[0],gbc);
        gbc.gridx = 1;
        rightPanel.add(horizontal[0], gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        rightPanel.add(new JLabel("Ship 2"),gbc);
        gbc.gridy = 6;
        gbc.gridwidth = 4;
        rightPanel.add(boat2,gbc);
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        rightPanel.add(new JLabel("Row: "),gbc);
        gbc.gridx = 1;
        rightPanel.add(textField[1], gbc);
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        rightPanel.add(textField2[1],gbc);
        gbc.gridx = 0;
        rightPanel.add(new JLabel("Column: "),gbc);
        gbc.gridy = 9;
        rightPanel.add(vertical[1],gbc);
        gbc.gridx = 1;
        rightPanel.add(horizontal[1], gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 10;
        rightPanel.add(new JLabel("Ship 3"),gbc);
        gbc.gridy = 11;
        gbc.gridwidth = 3;
        rightPanel.add(boat3,gbc);
        gbc.gridy = 12;
        gbc.gridwidth = 1;
        rightPanel.add(new JLabel("Row: "),gbc);
        gbc.gridx = 1;
        rightPanel.add(textField[2], gbc);
        gbc.gridy = 13;
        gbc.gridwidth = 1;
        rightPanel.add(textField2[2],gbc);
        gbc.gridx = 0;
        rightPanel.add(new JLabel("Column: "),gbc);
        gbc.gridy = 14;
        rightPanel.add(vertical[2],gbc);
        gbc.gridx = 1;
        rightPanel.add(horizontal[2], gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 15;
        rightPanel.add(new JLabel("Ship 4"),gbc);
        gbc.gridy = 16;
        gbc.gridwidth = 3;
        rightPanel.add(boat4,gbc);
        gbc.gridy = 17;
        gbc.gridwidth = 1;
        rightPanel.add(new JLabel("Row: "),gbc);
        gbc.gridx = 1;
        rightPanel.add(textField[3], gbc);
        gbc.gridy = 18;
        gbc.gridwidth = 1;
        rightPanel.add(textField2[3],gbc);
        gbc.gridx = 0;
        rightPanel.add(new JLabel("Column: "),gbc);
        gbc.gridy = 19;
        rightPanel.add(vertical[3],gbc);
        gbc.gridx = 1;
        rightPanel.add(horizontal[3], gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 20;
        rightPanel.add(new JLabel("Ship 5"),gbc);
        gbc.gridy = 21;
        gbc.gridwidth = 2;
        rightPanel.add(boat5,gbc);
        gbc.gridy = 22;
        gbc.gridwidth = 1;
        rightPanel.add(new JLabel("Row: "),gbc);
        gbc.gridx = 1;
        rightPanel.add(textField[4], gbc);
        gbc.gridy = 23;
        gbc.gridwidth = 1;
        rightPanel.add(textField2[4],gbc);
        gbc.gridx = 0;
        rightPanel.add(new JLabel("Column: "),gbc);
        gbc.gridy = 24;
        rightPanel.add(vertical[4],gbc);
        gbc.gridx = 1;
        rightPanel.add(horizontal[4], gbc);
        gbc.gridy = 25;
        rightPanel.add(next, gbc);
        gbc.gridx = 0;
        rightPanel.add(update, gbc);
        
        //set up button action listener
        
        
 
		
		//setup left(center) panel, where the coordinates shows
		rows[0] = new JButton("A");
		rows[1] = new JButton("B");
		rows[2] = new JButton("C");
		rows[3] = new JButton("D");
		rows[4] = new JButton("E");
		rows[5] = new JButton("F");
		rows[6] = new JButton("G");
		rows[7] = new JButton("H");
		
		JButton blank = new JButton();
		blank.setEnabled(false);
		blank.setPreferredSize(new Dimension(60,60));
		
		 for (int i = 0; i< 8; i++) {
			 columns[i] = new JButton(String.valueOf(i+1));
		 }
		
		this.setSize(1300, 1000);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.gridPanel.setLayout(new GridLayout(8,8,5,5));
		//gridPanel.setSize(800,600);
		rowsPanel.setLayout(new GridLayout(1,8,5,5));
		columnsPanel.setLayout(new GridLayout(8,1,5,5));
		blankPanel.setLayout(new GridLayout(1,1,5,5));
		leftPanel.setLayout(new BorderLayout());
		left_topPanel.setLayout(new BorderLayout());
		
		for(int i = 0; i < 8; i++) {
			rows[i].setEnabled(false);
			rowsPanel.add(rows[i]);
		}
		
		for(int j = 0; j < 8; j++) {
			columns[j].setPreferredSize(new Dimension(60,60));
			columns[j].setEnabled(false);
			columnsPanel.add(columns[j]);
		}
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				grid[i][j] = new Tile(this.queue);
				grid[i][j].setEnabled(false);
				//grid[i][j].setPreferredSize(new Dimension(75,75));
				gridPanel.add(grid[i][j]);
			}
		}
		
		blankPanel.add(blank);
		left_topPanel.add(blankPanel, BorderLayout.WEST);
		left_topPanel.add(rowsPanel,BorderLayout.CENTER);
		leftPanel.add(gridPanel, BorderLayout.CENTER);
		leftPanel.add(left_topPanel, BorderLayout.NORTH);
		leftPanel.add(columnsPanel, BorderLayout.WEST);
		
		this.setLayout(new BorderLayout());
		this.add(title, BorderLayout.NORTH);
		this.add(leftPanel, BorderLayout.CENTER);
		this.add(rightPanel, BorderLayout.EAST);
		this.setVisible(true);
	}
	

	 public static void main(String[] args) {
		 BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
		 SetupBoard s = new SetupBoard(1,queue);
	    }

}

//public void updateGrid(){
//
//}
