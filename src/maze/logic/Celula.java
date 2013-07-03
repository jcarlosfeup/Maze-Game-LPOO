package maze.logic;

import java.io.Serializable;



/**  
 * Celula.java - classe que cria um objecto Celula
 * @author  Grupo 2
 */ 
public class Celula implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x, y;

	/**  
	 * Construtor de uma Celula
	 *  
	 */  
	public Celula(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int new_x){
		this.x = new_x;

	}
	public void setY(int new_y){
		this.y = new_y;
	}
}