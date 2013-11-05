package org.schmitt.framework.serial.controller;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class DrawServo extends JPanel {

	public int angulation = 90;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawOval(240, 240, 20, 20);
		DrawRadius.drawRadius(g2d,
				angulation,
				250,
				250,
				100);
	}
	
	
}
