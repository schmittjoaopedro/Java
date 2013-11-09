package org.schmitt.framework.serial.communicate;

public class GetSessionSerial {

	private static SerialSession session;
	public static String selectedCom = "";
	
	static {
		try{
			session = new SerialFactory("COM17", 9600, 1000000);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static SerialSession getInstance(String com){
		session = new SerialFactory(com, 9600, 1000000);
		return session;
	}
	
	public static SerialSession getInstance(){
		return session;
	}

}
