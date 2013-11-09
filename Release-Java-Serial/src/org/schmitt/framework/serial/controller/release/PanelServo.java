package org.schmitt.framework.serial.controller.release;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private int centroX;
	private int centroY;
	
	public PanelServo(int servo, double angulation){
		super();
		this._setServoNumerate(servo);
		this._setServoAngulation(angulation);
		this._setServoIdentification(new JLabel("Servo: " + this._getServoNumerate()));
		this._setServoSliderAngulation(new JSlider(0,180));
		this._setServoLabelAngulation(new JLabel("000"));
		this._setServoRepresentate(new DrawServo());
		//this._getServoRepresentate().drawServo(this._getServoAngulation(),
		//		this._getServoNumerate(), this.getCentroX(), this.getCentroY(), 100);
		
		super.getControllersPanel().add(this._getServoIdentification());
		super.getControllersPanel().add(this._getServoSliderAngulation());
		super.getControllersPanel().add(this._getServoLabelAngulation());
		
		//this.add(this._getServoRepresentate());
		
		this._getServoSliderAngulation().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider)e.getSource();
			    if (!source.getValueIsAdjusting()) {
			    	_setServoAngulation(_getServoSliderAngulation().getValue());
					_getServoLabelAngulation().setText(_getServoAngulation()+"º");
					try { 
						_getSession().write(contraintLetter());
					} catch(Exception er) {
						JOptionPane.showMessageDialog(null, "Please check your connections with COM port, and try connect again!");
					}
					_getServoRepresentate().setAngulation(_getServoAngulation());
					_getServoRepresentate().repaint();
			    }
			}
		});
		
	}
	
	public String contraintLetter(){
		return "S:" + this._getServoNumerate() + ";A:" + this._getServoAngulation() + ";";
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
	public JLabel _getServoIdentification() { return servoIdentification; }
	public void _setServoIdentification(JLabel servoIdentification) { this.servoIdentification = servoIdentification; }
	public int getCentroX() { return centroX; }
	public void setCentroX(int centroX) { this.centroX = centroX; }
	public int getCentroY() { return centroY; }
	public void setCentroY(int centroY) { this.centroY = centroY; }
	
}
