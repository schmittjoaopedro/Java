package org.schmitt.framework.serial.controller.release;

import java.awt.GridLayout;

import javax.swing.JPanel;

public abstract class AbstractController extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	GridLayout gridLayout;

	public AbstractController(){
		this.setGridLayout(new GridLayout(0,2,5,10));
		this.setLayout(this.getGridLayout());
	}

	protected GridLayout getGridLayout() {
		return gridLayout;
	}

	protected void setGridLayout(GridLayout layout) {
		this.gridLayout = layout;
	}
	
}
