package org.schmitt.framework.serial.controller.release;

import javax.swing.JFrame;

public class MainScreen {

	public static void main(String[] args){
		
		JFrame frame = new JFrame();
		frame.add(new HumanoidController());
		frame.setSize(1200, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
