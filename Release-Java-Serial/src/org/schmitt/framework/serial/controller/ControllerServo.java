package org.schmitt.framework.serial.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.schmitt.framework.serial.communicate.SerialPortException;
import org.schmitt.framework.serial.communicate.SerialSession;


public class ControllerServo {

	private SerialSession serialSession;
	private ControllersPanel controller;
	private DrawServo drawServo;
	
	public ControllerServo(ControllersPanel actions,
			SerialSession serial,
			final JTextArea area,
			DrawServo radius){
		this.setSerialSession(serial);
		this.setController(actions);
		this.drawServo = radius;
		this.getController().getOpenSerialJButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					serialSession.open();
					getController().getOpenSerialJButton().setBackground(Color.green);
					getController().getCloseSerialJButton().setBackground(Color.lightGray);
				} catch (SerialPortException e1) {
					getController().getOpenSerialJButton().setBackground(Color.red);
					getController().getCloseSerialJButton().setBackground(Color.lightGray);
					e1.printStackTrace();
				}
			}
		});
		
		this.getController().getCloseSerialJButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					serialSession.close();
					getController().getOpenSerialJButton().setBackground(Color.lightGray);
					getController().getCloseSerialJButton().setBackground(Color.green);
				} catch (SerialPortException e1) {
					e1.printStackTrace();
					getController().getOpenSerialJButton().setBackground(Color.lightGray);
					getController().getCloseSerialJButton().setBackground(Color.red);
				}
			}
		});
		

		this.getController().getAngulationSlider().addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider)e.getSource();
			    if (!source.getValueIsAdjusting()) {
			        String msg = "S:" + getController().getServosPoints().getSelectedItem().toString()
							+ ";A:" + getAngulation() + ";";
			        try {serialSession.write(msg); } catch(Exception er){ er.printStackTrace(); } 
					area.append("Servo " + getController().getServosPoints().getSelectedItem().toString() 
							+ " moved: " + getAngulation() + "\n");
					drawServo.angulation = getAngulation();
					drawServo.repaint();
			    }
			}
		});
		
		
		
	}
	
	//Getters and setters...
	
	public int getAngulation(){
		this.getController().getCurrentAngulation()
				.setText(String.valueOf(getController()
				.getAngulationSlider().getValue()));
		return getController()
				.getAngulationSlider()
				.getValue();
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
