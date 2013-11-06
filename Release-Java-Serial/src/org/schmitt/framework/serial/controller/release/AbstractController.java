package org.schmitt.framework.serial.controller.release;

import org.schmitt.framework.serial.communicate.SerialSession;

public abstract class AbstractController {

	private SerialSession mySerialSession;
	
	public AbstractController(SerialSession mySerialSession){
		this.setSerialSession(mySerialSession);
	}

	public SerialSession getSerialSession() {
		return mySerialSession;
	}

	public void setSerialSession(SerialSession mySerialSession) {
		this.mySerialSession = mySerialSession;
	}
	
}
