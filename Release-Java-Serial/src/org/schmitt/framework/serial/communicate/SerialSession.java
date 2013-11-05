package org.schmitt.framework.serial.communicate;

/*
 * 
 *	Desenvolvido por: João Pedro Schmitt 
 * 
 *  Este código contém a assinatura da
 *  implementação Genérica que as Factorys
 *  devem implementar como meio de padronização
 *  e melhoria de expanção para outros tipos
 *  de comunicação
 *  
 */

public interface SerialSession {

	public void close() throws SerialPortException;
	public void open() throws SerialPortException;
	
	public void write(String msg) throws SerialPortException;
	public String readMsg() throws SerialPortException;
	
}