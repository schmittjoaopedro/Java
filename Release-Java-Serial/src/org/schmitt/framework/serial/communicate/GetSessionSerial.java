package org.schmitt.framework.serial.communicate;

public class GetSessionSerial {

	private static SerialSession session;
	
	static {
		try{
			session = new SerialFactory("COM17", 9600, 1000000);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static SerialSession getInstance(){
		return session;
	}
	
}
