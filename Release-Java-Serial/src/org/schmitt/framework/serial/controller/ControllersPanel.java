package org.schmitt.framework.serial.controller;

import java.awt.Color;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ControllersPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static final int FPS_MIN = 0;
	static final int FPS_MAX = 180;
	static final int FPS_INIT = 90; 
	
	String[] servos = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
			"16","17","18","19","20"};
	private JComboBox<String> servosPoints = new JComboBox<String>(servos);
	private JSlider angulationSlider = new JSlider(JSlider.HORIZONTAL,FPS_MIN, FPS_MAX, FPS_INIT);
	private JButton openSerialJButton = new JButton("Open Connection");
	private JButton closeSerialJButton = new JButton("Close Connection");
	private JLabel currentAngulation = new JLabel(String.valueOf(FPS_INIT));
	
	public ControllersPanel(){
		
		this.add(this.getOpenSerialJButton());
		this.add(this.getCloseSerialJButton());
		this.add(new Label("Select your servo"));
		this.add(this.getServosPoints());
		this.add(new Label("Angulation"));
		this.add(this.getAngulationSlider());
		this.add(this.getCurrentAngulation());
		this.getOpenSerialJButton().setBackground(Color.lightGray);
		this.getCloseSerialJButton().setBackground(Color.lightGray);
		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JButton getOpenSerialJButton() {
		return openSerialJButton;
	}

	public void setOpenSerialJButton(JButton openSerialJButton) {
		this.openSerialJButton = openSerialJButton;
	}

	public JButton getCloseSerialJButton() {
		return closeSerialJButton;
	}

	public void setCloseSerialJButton(JButton closeSerialJButton) {
		this.closeSerialJButton = closeSerialJButton;
	}

	public JComboBox<String> getServosPoints() {
		return servosPoints;
	}

	public void setServosPoints(JComboBox<String> servosPoints) {
		this.servosPoints = servosPoints;
	}

	public JSlider getAngulationSlider() {
		return angulationSlider;
	}

	public void setAngulationSlider(JSlider angulationSlider) {
		this.angulationSlider = angulationSlider;
	}

	public JLabel getCurrentAngulation() {
		return currentAngulation;
	}

	public void setCurrentAngulation(JLabel currentAngulation) {
		this.currentAngulation = currentAngulation;
	}
	
}
