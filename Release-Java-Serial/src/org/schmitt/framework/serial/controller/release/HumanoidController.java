package org.schmitt.framework.serial.controller.release;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.schmitt.framework.serial.communicate.GetSessionSerial;
import org.schmitt.framework.serial.communicate.SerialPortException;

public class HumanoidController extends AbstractController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		List<PanelServo> panelsServo;
		JButton openSerial;
		JButton closeSerial;
		
		public HumanoidController(){
			super();
			this.setOpenSerial(new JButton("Open Serial"));
			this.setCloseSerial(new JButton("Close Serial"));
			this.setPanelsServo(new ArrayList<PanelServo>());
			
			//Initialization panels servos...
			panelsServo.add(new PanelServo(7,90));
			panelsServo.add(new PanelServo(8, 90));
			panelsServo.add(new PanelServo(9, 90));
			panelsServo.add(new PanelServo(10, 90));
			
			this.add(this.getOpenSerial());
			this.add(this.getCloseSerial());

			for(PanelServo panel : this.getPanelsServo()){
				this.add(panel);
			}
			
			getOpenSerial().setBackground(Color.LIGHT_GRAY);
			getCloseSerial().setBackground(Color.LIGHT_GRAY);
			
			this.getOpenSerial().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						GetSessionSerial.getInstance().open();
						getOpenSerial().setBackground(Color.GREEN);
					} catch (SerialPortException e1) {
						getOpenSerial().setBackground(Color.RED);
						JOptionPane.showMessageDialog(null, "Please check your connections with COM port");
					}
					getCloseSerial().setBackground(Color.LIGHT_GRAY);
				}
			});
			
			this.getCloseSerial().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						GetSessionSerial.getInstance().close();
						getCloseSerial().setBackground(Color.GREEN);
					} catch (SerialPortException e1) {
						getCloseSerial().setBackground(Color.RED);
						JOptionPane.showMessageDialog(null, "Error in try close connection");
					}
					getOpenSerial().setBackground(Color.LIGHT_GRAY);
				}
			});
			
		}

		public List<PanelServo> getPanelsServo() {
			return panelsServo;
		}

		public void setPanelsServo(ArrayList<PanelServo> panels) {
			this.panelsServo = panels;
		}

		public JButton getOpenSerial() {
			return openSerial;
		}

		public void setOpenSerial(JButton openSerial) {
			this.openSerial = openSerial;
		}

		public JButton getCloseSerial() {
			return closeSerial;
		}

		public void setCloseSerial(JButton closeSerial) {
			this.closeSerial = closeSerial;
		}
		
}
