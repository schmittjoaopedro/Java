package edu.arduino.controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ControllersPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton servo1JButton = new JButton("Servo 1");
	private JButton servo2JButton = new JButton("Servo 2");
	private JButton servo3JButton = new JButton("Servo 3");
	private JLabel angulationLabel= new JLabel("Inform angulation to rotate");
	private JSpinner angulationJSpinner = new JSpinner(new SpinnerNumberModel(0,0,999,1));
	private JButton openSerialJButton = new JButton("Open Connection");
	private JButton closeSerialJButton = new JButton("Colse Connection");
	
	public ControllersPanel(){
		
		this.add(this.getOpenSerialJButton());
		this.add(this.getCloseSerialJButton());
		this.add(this.getServo1JButton());
		this.add(this.getServo2JButton());
		this.add(this.getServo3JButton());
		this.add(this.getAngulationLabel());
		this.add(this.getAngulationJSpinner());
		
	}

	public JButton getServo1JButton() {
		return servo1JButton;
	}

	public void setServo1JButton(JButton servo1jButton) {
		servo1JButton = servo1jButton;
	}

	public JButton getServo2JButton() {
		return servo2JButton;
	}

	public void setServo2JButton(JButton servo2jButton) {
		servo2JButton = servo2jButton;
	}

	public JButton getServo3JButton() {
		return servo3JButton;
	}

	public void setServo3JButton(JButton servo3jButton) {
		servo3JButton = servo3jButton;
	}

	public JLabel getAngulationLabel() {
		return angulationLabel;
	}

	public void setAngulationLabel(JLabel angulationLabel) {
		this.angulationLabel = angulationLabel;
	}

	public JSpinner getAngulationJSpinner() {
		return angulationJSpinner;
	}

	public void setAngulationJSpinner(JSpinner angulationJSpinner) {
		this.angulationJSpinner = angulationJSpinner;
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
	
}
