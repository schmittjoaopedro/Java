package org.schmitt.framework.serial.communicate;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

/*
 * 
 *	Desenvolvido por: Jo�o Pedro Schmitt 
 * 
 *  Este c�digo cont�m a implementa��o da API que faz
 *  a comunica��o com o Ardu�no, por�m pode-se usar
 *  esta API com qualquer dispositivo que se comunique
 *  serial
 *  
 */

public class SerialFactory implements SerialSession {

	/*
	 *  Vari�vel objeto porta
	 */
	SerialPort port;
	
	/*
	 *  Vari�vel que ser� lido pela Serial
	 */
	private String msg;

	/*
	 *  Variavel para tempo de vida da thread de leitura
	 */
	private final int TIME_ALIVE;

	/* 
	 * Nome da porta que escutar� a comunica��o
	 */
	private final String PORT_NAME;

	/*
	 * Servi�o de Buffer para leitura da serial
	 */
	private BufferedReader input;
	
	/* 
	 * Servi�o de Buffer para escrita na serial
	 */
	private OutputStream output;

	/* 
	 * Vari�vel de time-out para espera da conex�o
	 */
	private static final int TIME_OUT = 2000;
	
	/* 
	 * Vari�vel que armazena o taxa de transmiss�o (normalmente 9600 bauds)
	 */
	private final int DATA_RATE;

	/* 
	 * Inicia��o pelo construtor de vari�veis chaves para comunica��o
	 */
	public SerialFactory(String SERIAL_PORT, int DATA_RATE,
			int TIME_ALIVE_THREAD) {
		this.PORT_NAME = SERIAL_PORT;
		this.DATA_RATE = DATA_RATE;
		this.TIME_ALIVE = TIME_ALIVE_THREAD;
	}

	/* 
	 * Metodo para fechar a conex�o atual
	 */
	@Override
	public synchronized void close() throws SerialPortException {
		if (port != null) {
			port.removeEventListener();
			port.close();
			try{
				input.close();
				output.close();
			}catch(IOException er){
				throw new SerialPortException("Error do close output and input");
			}
		}
	}
	
	/* 
	 * M�todo de abertura da conex�o
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void open() throws SerialPortException {

		/* 
		 * Busca todas portas dispon�veis no computador
		 */
		CommPortIdentifier portId = null;
		Enumeration<CommPortIdentifier> portEnum = null;
		try {
			portEnum = CommPortIdentifier.getPortIdentifiers();
		} catch (Exception er) {
			throw new SerialPortException(er);
		}
		/* 
		 * Verifica se alguma porta corresponde a porta especificada como sendo do Ardu�no
		 */
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currentPortId = (CommPortIdentifier) portEnum
					.nextElement();
			if (currentPortId.getName().equals(PORT_NAME)) {
				portId = currentPortId;
				break;
			}
		}
		/* 
		 * Se n�o houver nenhuma lan�a uma exce��o aplicada a esta
		 * de porta n�o encontrada
		 */
		if (portId == null) {
			throw new SerialPortException("Could not find COM port");
		}
		/* 
		 * Tenta abrir a comunica��o com a porta Serial
		 */
		try {
			// open serial port, and use class name for the appName.
			port = (SerialPort) portId
					.open(this.getClass().getName(), TIME_OUT);

			/* 
			 * Defini��es para porta (PARITY_NONE permite comunica��o bidirecional)
			 */
			port.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

			/* 
			 * Inicia o objeto de leitura
			 */
			input = new BufferedReader(new InputStreamReader(
					port.getInputStream()));
			/* 
			 * Inicia o objeto de escrita
			 */
			output = port.getOutputStream();

			/* 
			 * Adiciona ao eventListener para escutar as leituras
			 */
			port.addEventListener(this);
			/* 
			 * Define que deve-se notificar quando ter dados a serem lidos
			 */
			port.notifyOnDataAvailable(true);
			
		} catch (Exception er) {
			throw new SerialPortException(er);
		}
		Thread t = new Thread() {
			public void run() {
				/*
				 * Define o tempo de vida da escuta para porta serial
				 */
				try {
					Thread.sleep(TIME_ALIVE);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		};
		/* 
		 * Inicia a thread de escuta
		 */
		t.start();
		System.out.println("Started");
	}

	/* 
	 * M�todo para enviar informa��es via serial
	 */
	@Override
	public synchronized void write(String msg) throws SerialPortException {
		try{
			//output.write(Integer.parseInt(msg));
			output.write(msg.getBytes());
			output.flush();
		}catch(Exception e){
			throw new SerialPortException(e);
		}
	}

	/* 
	 * M�todo para ler as mensagens recebidas
	 */
	@Override
	public String readMsg() throws SerialPortException {
		return this.msg;
	}

	/* 
	 * Evento de escuta da interface serial
	 */
	@Override
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		/* 
		 * Se h� dados dispon�veis faz a leitura
		 */
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				this.msg = input.readLine();
			} catch (Exception er) {
				System.out.print(er.getMessage());
			}
		}
	}

}
