package org.schmitt.framework.serial.communicate;

import gnu.io.SerialPortEventListener;

/*
 * 
 *	Desenvolvido por: Jo�o Pedro Schmitt 
 * 
 *  Este c�digo cont�m a assinatura da
 *  implementa��o Gen�rica que as Factorys
 *  devem implementar como meio de padroniza��o
 *  e melhoria de expan��o para outros tipos
 *  de comunica��o
 *  
 */

public interface SerialSession extends SerialPortEventListener {

	public void close() throws SerialPortException;
	public void open() throws SerialPortException;
	
	public void write(String msg) throws SerialPortException;
	public String readMsg() throws SerialPortException;
	
}