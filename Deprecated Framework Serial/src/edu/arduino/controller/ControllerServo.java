package edu.arduino.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import edu.arduino.communicate.SerialPortException;
import edu.arduino.communicate.SerialSession;

public class ControllerServo {

	private SerialSession serialSession;
	private ControllersPanel controller;
	
	public ControllerServo(ControllersPanel actions, SerialSession serial, final JTextArea area){
		this.setSerialSession(serial);
		this.setController(actions);
		
		this.getController().getOpenSerialJButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					serialSession.open();
					getController().getOpenSerialJButton().setBackground(Color.green);
				} catch (SerialPortException e1) {
					getController().getOpenSerialJButton().setBackground(Color.red);
					e1.printStackTrace();
				}
			}
		});
		
		this.getController().getCloseSerialJButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					serialSession.close();
				} catch (SerialPortException e1) {
					e1.printStackTrace();
				}
			}
		});
		

		
		this.getController().getServo1JButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String msg = "S:7;A:" + getAngulation() + ";";
					serialSession.write(msg);
					area.append("Servo 7 moved: " + getAngulation() + "\n");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	//Getters and setters...
	
	public int getAngulation(){
		return Integer.parseInt(getController()
				.getAngulationJSpinner()
				.getValue().toString());
	}
	
	public SerialSession getSerialSession() {
		return serialSession;
	}

	public void setSerialSession(SerialSession serialSession) {
		this.serialSession = serialSession;
	}

	public ControllersPanel getController() {
		return controller;
	}

	public void setController(ControllersPanel controller) {
		this.controller = controller;
	}
	
}
