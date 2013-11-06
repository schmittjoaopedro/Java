package org.schmitt.framework.serial.controller.release;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HumanoidController {

	public static void main(String...strings){
		
		JFrame frame = new JFrame();
		JPanel s = new PanelServo(7,90);
		JPanel s2 = new PanelServo(8,90);
		
		frame.setLayout(new BorderLayout());
		
		frame.add(s, BorderLayout.EAST);
		frame.add(s2,BorderLayout.WEST);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
}
