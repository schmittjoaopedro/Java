package edu.arduino.communicate;

/*
 * 
 *	Desenvolvido por: João Pedro Schmitt 
 * 
 *  Este código apresenta o uso da API que desenvolvi para facilitar
 *  a comunicação serial com o Arduíno, estou escrevendo valores no
 *  padrão ASCII
 *  
 *  
 */
public class InitSerialCommunication {

	public static void main(String[] args){
		/*
		 * Aqui dou inicio a minha sessão serial, me baseei no framework Hibernate
		 * para essa comunicação, passo a porta que vou usar, a taxa de comunicação
		 * e o tempo de atividade da thread que ficará escutando as leituras seriais
		 */
		SerialSession serial = new SerialFactory("COM5", 9600, 10000000);
		
		int i = 91;
		
		try {
			/*
			 * Inicio a minha sessão serial 
			 */
			serial.open();
			while(true){
				
				/*
				 * Crio um delay de modo a não elevar o processamento do 
				 * computador 
				 */
				Thread.sleep(500);
				/*
				 * Escrevo o valor de i que é codificado no padrão ASCII 
				 */
				serial.write("teste");
				if(i == 110){
					serial.close();
					break;
				}else{
					i++;
				}
				
				/*
				 * Imprimo as leituras que eu receber necessário um loop
				 * de execução continua 
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
