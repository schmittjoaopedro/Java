package edu.arduino.controller;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import edu.arduino.communicate.SerialFactory;
import edu.arduino.communicate.SerialSession;

public class ControllerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextArea serialReadJTextArea = new JTextArea(20, 20);
	private SerialSession serialSession;
	private ControllerServo controllerServo;
	private ControllersPanel controllerPanel;
	
	public ControllerFrame(){
		this.setSerialSession(new SerialFactory("COM5", 9600, 1000000));
		this.setControllerPanel(new ControllersPanel());
		this.setControllerServo(new ControllerServo(this.getControllerPanel(), this.getSerialSession(),this.getSerialReadJTextArea()));
		this.setLayout(new BorderLayout());
		this.add(this.getControllerPanel(), BorderLayout.NORTH);
		this.add(this.getSerialReadJTextArea(), BorderLayout.CENTER);
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public JTextArea getSerialReadJTextArea() {
		return serialReadJTextArea;
	}

	public void setSerialReadJTextArea(JTextArea serialReadJTextArea) {
		this.serialReadJTextArea = serialReadJTextArea;
	}

	public SerialSession getSerialSession() {
		return serialSession;
	}

	public void setSerialSession(SerialSession serialSession) {
		this.serialSession = serialSession;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ControllerServo getControllerServo() {
		return controllerServo;
	}

	public void setControllerServo(ControllerServo controllerServo) {
		this.controllerServo = controllerServo;
	}

	public ControllersPanel getControllerPanel() {
		return controllerPanel;
	}

	public void setControllerPanel(ControllersPanel controllerPanel) {
		this.controllerPanel = controllerPanel;
	}
	
}
