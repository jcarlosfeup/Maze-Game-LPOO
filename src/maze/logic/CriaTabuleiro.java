package maze.logic;

import java.util.Stack;
import java.util.Vector;



/**  
 * CriaTabuleiro.java - classe responsável por criar aleatoriamente a matriz correspondente a um tabuleiro
 * @author  grupo 2
 */ 

public class CriaTabuleiro {


	public char [][] geraTabuleiro(int comp){
		int x, y, aleat, x_new, y_new;
		x_new = 0;
		y_new = 0;
		boolean celula_valida;
		char[][] tabuleiro;
		tabuleiro = new char[comp][comp];
		for(int i = 0; i<comp; i++){
			for(int j = 0; j<comp; j++){
				tabuleiro[i][j] = 'X';
			}
		}
		//Coloca as paredes com o simbolo '+' para nao serem destruidas
		for(int i = 0; i<comp; i++){
			tabuleiro[0][i] = '+';
			tabuleiro[i][0] = '+';
			tabuleiro[comp-1][i] = '+';
			tabuleiro[i][comp-1] = '+';
		}

		//cria um vector de inteiros onde guarda as diferentes direçoes
		Vector<Integer> hipotese = new Vector<Integer>();
		hipotese.addElement(new Integer(0));
		hipotese.addElement(new Integer(1));
		hipotese.addElement(new Integer(2));
		hipotese.addElement(new Integer(3));
		Vector<Integer> vec = new Vector<Integer>();

		x = 1;
		y = 1;
		tabuleiro[y][x] = ' ';

		//responsavel por guardar o caminho percorrido
		Stack<Celula> caminho = new Stack<Celula>();
		caminho.push(new Celula(x,y));


		while(! caminho.isEmpty())
		{
			vec.clear();
			vec.addElement(new Integer(0));
			vec.addElement(new Integer(1));
			vec.addElement(new Integer(2));
			vec.addElement(new Integer(3));
			celula_valida = true;



			while(!vec.isEmpty() && celula_valida){
				y_new = y;
				x_new = x;
				aleat = (int)(Math.random() * vec.size());
				switch(vec.elementAt(aleat)){
				case 0:
					y_new = y+1;
					break;
				case 1:
					y_new = y-1;
					break;
				case 2:
					x_new = x-1;
					break;
				case 3:
					x_new = x+1;
					break;
				}
				if(tabuleiro[y_new][x_new] == '+' || 
						tabuleiro[y_new][x_new] == ' ' || 
						(tabuleiro[y_new-1][x_new] == ' ' && tabuleiro[y_new-1][x_new + 1] == ' ' && tabuleiro[y_new][x_new + 1] == ' ' )|| 
						(tabuleiro[y_new+1][x_new] == ' ' && tabuleiro[y_new+1][x_new + 1] == ' ' && tabuleiro[y_new][x_new + 1] == ' ') ||
						(tabuleiro[y_new+1][x_new] == ' ' && tabuleiro[y_new+1][x_new - 1] == ' ' && tabuleiro[y_new][x_new - 1] == ' ') ||
						(tabuleiro[y_new][x_new-1] == ' ' && tabuleiro[y_new-1][x_new - 1] == ' ' && tabuleiro[y_new-1][x_new] == ' ')
				)
				{
					vec.remove(aleat);
				}else
				{
					celula_valida = false;
				}
			}


			if(celula_valida == false){
				x = x_new;
				y = y_new;
				tabuleiro[y][x] = ' ';
				caminho.push(new Celula(x,y));
			}


			if(vec.size() == 0){
				x = caminho.peek().getX();
				y = caminho.peek().getY();
				caminho.pop();	
			}
		}

		//reconstroi a parede do tabuleiro
		for(int i = 0; i<comp; i++){
			tabuleiro[0][i] = 'X';
			tabuleiro[i][0] = 'X';
			tabuleiro[comp-1][i] = 'X';
			tabuleiro[i][comp-1] = 'X';
		}
		return tabuleiro;

	}
}
