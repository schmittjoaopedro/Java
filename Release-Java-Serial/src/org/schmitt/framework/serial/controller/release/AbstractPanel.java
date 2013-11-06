package org.schmitt.framework.serial.controller.release;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import org.schmitt.framework.serial.communicate.GetSessionSerial;
import org.schmitt.framework.serial.communicate.SerialSession;

public abstract class AbstractPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel controllersPanel;
	private JPanel displayPanel;
	
	public AbstractPanel(){
		this.setLayout(new BorderLayout());
		
		this.setControllersPanel(new JPanel());
		this.setDisplayPanel(new JPanel());
		
		this.add(this.getControllersPanel(), BorderLayout.NORTH);
		this.add(this.getControllersPanel(), BorderLayout.CENTER);
	}

	protected SerialSession _getSession(){
		return GetSessionSerial.getInstance();
	}
	
	public JPanel getControllersPanel() { return controllersPanel; }
	public void setControllersPanel(JPanel controllersPanel) { this.controllersPanel = controllersPanel; }
	public JPanel getDisplayPanel() { return displayPanel; }
	public void setDisplayPanel(JPanel displayPanel) { this.displayPanel = displayPanel; }
	
}
