package org.schmitt.framework.serial.controller.release;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DrawServo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final double TWO_PI = 2.0 * Math.PI;
	private double angulation;
	private int servoIndentification;
	private int centerX;
	private int centerY;
	private int diameter;

	public DrawServo(){
		this.setBorder(BorderFactory.createLineBorder(Color.red, 2));
	}
	
	public void drawServo(double angulation, int servo, int centerX, int centerY, int diameter){
		this.setAngulation(angulation);
		this.setServoIndentification(servo);
		this.setCenterX(centerX);
		this.setCenterY(centerY);
		this.setDiameter(diameter);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		this.setAngulation(this.getAngulation()/360);
		double radians = (0.5 - this.getAngulation()) * TWO_PI;
		double sine = Math.sin(radians);
		double cosine = Math.cos(radians);
		int dxMax = this.getCenterX() + (int) (this.getDiameter() * sine);
		int dyMax = this.getCenterY() + (int) (this.getDiameter() * cosine);
		g2d.drawLine(this.getCenterX(), this.getCenterY(), dxMax, dyMax);
	}

	
	
	public double getAngulation() { return angulation; }
	public void setAngulation(double angulation) { this.angulation = angulation; }
	public int getServoIndentification() { return servoIndentification; }
	public void setServoIndentification(int servoIndentification) { this.servoIndentification = servoIndentification; }
	public int getCenterX() { return centerX; }
	public void setCenterX(int centerX) { this.centerX = centerX; }
	public int getCenterY() { return centerY; }
	public void setCenterY(int centerY) { this.centerY = centerY; }
	public int getDiameter() { return diameter; }
	public void setDiameter(int diameter) { this.diameter = diameter; }

}
