package maze.logic;

import java.io.Serializable;



/**  
 * Espada.java - classe que cria um objecto do tipo Espada que é uma sub-classe de Figura
 * @author  grupo 2
 */ 
public class Espada extends Figura implements Serializable{

	private static final long serialVersionUID = 1L;

	public Espada(int x, int y){
		this.x = x;
		this.y = y;
		this.forma= 'E';
	}


}