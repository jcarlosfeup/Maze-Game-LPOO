package maze.logic;

import java.io.Serializable;


/**  
* Dragao.java - classe que cria um objecto do tipo Dragao que é uma sub-classe de Figura
* @author  grupo 2
*/ 

public class Dragao extends Figura implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	public Dragao(int x, int y){
		this.x = x;
		this.y = y;
		this.forma= 'D';
	}
	
	
}