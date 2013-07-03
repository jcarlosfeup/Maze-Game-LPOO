package maze.cli;

import maze.logic.Jogo;


/**  
 * main.java - classe responsável pela interface básica com o utilizador
 * @author  Grupo 2
 */ 
class Main {

	public static void main(String args[]) {
		MazeCLI m = new MazeCLI();
		int n, tipo_jogo, num_dragoes;
		
		//"Abre" o menu inicial
		n = m.mens_inicial();
		num_dragoes = m.num_dragao();
		Jogo j = new Jogo(n, num_dragoes);
		tipo_jogo = m.menu_inicial();
		while (true) {

			while (true) {
				j.mostra_tabuleiro();
				String d = m.direcao();
				n = j.move_heroi(d);
				if (n != -1)
					break;
				m.repeticao();
			}

			if (n == 1) {
				m.ganhar();
				break;
			}
			//Jogo com Dragao parado
			if (tipo_jogo == 2)
				j.move_dragao(false);
			if (tipo_jogo == 3)
				j.move_dragao(true);
			n = j.encontro();
			if (n == 0) {
				m.perder();
				break;
			}

			n = j.fight();
			if (n == 0) {
				j.mostra_tabuleiro();
				m.perder();
				break;
			}
		}

	}

};
