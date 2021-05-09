package model;

import java.awt.event.*;

import javax.swing.*;

public class Tile extends JButton implements ActionListener {
	
	ImageIcon redHitIcon;
	ImageIcon blackHitIcon;
	int state = 0;

	public Tile() {
		redHitIcon = new ImageIcon(".\\Images\\redx.png");
		blackHitIcon = new ImageIcon(".\\Images\\blackx.png");
		this.setIcon(redHitIcon);
		this.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.getIcon() == redHitIcon) {
			this.setIcon(blackHitIcon);
		}
		else if (this.getIcon() == blackHitIcon){
			this.setIcon(redHitIcon);
		}
	}

}
