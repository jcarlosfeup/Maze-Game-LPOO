package maze.logic;

import java.io.Serializable;


/**  
 * Heroi.java - classe que cria um objecto do tipo Heroi que é uma sub-classe de Figura
 * @author  grupo 2
 */ 
public class Heroi extends Figura implements Serializable{

	private static final long serialVersionUID = 1L;

	public Heroi(int x, int y){
		this.x = x;
		this.y = y;
		this.forma= 'H';
	}

}