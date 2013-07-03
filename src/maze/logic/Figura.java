package maze.logic;

import java.io.Serializable;

/**  
 * Figura.java - classe que cria um objecto do tipo Figura, que pode representar uma "pe�a" do jogo (heroi,drag�o,espada)
 * @author  grupo 2
 */ 
public abstract class Figura implements Serializable{


	private static final long serialVersionUID = 1L;
	protected int x, y;
	protected char forma;


	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

	public void setX(int x_new){
		this.x = x_new;
	}

	public void setY(int y_new){
		this.y = y_new;
	}

	public char getForma(){
		return forma;
	}

	public void setForma(char s){
		this.forma = s;
	}
}