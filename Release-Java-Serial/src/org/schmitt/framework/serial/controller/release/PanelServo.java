package org.schmitt.framework.serial.controller.release;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelServo extends AbstractPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int servoNumerate;
	private double servoAngulation;
	private DrawServo servoRepresentate;
	private JSlider servoSliderAngulation;
	private JLabel servoLabelAngulation;
	private JLabel servoIdentification;
	
	public PanelServo(int servo, double angulation){
		
		this._setServoNumerate(servo);
		this._setServoAngulation(angulation);
		this._setServoSliderAngulation(new JSlider());
		this._setServoLabelAngulation(new JLabel());
		this._setServoIdentification(new JLabel("Servo: " + this._getServoNumerate()));
		
		this._getServoSliderAngulation().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				_setServoAngulation(_getServoSliderAngulation().getValue());
			}
		});
		
	}
	
	
	public DrawServo _getServoRepresentate() { return servoRepresentate; }
	public void _setServoRepresentate(DrawServo servoRepresentate) { this.servoRepresentate = servoRepresentate; }
	public double _getServoAngulation() { return servoAngulation; }
	public void _setServoAngulation(double servoAngulation) { this.servoAngulation = servoAngulation; }
	public int _getServoNumerate() { return servoNumerate; }
	public void _setServoNumerate(int servoNumerate) { this.servoNumerate = servoNumerate; }
	public JSlider _getServoSliderAngulation() { return servoSliderAngulation; }
	public void _setServoSliderAngulation(JSlider servoSliderAngulation) { this.servoSliderAngulation = servoSliderAngulation; }
	public JLabel _getServoLabelAngulation() { return servoLabelAngulation; }
	public void _setServoLabelAngulation(JLabel servoLabelAngulation) { this.servoLabelAngulation = servoLabelAngulation; }
	public JLabel getServoIdentification() { return servoIdentification; }
	public void _setServoIdentification(JLabel servoIdentification) { this.servoIdentification = servoIdentification; }
	
}
