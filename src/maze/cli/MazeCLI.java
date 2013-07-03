package maze.cli;
import java.io.Serializable;
import java.util.Scanner;

import maze.logic.Tabuleiro;


/**  
 * MazeCLI.java - classe que possui os métodos responsáveis pelo jogo em si
 * @author  Grupo 2
 */ 
public class MazeCLI implements Serializable {


	private static final long serialVersionUID = 1L;

	public MazeCLI() {
	}

	/**
	 * Apresenta a o tabuleiro (constituido por simbolos) no ecrã 
	 * @param tabuleiro, objecto do tipo Tabuleiro
	 */
	public void mostra_tabuleiro(Tabuleiro tabuleiro)
	{
		char[][] celulas = tabuleiro.getCelulas();

		for(int i = 0;i < celulas.length;i++)
		{
			for(int j = 0;j < celulas[0].length; j++)
			{
				System.out.print(celulas[i][j]);
				System.out.print(' ');
			}
			System.out.print('\n');
		}

	}

	public int num_dragao(){
		System.out.print("Indique o numero de dragões que deseja: ");
		Scanner input = new Scanner( System.in );
		int  n = input.nextInt(); 
		return n;
	}

	public int mens_inicial(){
		System.out.print("BEM-VINDO\n");
		System.out.print("Indique o nº de células de comprimento e altura que pretende que o seu labirinto tenha: ");
		Scanner input = new Scanner( System.in );
		int  n = input.nextInt(); 
		return n;
	}

	public String direcao(){
		System.out.print("Nova direcção (cima/baixo/direita/equerda): ");
		Scanner input = new Scanner( System.in );
		String n = input.nextLine();
		return n;
	}

	public void repeticao(){
		System.out.print("Decisão invalida.\n");
	}

	public void ganhar(){
		System.out.print("Parabens ganhou...\n");
	}

	public void perder()
	{
		System.out.print("Perdeu...\n");
	}

	public int menu_inicial(){
		System.out.print("1-Dragao parado\n");
		System.out.print("2-Dragao com movimeno aleatorio\n");
		System.out.print("3-Dragão com movimentação aleatória intercalada com dormir\n");
		System.out.print("Opção: ");
		Scanner input = new Scanner( System.in );
		int  n = input.nextInt(); 
		return n;

	}

}