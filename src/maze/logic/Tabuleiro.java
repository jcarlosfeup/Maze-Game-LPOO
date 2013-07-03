package maze.logic;

import java.io.Serializable;

import maze.cli.MazeCLI;


/**  
 * Tabuleiro.java - classe que cria um objecto Tabuleiro
 * @author  Grupo 2
 */ 
public class Tabuleiro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private MazeCLI data = new MazeCLI();
	private char[][] celulas;
	
	
	public char[][] getCelulas() {
		return celulas;
	}

	public void mostra_tabuleiro(){
		data.mostra_tabuleiro(this);
	}
	
	public Tabuleiro(int comp){
		CriaTabuleiro j= new CriaTabuleiro();
		setTabuleiro(j.geraTabuleiro(comp));
	}
	
	public  char getCelula(int x, int y)
	{
		return celulas[y][x];
	}
	
	
	public void setCelula(int x, int y, char s)
	{
		celulas[y][x] = s;
	}
	
	public void setTabuleiro(char[][] celulas){
		this.celulas = celulas;
	}
	
}