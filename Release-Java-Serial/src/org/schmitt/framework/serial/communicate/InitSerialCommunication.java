package org.schmitt.framework.serial.communicate;

/*
 * 
 *	Desenvolvido por: Jo�o Pedro Schmitt 
 * 
 *  Este c�digo apresenta o uso da API que desenvolvi para facilitar
 *  a comunica��o serial com o Ardu�no, estou escrevendo valores no
 *  padr�o ASCII
 *  
 *  
 */
public class InitSerialCommunication {

	public static void main(String[] args){
		/*
		 * Aqui dou inicio a minha sess�o serial, me baseei no framework Hibernate
		 * para essa comunica��o, passo a porta que vou usar, a taxa de comunica��o
		 * e o tempo de atividade da thread que ficar� escutando as leituras seriais
		 */
		SerialSession serial = new SerialFactory("COM17", 9600, 10000000);
		
		int i = 91;
		
		try {
			/*
			 * Inicio a minha sess�o serial 
			 */
			serial.open();
			while(true){
				
				/*
				 * Crio um delay de modo a n�o elevar o processamento do 
				 * computador 
				 */
				Thread.sleep(500);
				/*
				 * Escrevo o valor de i que � codificado no padr�o ASCII 
				 */
				serial.write("teste");
				if(i == 110){
					serial.close();
					break;
				}else{
					i++;
				}
				
				/*
				 * Imprimo as leituras que eu receber necess�rio um loop
				 * de execu��o continua 
				 */
				System.out.println(serial.readMsg());
			}
		} catch (SerialPortException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
