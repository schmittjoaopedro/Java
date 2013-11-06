package org.schmitt.framework.serial.controller.release;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HumanoidController {

	public static void main(String...strings){
		
		JFrame frame = new JFrame();
		JPanel s = new PanelServo(7,90);
		frame.add(s);
		frame.setSize(900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
}
